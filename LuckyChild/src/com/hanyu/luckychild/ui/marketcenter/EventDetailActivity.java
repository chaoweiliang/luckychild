package com.hanyu.luckychild.ui.marketcenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.EventDetailAdapter;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.ui.menu.MarketCenterActivity_;
import com.hanyu.luckychild.view.NoScrollListView;

import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

@EActivity(R.layout.activity_event_detail)
public class EventDetailActivity extends BaseActivity {
	@ViewById
	ImageView iv_left;
	@ViewById
	TextView tv_title;
	@ViewById
	TextView tv_commit;
	@ViewById
	TextView tv_status;
	@ViewById
	NoScrollListView list_view;
	@ViewById
	LinearLayout ll_bottom_menu;
	@ViewById
	LinearLayout ll_parent;
	// 类型
	@Extra
	int type;

	@AfterViews
	public void init() {
		iv_left.setVisibility(View.VISIBLE);
		iv_left.setImageResource(R.drawable.mx_03);
		tv_title.setText("活动详情");

		setData();
		setListener();
	}

	private void setData() {
		list_view.setAdapter(new EventDetailAdapter(this));

		switch (type) {
		case MarketCenterActivity_.CURRENT_EVENT:

			break;
		case MarketCenterActivity_.WAIT_START_EVENT:
			tv_commit.setText("发货");
			break;
		case MarketCenterActivity_.HISTORY_EVENT:
			ll_bottom_menu.setVisibility(View.GONE);
			tv_status.setText("待收货");
			break;
		}
	}

	private void setListener() {

	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}

	@Click(R.id.tv_commit)
	public void commit() {
		switch (type) {
		case MarketCenterActivity_.CURRENT_EVENT:
//			DialogUtils.showPopup(this, "您的申请已提交到后台，等待审核，审核通过后，该活动将自动停止", ll_parent);
			PopupWindow popup = new PopupWindow(this);
			View view = View.inflate(this, R.layout.popup_view, null);
			TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
			tv_msg.setText("您的申请已提交到后台，等待审核，审核通过后，该活动将自动停止");
			popup.setContentView(view);
//			popup.setBackgroundDrawable(new BitmapDrawable());
//			popup.setOutsideTouchable(true);
			popup.showAtLocation(ll_parent, Gravity.CENTER, 0, 0);
			break;
		}
	}

}
