package com.hanyu.luckychild.ui.fragment;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

public class FragmentFactory {
	private static SparseArray<Fragment> map = new SparseArray<Fragment>();

	public static Fragment getFragment(int position) {
		Fragment fragment = map.get(position);
		switch (position) {
		case 0:
			// 首页
			if (fragment == null) {
				fragment = new HomeFragment();
				map.put(position, fragment);
			}
			break;
		case 1:
			// 会员
			if (fragment == null) {
				fragment = new VipFragment();
				map.put(position, fragment);
			}
			break;
		case 2:
			// 订单
			if (fragment == null) {
				fragment = new OrderFragment();
				map.put(position, fragment);
			}
			break;
		case 3:
			// 我的
			if (fragment == null) {
				fragment = new MineFragment();
				map.put(position, fragment);
			}
			break;
		}
		return fragment;

	}
}
