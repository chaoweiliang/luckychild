package com.hanyu.luckychild.ui.order;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.OrderDetailAdapter;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.ui.menu.OrderActivity_;
import com.hanyu.luckychild.utils.DialogUtils;
import com.hanyu.luckychild.utils.DialogUtils.MyClickListener;
import com.hanyu.luckychild.view.NoScrollListView;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@EActivity(R.layout.activity_order_detail)
public class OrderDetailActivity extends BaseActivity {
	@ViewById
	ImageView iv_left;
	@ViewById
	TextView tv_title;
	@ViewById
	TextView tv_commit;
	@ViewById
	TextView tv_cancel;
	@ViewById
	TextView tv_status;
	@ViewById
	NoScrollListView list_view;
	@ViewById
	LinearLayout ll_bottom_menu;

	// 类型
	@Extra
	int type;

	@AfterViews
	public void init() {
		iv_left.setVisibility(View.VISIBLE);
		iv_left.setImageResource(R.drawable.mx_03);
		tv_title.setText("订单详情");

		setData();
		setListener();
	}

	private void setData() {
		list_view.setAdapter(new OrderDetailAdapter(this));

		switch (type) {
		case OrderActivity_.WAIT_COMMIT:
			break;
		case OrderActivity_.WAIT_SEND:
			tv_commit.setText("发货");
			tv_cancel.setText("打印订单");
			tv_status.setText("待发货");
			break;
		case OrderActivity_.WAIT_GET:
			ll_bottom_menu.setVisibility(View.GONE);
			tv_status.setText("待收货");
			break;
		case OrderActivity_.ORDER_FINISH:
			ll_bottom_menu.setVisibility(View.GONE);
			tv_status.setText("已签收");
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
		case OrderActivity_.WAIT_COMMIT:
			// 确认订单
			DialogUtils.showDialog(this,"您确定要确认订单吗？", new MyClickListener() {

				@Override
				public void onCommit(Dialog dialog) {
					dialog.dismiss();
				}

				@Override
				public void onCancel(Dialog dialog) {
					dialog.dismiss();
				}
			});
			break;
		case OrderActivity_.WAIT_SEND:
			// 发货
			DialogUtils.showDialog(this,"您确定要发货吗？", new MyClickListener() {
 
				@Override
				public void onCommit(Dialog dialog) {
					dialog.dismiss();
				}

				@Override
				public void onCancel(Dialog dialog) {
					dialog.dismiss();
				}
			});
			break;
		}
	}

	@Click(R.id.tv_cancel)
	public void cancel() {
		switch (type) {
		case OrderActivity_.WAIT_COMMIT:
			// 取消订单
			DialogUtils.showDialog(this,"您确定要取消订单吗？", new MyClickListener() {

				@Override
				public void onCommit(Dialog dialog) {
					dialog.dismiss();
				}

				@Override
				public void onCancel(Dialog dialog) {
					dialog.dismiss();
				}
			});
			break;
		case OrderActivity_.WAIT_SEND:
			// 打印订单

			break;
		}
	}
}
