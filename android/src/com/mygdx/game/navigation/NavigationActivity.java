package com.mygdx.game.navigation;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mygdx.game.AndroidLauncher;
import com.mygdx.game.R;

public class NavigationActivity extends ActivityGroup {

    public FrameLayout container;// 装载sub Activity的容器
    public LocalActivityManager localActivityManager;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        container= (FrameLayout) findViewById(R.id.frame_group);
        localActivityManager = getLocalActivityManager();
        Intent intent=new Intent(this, AndroidLauncher.class);
        toActivity(AndroidLauncher.class.getName(),intent);

    }
    /**
     * @param id 目标类id*/
    public void toActivity(String id, Intent intent) {
        // 必须先清除容器中所有的View
        container.removeAllViews();
        // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Window subActivity = getLocalActivityManager()
                .startActivity(id, intent);
        v = subActivity.getDecorView();
        // 容器添加View
        container.addView(v, FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT);
    }
}
