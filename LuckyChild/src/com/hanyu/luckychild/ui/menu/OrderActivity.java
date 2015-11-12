package com.hanyu.luckychild.ui.menu;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.ui.order.CodeOrderActivity_;
import com.hanyu.luckychild.ui.order.FinishOrder;
import com.hanyu.luckychild.ui.order.WaitCommit;
import com.hanyu.luckychild.ui.order.WaitGet;
import com.hanyu.luckychild.ui.order.WaitSend;

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

@EActivity(R.layout.activity_order)
public class OrderActivity extends BaseActivity {

	@ViewById
	TextView tv_wait_commit;
	@ViewById
	TextView tv_wait_send;
	@ViewById
	TextView tv_wait_get;
	@ViewById
	TextView tv_finish;
	@ViewById
	View indicator_line;
	@ViewById(R.id.view_pager)
	ViewPager view_pager;
	@ViewById(R.id.et_search)
	EditText et_search;
	@ViewById
	ImageView iv_back;
	@ViewById
	ImageView iv_right;

	private View WaitCommitView, WaitSendView, WaitGetView, FinishView;// 待确认，待发货，待收货，已完成

	public static final int WAIT_COMMIT = 1;// 待确认
	public static final int WAIT_SEND = 2;// 待发货
	public static final int WAIT_GET = 3;// 待收货
	public static final int ORDER_FINISH = 4;// 已完成

	private List<View> list = new ArrayList<View>();

	@AfterViews
	public void init() {
		iv_right.setVisibility(View.VISIBLE);
		iv_right.setImageResource(R.drawable.dd_03);

		if (WaitCommitView == null) {
			WaitCommitView = new WaitCommit(this).getView();
			list.add(WaitCommitView);
		}
		if (WaitSendView == null) {
			WaitSendView = new WaitSend(this).getView();
			list.add(WaitSendView);
		}
		if (WaitGetView == null) {
			WaitGetView = new WaitGet(this).getView();
			list.add(WaitGetView);
		}
		if (FinishView == null) {
			FinishView = new FinishOrder(this).getView();
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
		lineWidth = screenWidth / 4;

		indicator_line.getLayoutParams().width = lineWidth;
		indicator_line.requestLayout();
	}

	@SuppressWarnings("deprecation")
	private void setListener() {
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
	}

	private void setData() {

	}

	@Click(R.id.iv_back)
	public void back() {
		finish();
	}

	@Click(R.id.tv_wait_commit)
	public void changePage1() {
		view_pager.setCurrentItem(0);
	}

	@Click(R.id.tv_wait_send)
	public void changePage2() {
		view_pager.setCurrentItem(1);
	}

	@Click(R.id.tv_wait_get)
	public void changePage3() {
		view_pager.setCurrentItem(2);
	}

	@Click(R.id.tv_finish)
	public void changePage4() {
		view_pager.setCurrentItem(3);
	}

	@Click(R.id.iv_right)
	public void codeOrder() {
		Intent intent = new Intent(this, CodeOrderActivity_.class);
		startActivity(intent);
	}
}
