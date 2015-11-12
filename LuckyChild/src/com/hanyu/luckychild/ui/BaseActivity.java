package com.hanyu.luckychild.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public abstract class BaseActivity extends Activity implements OnClickListener {
	protected ImageView iv_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initData();
		initListener();
	}

	public void initView(){
		
	}

	public void initData(){
		
	}

	public void initListener(){
		
	}

	
	@Override
	public void onClick(View v) {
		if (v == iv_back) {
			finish();
			return;
		}

	}

}
