package com.hanyu.luckychild.ui.member;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.ui.member.memberDetail.HistoryConsume;
import com.hanyu.luckychild.ui.member.memberDetail.MemberDetail;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@EActivity(R.layout.activity_member_detail)
public class MemberDetailActivity extends BaseActivity {

	@ViewById
	ImageView iv_left;
	@ViewById
	TextView tv_member_detail;
	@ViewById
	TextView tv_his_consume;
	@ViewById
	View indicator_line;
	@ViewById
	ViewPager view_pager;
	@ViewById
	TextView tv_title;

	@AfterViews
	public void init() {
		tv_title.setText("会员详细信息");
		iv_left.setImageResource(R.drawable.mx_03);
		iv_left.setVisibility(View.VISIBLE);
		setData();
		setListener();
	}

	private List<View> list = new ArrayList<View>();
	private View MemberDetailView, HistoryConsumeView;

	private void setData() {
		if (MemberDetailView == null) {
			MemberDetailView = new MemberDetail(this).getView();
			list.add(MemberDetailView);
		}
		if (HistoryConsumeView == null) {
			HistoryConsumeView = new HistoryConsume(this).getView();
			list.add(HistoryConsumeView);
		}

		view_pager.setAdapter(new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return list == null ? 0 : list.size();
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
		@SuppressWarnings("deprecation")
		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		lineWidth = screenWidth / 2;
		indicator_line.getLayoutParams().width = lineWidth;
		indicator_line.requestLayout();
	}

	@SuppressWarnings("deprecation")
	public void setListener() {

		initIndicatorWidth();
		view_pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				tv_member_detail.setTextColor(
						arg0 == 0 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_his_consume.setTextColor(
						arg0 == 1 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				int l = positionOffsetPixels / 2;
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
	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}
	@Click(R.id.tv_member_detail)
	public void left() {
		view_pager.setCurrentItem(0);
	}
	@Click(R.id.tv_his_consume)
	public void right() {
		view_pager.setCurrentItem(1);
	}
}
