package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MemberAdapter extends BaseAdapter {
	private Context context;

	public MemberAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 5;
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
			convertView = View.inflate(context, R.layout.item_member, null);
		}

		return convertView;
	}

	static class ViewHolder {
		TextView tv_name, tv_phone, tv_level;

		private ViewHolder(View convertView) {
			tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
			tv_level = (TextView) convertView.findViewById(R.id.tv_level);
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
