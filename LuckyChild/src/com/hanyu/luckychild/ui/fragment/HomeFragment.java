package com.hanyu.luckychild.ui.fragment;

import com.hanyu.luckychild.MainActivity;
import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.HeadViewPager;
import com.hanyu.luckychild.adapter.HomeMenuAdapter;
import com.hanyu.luckychild.ui.drawcenter.DrawCenterActivity_;
import com.hanyu.luckychild.ui.menu.MarketCenterActivity_;
import com.hanyu.luckychild.ui.menu.TodayVisitActivity_;
import com.hanyu.luckychild.utils.IndicatorUtils;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeFragment extends BaseFragment {

	ViewPager head_view_pager;
	LinearLayout fragment_sy_point;
	GridView grid_view;
	ImageView iv_left,iv_right;

	@Override
	public void onClick(View v) {

	}

	@Override
	protected void getData(final onLoadingFinishListener listener) {
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(1000);
					listener.onLoadingFinish(LOADING_SUCCESS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	protected View onSuccess() {
		View view = View.inflate(getActivity(), R.layout.fragment_home, null);
		head_view_pager = (ViewPager) view.findViewById(R.id.head_view_pager);
		fragment_sy_point = (LinearLayout) view.findViewById(R.id.fragment_sy_point);
		grid_view = (GridView) view.findViewById(R.id.grid_view);
		iv_left = (ImageView) view.findViewById(R.id.iv_left);
		iv_right = (ImageView) view.findViewById(R.id.iv_right);
		iv_left.setVisibility(View.VISIBLE);
		iv_right.setVisibility(View.VISIBLE);
		return view;
	}

	@Override
	protected void initData() {
		head_view_pager.setAdapter(new HeadViewPager(getActivity()));
		IndicatorUtils.setIndicator(getActivity(), head_view_pager, fragment_sy_point);

		grid_view.setAdapter(new HomeMenuAdapter(getActivity()));
	}

	private Intent intent;

	@Override
	protected void initListener() {
		grid_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				switch (arg2) {
				case 0:
					//今日来访
					intent = new Intent(getActivity(), TodayVisitActivity_.class);
					startActivity(intent);
					break;
				case 1:
					//订单处理
//					intent = new Intent(getActivity(), OrderActivity_.class);
//					startActivity(intent);
					intent = new Intent(MainActivity.CHANGE_PAGE);
					intent.putExtra("page", 2);
					getActivity().sendBroadcast(intent);
					break;
				case 4:
					//营销中心
					intent = new Intent(getActivity(), MarketCenterActivity_.class);
					startActivity(intent);
					break;
				case 5:
					//会员统计
					intent = new Intent(MainActivity.CHANGE_PAGE);
					intent.putExtra("page", 1);
					getActivity().sendBroadcast(intent);
					break;
				case 7:
					//结算中心
					intent = new Intent(getActivity(), DrawCenterActivity_.class);
					startActivity(intent);
					break;
				}
			}
		});
	}

}
