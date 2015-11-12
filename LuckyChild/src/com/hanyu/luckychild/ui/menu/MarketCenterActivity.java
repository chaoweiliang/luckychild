package com.hanyu.luckychild.ui.menu;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.ui.marketcenter.CurrentEvent;
import com.hanyu.luckychild.ui.marketcenter.HistoryEvent;
import com.hanyu.luckychild.ui.marketcenter.WaitStartEvent;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@EActivity(R.layout.activity_market_center)
public class MarketCenterActivity extends BaseActivity {
	@ViewById
	TextView tv_current;
	@ViewById
	TextView tv_wait_start;
	@ViewById
	TextView tv_history;
	@ViewById
	ImageView iv_back;
	@ViewById
	View indicator_line;
	@ViewById(R.id.view_pager)
	ViewPager view_pager;
	@ViewById(R.id.et_search)
	EditText et_search;

	private List<View> list = new ArrayList<View>();
	private int lineWidth;

	public static final int CURRENT_EVENT = 1;// 当前活动
	public static final int WAIT_START_EVENT = 2;// 未开始活动
	public static final int HISTORY_EVENT = 3;// 历史活动

	private View CurrentView, WaitStartView, HistoryView;

	@AfterViews
	public void init() {

		if (CurrentView == null) {
			CurrentView = new CurrentEvent(this).getView();
			list.add(CurrentView);
		}
		if (WaitStartView == null) {
			WaitStartView = new WaitStartEvent(this).getView();
			list.add(WaitStartView);
		}
		if (HistoryView == null) {
			HistoryView = new HistoryEvent(this).getView();
			list.add(HistoryView);
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

	private void initIndicatorWidth() {
		int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		lineWidth = screenWidth / 3;

		indicator_line.getLayoutParams().width = lineWidth;
		indicator_line.requestLayout();
	}

	@SuppressWarnings("deprecation")
	private void setListener() {
		initIndicatorWidth();
		view_pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				tv_current.setTextColor(
						arg0 == 0 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_wait_start.setTextColor(
						arg0 == 1 ? getResources().getColor(R.color.green) : getResources().getColor(R.color.black));
				tv_history.setTextColor(
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
	}

	@Click(R.id.tv_current)
	public void changePage1() {
		view_pager.setCurrentItem(0);
	}

	@Click(R.id.tv_wait_start)
	public void changePage2() {
		view_pager.setCurrentItem(1);
	}

	@Click(R.id.tv_history)
	public void changePage3() {
		view_pager.setCurrentItem(2);
	}

	@Click(R.id.iv_back)
	public void back() {
		finish();
	}

	private void setData() {

	}
}
