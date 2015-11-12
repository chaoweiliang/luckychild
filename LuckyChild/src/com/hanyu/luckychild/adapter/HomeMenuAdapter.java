package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeMenuAdapter extends BaseAdapter {
	private String[] titles = { "今日回访", "订单处理", "代客下单", "商品管理", "营销中心", "会员统计", "订单统计", "结算中心" };
	private Integer[] pics = { R.drawable.sy_36, R.drawable.sy_38, R.drawable.sy_41, R.drawable.sy_43, R.drawable.sy_50,
			R.drawable.sy_52, R.drawable.sy_53, R.drawable.sy_54 };

	private Context context;

	public HomeMenuAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return titles.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = View.inflate(context, R.layout.item_home_menu, null);
		ImageView iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
		TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
		iv_image.setImageResource(pics[position]);
		tv_title.setText(titles[position]);
		return convertView;
	}

}
