package com.mygdx.game;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
