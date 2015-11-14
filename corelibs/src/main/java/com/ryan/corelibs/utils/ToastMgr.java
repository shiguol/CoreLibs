package com.ryan.corelibs.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * toast管理器, 确保只有一个Toast对象
 *
 * @author ZhuFan
 * @Date: 2014-12-8
 */
@SuppressLint("ShowToast")
public class ToastMgr {
	private static Toast it;
	private static Context mContext;
	
	public static Context getContext() {
		return mContext;
	}

	private ToastMgr() {}
	
	/**
	 * 在程序初始化的时候调用, 只需调用一次
	 * @param _context ������
	 */
	public static void init(Context _context) {
		mContext = _context;
		View v = Toast.makeText(mContext, "", Toast.LENGTH_SHORT).getView();
        init(mContext, v);
	}
	
	/**
	 * 在程序初始化的时候调用, 只需调用一次
	 * @param _context ������
	 * @param view Toast����
	 */
	public static void init(Context _context, View view){
        it = new Toast(_context);
        it.setView(view);
	}
	
	/**
	 * 设置Toast背景
	 * @param view
	 */
	public static void setBackgroundView(View view){
		if(it != null)
			it.setView(view);
	}
	
    public static void show(CharSequence text, int duration) {
    	if(it == null){
    		Log.e("ToastMgr", "ToastMgr is not initialized, please call init once before you call this method");
    		return;
    	}
        it.setText(text);
        it.setDuration(duration);
        it.show();
    }

    public static void show(int resid, int duration) {
    	if(it == null){
    		Log.e("ToastMgr", "ToastMgr is not initialized, please call init once before you call this method");
    		return;
    	}
        it.setText(resid);
        it.setDuration(duration);
        it.show();
    }
    
    public static void show(CharSequence text) {
    	show(text, Toast.LENGTH_SHORT);
    }

    public static void show(int resid) {
    	show(resid, Toast.LENGTH_SHORT);
    }
}
