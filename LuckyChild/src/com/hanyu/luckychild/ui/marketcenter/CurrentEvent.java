package com.hanyu.luckychild.ui.marketcenter;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.MarketCenterAdapter;
import com.hanyu.luckychild.ui.menu.MarketCenterActivity_;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 当前活动
 * 
 * @author Administrator
 *
 */
public class CurrentEvent {
	private Context context;
	private ListView list_view;

	public CurrentEvent(Context context) {
		this.context = context;
	}

	public View getView() {
		View view = View.inflate(context, R.layout.visit_list_view, null);
		list_view = (ListView) view.findViewById(R.id.list_view);
		initData();
		initListener();
		return view;
	}

	private void initData() {
		list_view.setAdapter(new MarketCenterAdapter(context));

	}

	private void initListener() {
		list_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(context, EventDetailActivity_.class);
				intent.putExtra("type", MarketCenterActivity_.CURRENT_EVENT);
				context.startActivity(intent);
			}
		});
	}
}
