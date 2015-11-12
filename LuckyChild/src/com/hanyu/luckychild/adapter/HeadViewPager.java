package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HeadViewPager extends PagerAdapter {

	private Integer[] pics = { R.drawable.sy, R.drawable.sy, R.drawable.sy };
	private Context context;

	public HeadViewPager(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return pics.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = View.inflate(context, R.layout.layout_head_view, null);
		ImageView iv_image = (ImageView) view.findViewById(R.id.iv_image);
		iv_image.setImageResource(pics[position]);
		container.addView(view);
		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
