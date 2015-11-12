package com.hanyu.luckychild.ui.member.memberDetail;

import com.hanyu.luckychild.R;

import android.content.Context;
import android.view.View;
/**
 * 会员详情
 * @author Administrator
 *
 */
public class MemberDetail {
	private Context context;

	public MemberDetail(Context context) {
		this.context = context;
	}

	public View getView() {
		View view = View.inflate(context, R.layout.member_detail, null);
		initData();
		initListener();
		return view;
	}

	private void initData() {

	}

	private void initListener() {
		
	}
}
