package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailAdapter extends BaseAdapter {

	private Context context;

	public EventDetailAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.event_detail_item, null);
		}

		return convertView;
	}

	static class ViewHolder {
		TextView tv_title, tv_old_price, tv_price;
		ImageView iv_image;

		private ViewHolder(View convertView) {
			tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			tv_price = (TextView) convertView.findViewById(R.id.tv_price);
			iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
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
