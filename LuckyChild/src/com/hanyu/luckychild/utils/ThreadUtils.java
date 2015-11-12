package com.hanyu.luckychild.utils;

import com.hanyu.luckychild.global.MyApplication;

public class ThreadUtils {
	public static void runInThread(Runnable runnable){
		new Thread(runnable).start();
	}
	
	public static void runInUIThread(Runnable runnable){
		MyApplication.handler.post(runnable);
	}
}
