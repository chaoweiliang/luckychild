package com.hanyu.luckychild.ui.drawcenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.DrawCenterAdapter;
import com.hanyu.luckychild.ui.BaseActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 结算中心-选择门店
 * @author Administrator
 *
 */
@EActivity(R.layout.activity_draw_center)
public class DrawCenterActivity extends BaseActivity {
	@ViewById
	ImageView iv_left;
	@ViewById
	TextView tv_title;
	@ViewById
	ListView list_view;

	@AfterViews
	public void init() {
		iv_left.setImageResource(R.drawable.mx_03);
		iv_left.setVisibility(View.VISIBLE);
		tv_title.setText("结算中心-选择门店");

		setData();
		setListener();
	}

	private void setData() {
		list_view.setAdapter(new DrawCenterAdapter(this));
	}

	private void setListener() {
		list_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(DrawCenterActivity.this, DrawCenterDetailActivity_.class);
				startActivity(intent);
			}
		});
	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}
}
