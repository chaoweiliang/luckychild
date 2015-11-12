package com.hanyu.luckychild.adapter;

import com.hanyu.luckychild.ui.fragment.FragmentFactory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class HomePagerAdapter extends FragmentPagerAdapter {

	public HomePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Fragment getItem(int arg0) {
		return FragmentFactory.getFragment(arg0);
	}
	
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
	}

}
