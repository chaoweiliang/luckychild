package com.hanyu.luckychild.ui.fragment;

import org.androidannotations.annotations.EFragment;

import com.hanyu.luckychild.R;

import android.view.View;

@EFragment(R.layout.fragment_mine)
public class MineFragment extends BaseFragment {
	

	@Override
	public void onClick(View v) {

	}

	@Override
	protected void getData(onLoadingFinishListener listener) {
		listener.onLoadingFinish(LOADING_SUCCESS);
	}

	@Override
	protected View onSuccess() {
		View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
		return view;
	}

	@Override
	protected void initData() {

	}
	
	@Override
	protected void initListener() {

	}
	

}
