package com.mygdx.game;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.utils.LoadingProgress;

public class AndroidLauncher extends AndroidApplication {
	LoadingProgress progressDialog;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		progressDialog=new LoadingProgress(this);
		progressDialog.show();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.r = config.g = config.b = config.a = 8;
		initialize(new LoadModel(), config);

		if (graphics.getView() instanceof SurfaceView) {
			SurfaceView glView = (SurfaceView) graphics.getView();
			glView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
			glView.setZOrderOnTop(true);
		}


		/*View view = initializeForView(new LoadModel(), config);
		view.setVisibility(View.VISIBLE);*/
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("jia","onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("jia","onStop");
	}

	@Override
	protected void onResume() {
		super.onResume();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				progressDialog.close();
			}
		},1000);
	}


	@Override
	public void exit() {
		super.exit();
		Log.d("jia","exit");
	}

	@Override
	protected void onDestroy() {
		Log.d("jia","onDestroy");
		super.onDestroy();
	}
}
