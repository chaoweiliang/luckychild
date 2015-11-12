package com.hanyu.luckychild.ui.order;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.OrderDetailAdapter;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.utils.DialogUtils;
import com.hanyu.luckychild.utils.DialogUtils.MyClickListener;
import com.hanyu.luckychild.view.NoScrollListView;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@EActivity(R.layout.activity_code_order)
public class CodeOrderActivity extends BaseActivity {
	@ViewById
	TextView tv_commit;
	@ViewById
	TextView tv_search;
	@ViewById
	TextView tv_title;
	@ViewById
	ImageView iv_left;
	@ViewById
	LinearLayout ll_search_content;
	@ViewById
	NoScrollListView list_view;

	@AfterViews
	public void init() {
		tv_title.setText("收货验证码");
		iv_left.setVisibility(View.VISIBLE);
		iv_left.setImageResource(R.drawable.mx_03);

	}

	@Click(R.id.tv_search)
	public void search() {
		ll_search_content.setVisibility(View.VISIBLE);
		list_view.setAdapter(new OrderDetailAdapter(this));
	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}
	@Click(R.id.tv_commit)
	public void commit() {
		DialogUtils.showDialog(this,"您确定要确认收货吗？", new MyClickListener() {

			@Override
			public void onCommit(Dialog dialog) {
				dialog.dismiss();
			}

			@Override
			public void onCancel(Dialog dialog) {
				dialog.dismiss();
			}
		});
	}

}
