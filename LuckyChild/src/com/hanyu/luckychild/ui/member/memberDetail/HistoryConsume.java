package com.hanyu.luckychild.ui.member.memberDetail;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.HistoryConsumeAdapter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
/**
 * 历史消费
 * @author Administrator
 *
 */
public class HistoryConsume {
	private Context context;
	private ListView list_view;

	public HistoryConsume(Context context) {
		this.context = context;
	}

	public View getView() {
		View view = View.inflate(context, R.layout.history_consume, null);
		list_view = (ListView) view.findViewById(R.id.list_view);
		initData();
		initListener();
		return view;
	}

	private void initData() {
		list_view.setAdapter(new HistoryConsumeAdapter(context));
		
	}

	private void initListener() {
		
	}
}
