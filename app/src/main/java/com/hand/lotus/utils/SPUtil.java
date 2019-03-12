package com.hand.lotus.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SPUtil {

	public static SharedPreferences getSharedPreferences(Context context) {

		return context.getSharedPreferences("config", Context.MODE_PRIVATE);

	}

	public static String getStringValue(Context context, String key) {

		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getString(key, "");

	}
	public static long getLong(Context context, String key) {

		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getLong(key, 0);

	}


	public static Integer getIntValue(Context context, String key) {

		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getInt(key, 0);

	}

	public static void put(Context context, String key, Object value) {

		SharedPreferences sharedPreferences = getSharedPreferences(context);
		Editor edit = sharedPreferences.edit();
		if (value instanceof String) {
			edit.putString(key, (String) value);
		} else if (value instanceof Integer) {
			edit.putInt(key, (Integer) value);
		} else if (value instanceof Boolean) {
			edit.putBoolean(key, (Boolean) value);
		}else if(value instanceof Long){
			edit.putLong(key, (Long) value);
		}
		edit.commit();
	}

	public static boolean getBoolean(Context context, String isSetupCompleted) {
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		return sharedPreferences.getBoolean(isSetupCompleted, false);

	}

	public static void remove(Context context,String key){
		SharedPreferences sharedPreferences = getSharedPreferences(context);
		sharedPreferences.edit().remove(key).commit();
	}
}
