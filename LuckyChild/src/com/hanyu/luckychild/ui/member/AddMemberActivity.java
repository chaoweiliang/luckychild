package com.hanyu.luckychild.ui.member;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;
import com.hanyu.luckychild.utils.DialogUtils;
import com.hanyu.luckychild.utils.DialogUtils.MyClickListener;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 添加会员
 * 
 * @author Administrator
 *
 */
@EActivity(R.layout.activity_add_member)
public class AddMemberActivity extends BaseActivity {
	@ViewById
	TextView tv_commit;
	@ViewById
	TextView tv_title;
	@ViewById
	ImageView iv_left;

	@AfterViews
	public void init() {
		iv_left.setImageResource(R.drawable.mx_03);
		iv_left.setVisibility(View.VISIBLE);
		tv_title.setText("新增会员");
	}

	@Click(R.id.tv_commit)
	public void commit() {
		DialogUtils.showDialog(this, "您确定要新增该会员吗？", new MyClickListener() {

			@Override
			public void onCommit(Dialog dialog) {
				dialog.dismiss();
			}

			@Override
			public void onCancel(Dialog dialog) {
				dialog.dismiss();
			}
		});
	}

	@Click(R.id.iv_left)
	public void back() {
		finish();
	}
}
