package com.hanyu.luckychild.ui.login;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.ui.BaseActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

@EActivity(R.layout.activity_reg)
public class RegisterActivity extends BaseActivity {

	@ViewById
	EditText et_phone;
	@ViewById
	EditText et_code;
	@ViewById
	EditText et_pwd;
	@ViewById
	EditText et_c_pwd;
	@ViewById
	EditText et_job;
	@ViewById
	TextView tv_reg;
	@ViewById
	ImageView iv_back;
	
	@Override
	public void initView() {

	}

	@Override
	public void initData() {

	}

	@Override
	public void initListener() {

	}
	
	@Click(R.id.iv_back)
	public void back(){
		finish();
	}
	
	@Click(R.id.tv_reg)
	public void Register(){
		String phone = et_phone.getText().toString().trim();
		String code = et_code.getText().toString().trim();
		String pwd = et_pwd.getText().toString().trim();
		String cPwd = et_c_pwd.getText().toString().trim();
		String job = et_job.getText().toString().trim();
		
		
		
		Intent intent = new Intent(this, LoginActivity_.class);
		startActivity(intent);
		this.finish();
	}
	
	

}
