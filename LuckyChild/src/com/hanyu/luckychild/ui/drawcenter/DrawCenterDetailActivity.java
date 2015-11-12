package com.hanyu.luckychild.ui.drawcenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 结算中心
 * @author Administrator
 *
 */
@EActivity(R.layout.activity_draw_center_detail)
public class DrawCenterDetailActivity extends BaseActivity {
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
		tv_title.setText("结算中心");

		setData();
		setListener();
	}

	private void setData() {
	}

	private void setListener() {

	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}
}
