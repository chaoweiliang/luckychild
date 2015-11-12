package com.hanyu.luckychild.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.member.AddMemberActivity_;
import com.hanyu.luckychild.ui.member.AllMember;
import com.hanyu.luckychild.ui.member.MemberTotal;
import com.hanyu.luckychild.ui.member.NewMember;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VipFragment extends BaseFragment {
	TextView tv_new_member;
	TextView tv_all_member;
	TextView tv_member_statistics;
	View indicator_line;
	ViewPager view_pager;
	EditText et_search;
	ImageView iv_back;
	ImageView iv_right;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_new_member:
			view_pager.setCurrentItem(0);
			break;
		case R.id.tv_all_member:
			view_pager.setCurrentItem(1);
			break;
		case R.id.tv_member_statistics:
			view_pager.setCurrentItem(2);
			break;
		case R.id.iv_right:
			Intent intent = new Intent(getActivity(), AddMemberActivity_.class);
			startActivity(intent);
			break;
		}
	}

	@Override
	protected void getData(onLoadingFinishListener listener) {
		listener.onLoadingFinish(LOADING_SUCCESS);
	}

	@Override
	protected View onSuccess() {
		View view = View.inflate(getActivity(), R.layout.fragment_vip, null);
		tv_new_member = (TextView) view.findViewById(R.id.tv_new_member);
		tv_all_member = (TextView) view.findViewById(R.id.tv_all_member);
		tv_member_statistics = (TextView) view.findViewById(R.id.tv_member_statistics);
		indicator_line = view.findViewById(R.id.indicator_line);
		view_pager = (ViewPager) view.findViewById(R.id.view_pager);
		et_search = (EditText) view.findViewById(R.id.et_search);
		iv_back = (ImageView) view.findViewById(R.id.iv_back);
		iv_right = (ImageView) view.findViewById(R.id.iv_right);
		return view;
	}

	private View NewMemberView, AllMemberView, MemberTotalView;// 新会员，所有会员，会员统计
	private List<View> list = new ArrayList<View>();

	@Override
	protected void initData() {
		if (NewMemberView == null) {
			NewMemberView = new NewMember(getActivity()).getView();
			list.add(NewMemberView);
		}
		if (AllMemberView == null) {
			AllMemberView = new AllMember(getActivity()).getView();
			list.add(AllMemberView);
		}
		if (MemberTotalView == null) {
			MemberTotalView = new MemberTotal(getActivity()).getView();
			list.add(MemberTotalView);
		}
		
		view_pager.setOffscreenPageLimit(3);

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
		lineWidth = screenWidth / 3;

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
				tv_new_member.setTextColor(
						arg0 == 0 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_all_member.setTextColor(
						arg0 == 1 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_member_statistics.setTextColor(
						arg0 == 2 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				int l = positionOffsetPixels / 3;
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

		tv_new_member.setOnClickListener(this);
		tv_all_member.setOnClickListener(this);
		tv_member_statistics.setOnClickListener(this);
		iv_right.setOnClickListener(this);
	}

}
