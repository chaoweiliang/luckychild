package com.hanyu.luckychild.utils;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IndicatorUtils {
	@SuppressWarnings("deprecation")
	public static void setIndicator(Context context, ViewPager viewPager, final LinearLayout ll_indicator) {
		for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
			ImageView view = new ImageView(context);
			if (i == 0) {
				view.setBackgroundResource(R.drawable.tz_23);
			} else {
				view.setBackgroundResource(R.drawable.tz_21);
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT);
				params.leftMargin = 10;
				view.setLayoutParams(params);
			}
			ll_indicator.addView(view);
		}
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				for (int i = 0; i < ll_indicator.getChildCount(); i++) {
					ImageView view = (ImageView) ll_indicator.getChildAt(i);
					if (i == arg0) {
						view.setBackgroundResource(R.drawable.tz_23);
					} else {
						view.setBackgroundResource(R.drawable.tz_21);
					}
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}
}
