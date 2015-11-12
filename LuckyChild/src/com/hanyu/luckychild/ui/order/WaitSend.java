package com.hanyu.luckychild.ui.order;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.OrderAdapter;
import com.hanyu.luckychild.ui.menu.OrderActivity_;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 待确认
 * 
 * @author Administrator
 *
 */
public class WaitSend {
	private Context context;
	private ListView list_view;

	public WaitSend(Context context) {
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
		list_view.setAdapter(new OrderAdapter(context));

	}

	private void initListener() {
		list_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Intent intent = new Intent(context, OrderDetailActivity_.class);
				intent.putExtra("type", OrderActivity_.WAIT_SEND);
				context.startActivity(intent);
			}
		});
	}
}
