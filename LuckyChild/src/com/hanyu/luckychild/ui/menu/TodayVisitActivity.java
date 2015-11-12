package com.hanyu.luckychild.ui.menu;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.ui.visit.HisVisit;
import com.hanyu.luckychild.ui.visit.TodayVisit;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@EActivity(R.layout.activity_today_visit)
public class TodayVisitActivity extends BaseActivity {

	@ViewById
	TextView tv_today_visit;
	@ViewById
	TextView tv_his_visit;
	@ViewById
	View indicator_line;
	@ViewById(R.id.view_pager)
	ViewPager view_pager;
	@ViewById(R.id.et_search)
	EditText et_search;
	@ViewById
	ImageView iv_back;

	private View todayVisitView, hisVisitView;

	private List<View> list = new ArrayList<View>();

	@AfterViews
	public void init() {
		if (todayVisitView == null) {
			todayVisitView = new TodayVisit(this).getView();
			list.add(todayVisitView);
		}
		if (hisVisitView == null) {
			hisVisitView = new HisVisit(this).getView();
			list.add(hisVisitView);
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
				container.addView(list.get(position));
				return list.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView((View) object);
			}
		});

		setData();
		setListener();
	}

	private int lineWidth;
	private void initIndicatorWidth() {
		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		lineWidth = screenWidth / 2;

		indicator_line.getLayoutParams().width = lineWidth;
		indicator_line.requestLayout();
	}

	@SuppressWarnings("deprecation")
	private void setListener() {
		initIndicatorWidth();
		view_pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				tv_today_visit.setTextColor(arg0 == 0?getResources().getColor(R.color.green):getResources().getColor(R.color.black));
				tv_his_visit.setTextColor(arg0 == 1?getResources().getColor(R.color.green):getResources().getColor(R.color.black));
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

	private void setData() {

	}
	@Click(R.id.iv_back)
	public void back(){
		finish();
	}
	
	@Click(R.id.tv_today_visit)
	public void changePage1(){
		view_pager.setCurrentItem(0);
	}
	@Click(R.id.tv_his_visit)
	public void changePage2(){
		view_pager.setCurrentItem(1);
	}
}
