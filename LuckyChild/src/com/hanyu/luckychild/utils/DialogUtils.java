package com.hanyu.luckychild.utils;

import com.hanyu.luckychild.R;
import com.hanyu.luckychild.global.MyApplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

public class DialogUtils {

	public static void showDialog(Context context, String msg, final MyClickListener listener) {
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = View.inflate(context, R.layout.confirm_dialog, null);
		TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
		TextView tv_commit = (TextView) view.findViewById(R.id.tv_commit);
		TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
		tv_msg.setText(msg);
		dialog.setContentView(view);

		if (listener != null) {
			tv_commit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					listener.onCommit(dialog);
				}
			});

			tv_cancel.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					listener.onCancel(dialog);
				}
			});
		}

		WindowManager.LayoutParams p = dialog.getWindow().getAttributes(); // 获取对话框当前的参数值
		p.width = (int) (MyApplication.mScreenWidth * 0.6); // 高度设置为屏幕的0.6
		dialog.getWindow().setAttributes(p);

		dialog.show();
	}

	@SuppressWarnings("deprecation")
	public static void showPopup(Context context, String msg, View parent) {
		PopupWindow popup = new PopupWindow(context);
		View view = View.inflate(context, R.layout.popup_view, null);
		TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
		tv_msg.setText(msg);
		popup.setContentView(view);
		popup.setBackgroundDrawable(new BitmapDrawable());
		popup.setOutsideTouchable(true);
		popup.showAtLocation(parent, Gravity.CENTER, 0, 0);
	}

	public interface MyClickListener {
		public void onCommit(Dialog dialog);

		public void onCancel(Dialog dialog);
	}
}
