package com.mygdx.game.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;

import com.mygdx.game.R;


public class LoadingProgress {
	private ProgressDialog dialogexit;
	Context context;

	public LoadingProgress(Context context) {
		this.context = context;

	}

	public void show() {
		if(dialogexit==null||!dialogexit.isShowing()){
			dialogexit = ProgressDialog.show(context, "", "");
			dialogexit.setContentView(R.layout.lib_myprogress);
			dialogexit.show();
			Window window = dialogexit.getWindow();
//			// window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
//			// WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);// 不获得焦点
//			// window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//
//			// 背景不变暗
			window.setGravity(Gravity.CENTER);// 位于屏幕中间
		}
		
	}

	public void close() {
		if (dialogexit != null) {
			dialogexit.dismiss();
		}

	}
}
