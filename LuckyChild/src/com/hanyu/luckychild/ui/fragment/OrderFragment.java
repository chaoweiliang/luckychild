package com.hanyu.luckychild.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.order.FinishOrder;
import com.hanyu.luckychild.ui.order.WaitCommit;
import com.hanyu.luckychild.ui.order.WaitGet;
import com.hanyu.luckychild.ui.order.WaitSend;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderFragment extends BaseFragment {

	TextView tv_wait_commit;
	TextView tv_wait_send;
	TextView tv_wait_get;
	TextView tv_finish;
	View indicator_line;
	ViewPager view_pager;
	EditText et_search;
	ImageView iv_back;
	ImageView iv_right;

	private View WaitCommitView, WaitSendView, WaitGetView, FinishView;// 待确认，待发货，待收货，已完成

	public static final int WAIT_COMMIT = 1;// 待确认
	public static final int WAIT_SEND = 2;// 待发货
	public static final int WAIT_GET = 3;// 待收货
	public static final int ORDER_FINISH = 4;// 已完成

	private List<View> list = new ArrayList<View>();

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_wait_commit:
			view_pager.setCurrentItem(0);
			break;
		case R.id.tv_wait_send:
			view_pager.setCurrentItem(1);
			break;
		case R.id.tv_wait_get:
			view_pager.setCurrentItem(2);
			break;
		case R.id.tv_finish:
			view_pager.setCurrentItem(3);
			break;
		}
	}

	@Override
	protected void getData(onLoadingFinishListener listener) {
		listener.onLoadingFinish(LOADING_SUCCESS);
	}

	@Override
	protected View onSuccess() {
		View view = View.inflate(getActivity(), R.layout.fragment_order, null);
		tv_wait_commit  = (TextView) view.findViewById(R.id.tv_wait_commit);
		tv_wait_send  = (TextView) view.findViewById(R.id.tv_wait_send);
		tv_wait_get  = (TextView) view.findViewById(R.id.tv_wait_get);
		tv_finish  = (TextView) view.findViewById(R.id.tv_finish);
		indicator_line  =  view.findViewById(R.id.indicator_line);
		view_pager  = (ViewPager) view.findViewById(R.id.view_pager);
		et_search  = (EditText) view.findViewById(R.id.et_search);
		iv_back  = (ImageView) view.findViewById(R.id.iv_back);
		iv_right  = (ImageView) view.findViewById(R.id.iv_right);
		return view;
	}

	@Override
	protected void initData() {
		iv_right.setVisibility(View.VISIBLE);
		iv_right.setImageResource(R.drawable.dd_03);

		if (WaitCommitView == null) {
			WaitCommitView = new WaitCommit(getActivity()).getView();
			list.add(WaitCommitView);
		}
		if (WaitSendView == null) {
			WaitSendView = new WaitSend(getActivity()).getView();
			list.add(WaitSendView);
		}
		if (WaitGetView == null) {
			WaitGetView = new WaitGet(getActivity()).getView();
			list.add(WaitGetView);
		}
		if (FinishView == null) {
			FinishView = new FinishOrder(getActivity()).getView();
			list.add(FinishView);
		}

		view_pager.setAdapter(new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return list.size();
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.removeView(list.get(position));
				container.addView(list.get(position));
				return list.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView((View) object);
			}
		});

	}

	private int lineWidth;

	private void initIndicatorWidth() {
		int screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
		lineWidth = screenWidth / 4;

		indicator_line.getLayoutParams().width = lineWidth;
		indicator_line.requestLayout();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void initListener() {
		initIndicatorWidth();
		view_pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				tv_wait_commit.setTextColor(
						arg0 == 0 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_wait_send.setTextColor(
						arg0 == 1 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_wait_get.setTextColor(
						arg0 == 2 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_finish.setTextColor(
						arg0 == 3 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				int l = positionOffsetPixels / 4;
				int newl = l + position * lineWidth;
				LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) indicator_line
						.getLayoutParams();
				params.leftMargin = newl;
				indicator_line.setLayoutParams(params);
				indicator_line.requestLayout();
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		
		tv_wait_commit.setOnClickListener(this);
		tv_wait_send.setOnClickListener(this);
		tv_wait_get.setOnClickListener(this);
		tv_finish.setOnClickListener(this);
		
		
	}

}
