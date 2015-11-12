package com.hanyu.luckychild.utils;

import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

public class PinYinUtils {
	public static String getLetter(String text) {
		String result = PinyinHelper.convertToPinyinString(text, "",
				PinyinFormat.WITHOUT_TONE).toUpperCase();
		return result.substring(0, 1);
	}
}
