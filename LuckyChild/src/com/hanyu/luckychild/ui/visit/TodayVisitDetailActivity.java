package com.hanyu.luckychild.ui.visit;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

@EActivity(R.layout.activity_today_visit_detail)
public class TodayVisitDetailActivity extends BaseActivity {
	@ViewById
	TextView tv_title;
	@ViewById
	ImageView iv_left;

	@AfterViews
	public void init() {
		tv_title.setText("今日回访明细");
		iv_left.setVisibility(View.VISIBLE);
		iv_left.setImageResource(R.drawable.mx_03);
	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}
	
}
