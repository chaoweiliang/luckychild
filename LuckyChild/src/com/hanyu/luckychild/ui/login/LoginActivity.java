package com.hanyu.luckychild.ui.login;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.MainActivity;
import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

	@ViewById
	TextView tv_login;
	@ViewById
	EditText et_phone;
	@ViewById
	EditText et_pwd;
	@ViewById
	TextView tv_reg;
	@ViewById
	TextView tv_lost_pwd;

	@Override
	public void initView() {

	}

	@Override
	public void initData() {

	}

	@Override
	public void initListener() {

	}

	@Click(R.id.tv_reg)
	public void register() {
		Intent intent = new Intent(this, RegisterActivity_.class);
		startActivity(intent);
	}

	@Click(R.id.tv_login)
	public void login() {
		String phone = et_phone.getText().toString().trim();
		String pwd = et_pwd.getText().toString().trim();
		if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
			// ToastUtils.show(this, "请检查信息是否填写完整");
		}

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		this.finish();
	}

}
