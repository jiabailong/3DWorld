package com.mygdx.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.mygdx.game.navigation.NavigationActivity;

public class SplashActivity extends Activity{

    private ImageView home;
    private ImageView our;
    private ImageView other;
    private int height;
    private int width;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
       // init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,NavigationActivity.class);
                SplashActivity. this.startActivity(intent);
            }
        },3000);

    }
    private void init(){
        home = (ImageView) findViewById(R.id.login_home);
        our = (ImageView) findViewById(R.id.army_our);
        other = (ImageView) findViewById(R.id.army_other);
        our.setOnClickListener(new MyListener());
        other.setOnClickListener(new MyListener());
    }
    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.army_our){

            }else if(v.getId()==R.id.army_our){

            }
        }
    }
}
