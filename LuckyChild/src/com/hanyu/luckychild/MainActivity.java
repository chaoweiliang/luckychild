package com.hanyu.luckychild;

import com.hanyu.luckychild.adapter.HomePagerAdapter;
import com.hanyu.luckychild.global.MyApplication;
import com.hanyu.luckychild.view.NoScrollViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	NoScrollViewPager view_pager;
	RadioButton rb_home;
	RadioButton rb_vip;
	RadioButton rb_order;
	RadioButton rb_mine;
	RadioGroup radio_group;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		initView();
		initData();
		initListener();

		MyApplication.mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();

		IntentFilter filter = new IntentFilter(CHANGE_PAGE);
		receiver = new ChangePageReceiver();
		registerReceiver(receiver, filter);
	}

	private ChangePageReceiver receiver;

	class ChangePageReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			int page = arg1.getIntExtra("page", -1);
			if (page != -1) {
				RadioButton rb = (RadioButton) radio_group.getChildAt(page);
				rb.setChecked(true);
			}
		}

	}

	public static final String CHANGE_PAGE = "CHANGE_PAGE_ACTION";

	public void initView() {
		rb_home = (RadioButton) findViewById(R.id.rb_home);
		view_pager = (NoScrollViewPager) findViewById(R.id.view_pager);
		rb_vip = (RadioButton) findViewById(R.id.rb_vip);
		rb_order = (RadioButton) findViewById(R.id.rb_order);
		rb_mine = (RadioButton) findViewById(R.id.rb_mine);
		radio_group = (RadioGroup) findViewById(R.id.radio_group);

	}

	public void initData() {
		view_pager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
	}

	public void initListener() {
		radio_group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					view_pager.setCurrentItem(0, false);
					break;
				case R.id.rb_vip:
					view_pager.setCurrentItem(1, false);
					break;
				case R.id.rb_order:
					view_pager.setCurrentItem(2, false);
					break;
				case R.id.rb_mine:
					view_pager.setCurrentItem(3, false);
					break;
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (receiver != null) {
			unregisterReceiver(receiver);
		}
	}

}
