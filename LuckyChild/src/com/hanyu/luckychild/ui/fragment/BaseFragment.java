package com.hanyu.luckychild.ui.fragment;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.utils.ThreadUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class BaseFragment extends Fragment implements OnClickListener {
	protected View successView;
	private FrameLayout fl_container;
	protected View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (view == null) {
			view = View.inflate(getContext(), R.layout.base_fragment, null);
			fl_container = (FrameLayout) view.findViewById(R.id.fl_container);
			initBaseView();
		}
		return view;
	}

	public static final int LOADING = 0;
	public static final int LOADING_FAIL = 1;
	public static final int LOADING_SUCCESS = 2;
	private int mStatus = LOADING;

	private void initBaseView() {
		if (mStatus == LOADING) {
			fl_container.removeAllViews();
			View loading_View = View.inflate(getContext(), R.layout.layout_loading, null);
			fl_container.addView(loading_View);
		}

		getData(listener);
	};

	private onLoadingFinishListener listener = new onLoadingFinishListener() {

		@Override
		public void onLoadingFinish(final int status) {
			ThreadUtils.runInUIThread(new Runnable() {

				@Override
				public void run() {
					if (status == LOADING_FAIL) {
						fl_container.removeAllViews();
						View loading_error = View.inflate(getContext(), R.layout.layout_loading_error, null);
						fl_container.addView(loading_error);
					} else if (status == LOADING_SUCCESS) {
						fl_container.removeAllViews();
						successView = onSuccess();
						fl_container.addView(successView);
						initData();
						initListener();
					}
				}
			});

		}
	};
	
	protected abstract void getData(onLoadingFinishListener listener);

	protected abstract View onSuccess();

	protected abstract void initData();

	public interface onLoadingFinishListener {
		public void onLoadingFinish(int status);
	}

	protected abstract void initListener();

}
