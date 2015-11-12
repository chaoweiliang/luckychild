package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.adapter.HistoryConsumeAdapter.HeaderViewHolder;
import com.hanyu.luckychild.adapter.HistoryConsumeAdapter.ProductViewHolder;
import com.hanyu.luckychild.view.NoScrollListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HistoryConsumeAdapter extends BaseAdapter {

	private Context context;

	public HistoryConsumeAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 6;
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
		int type = position % 3;
		if (type != 0) {
			type = 1;
		}
		return type;
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
			if (convertView == null) {
				convertView = View.inflate(context, R.layout.item_history_header, null);
			}
			HeaderViewHolder headerHolder = HeaderViewHolder.getHolder(convertView);

			break;
		case CONTENT:
			if (convertView == null) {
				convertView = View.inflate(context, R.layout.item_history_consume, null);
			}

			ViewHolder holder = ViewHolder.getHolder(convertView);
			 holder.list_view.setAdapter(new ProductAdapter());
			break;
		}
		return convertView;
	}

	static class ViewHolder {
		TextView tv_pay_time, tv_price;
		NoScrollListView list_view;

		private ViewHolder(View convertView) {
			tv_pay_time = (TextView) convertView.findViewById(R.id.tv_pay_time);
			tv_price = (TextView) convertView.findViewById(R.id.tv_price);
			list_view = (NoScrollListView) convertView.findViewById(R.id.list_view);
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

	static class HeaderViewHolder {
		TextView tv_title;

		private HeaderViewHolder(View convertView) {
			tv_title = (TextView) convertView.findViewById(R.id.tv_title);
		}

		public static HeaderViewHolder getHolder(View convertView) {
			HeaderViewHolder holder = (HeaderViewHolder) convertView.getTag();
			if (holder == null) {
				holder = new HeaderViewHolder(convertView);
				convertView.setTag(holder);
			}
			return holder;
		}
	}

	class ProductAdapter extends BaseAdapter {

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
				convertView = View.inflate(context, R.layout.item_history_product, null);
			}
			ProductViewHolder holder = ProductViewHolder.getHolder(convertView);

			return convertView;
		}

	}

	static class ProductViewHolder {
		TextView tv_name, tv_number, tv_price;

		private ProductViewHolder(View convertView) {
			tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			tv_number = (TextView) convertView.findViewById(R.id.tv_number);
			tv_price = (TextView) convertView.findViewById(R.id.tv_price);
		}

		public static ProductViewHolder getHolder(View convertView) {
			ProductViewHolder holder = (ProductViewHolder) convertView.getTag();
			if (holder == null) {
				holder = new ProductViewHolder(convertView);
				convertView.setTag(holder);
			}
			return holder;
		}
	}

}
