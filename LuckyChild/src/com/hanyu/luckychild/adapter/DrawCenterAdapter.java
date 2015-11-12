package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawCenterAdapter extends BaseAdapter {

	private Context context;

	public DrawCenterAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 20;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public static final int HEADER = 0;
	public static final int CONTENT = 1;

	@Override
	public int getItemViewType(int position) {
		if (position == 0) {
			return HEADER;
		} else if (position == 2) {
			return HEADER;
		}

		return CONTENT;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);
		switch (type) {
		case HEADER:
			convertView = View.inflate(context, R.layout.item_draw_header, null);
			TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			if (position == 0) {
				tv_title.setText("总店");
			} else {
				tv_title.setText("分店");
			}

			break;
		case CONTENT:
			if (convertView == null) {
				convertView = View.inflate(context, R.layout.item_draw_money, null);
			}

			ViewHolder holder = ViewHolder.getHolder(convertView);
			break;
		}

		return convertView;
	}

	static class ViewHolder {
		TextView tv_name, tv_price, tv_draw_money;

		private ViewHolder(View convertView) {
			tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			tv_price = (TextView) convertView.findViewById(R.id.tv_price);
			tv_draw_money = (TextView) convertView.findViewById(R.id.tv_draw_money);
		}

		public static ViewHolder getHolder(View convertView) {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			if (holder == null) {
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			return holder;
		}
	}

}
