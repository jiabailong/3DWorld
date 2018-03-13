package com.mygdx.game.navigation;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mygdx.game.AndroidLauncher;
import com.mygdx.game.R;
import com.mygdx.game.homemain.HomeMainActivity;
import com.mygdx.game.widget.NavigationLayout;

public class NavigationActivity extends ActivityGroup implements NavigationLayout.NaviItemClickListener {

    public FrameLayout container;// 装载sub Activity的容器
    public LocalActivityManager localActivityManager;
    View v;
    NavigationLayout navigationLayout;
    public String cur_activity_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        container = (FrameLayout) findViewById(R.id.frame_group);
        navigationLayout= (NavigationLayout) findViewById(R.id.left_bar);
        navigationLayout.setNaviItemClickListener(this);
        localActivityManager = getLocalActivityManager();
        Intent   intent = new Intent(this, HomeMainActivity.class);
        toActivity(HomeMainActivity.class.getName(),intent);

    }

    /**
     * @param id 目标类id
     */
    public void toActivity(String id, Intent intent) {
        if(!TextUtils.isEmpty(cur_activity_name)) {
            if (cur_activity_name.equals(id)) {
                return;
            }
        }
        cur_activity_name=id;
        // 必须先清除容器中所有的View
        container.removeAllViews();
        // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Window subActivity = getLocalActivityManager()
                .startActivity(id, intent);
        v = subActivity.getDecorView();
        // 容器添加View
        container.addView(v, FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT);
    }

    @Override
    public void onNaviItemClick(int poi) {
        Activity activity=localActivityManager.getCurrentActivity();

        if(activity instanceof  AndroidLauncher){//多进程
            localActivityManager.destroyActivity(AndroidLauncher.class.getName(),true);
        }
        Intent intent;
        switch (poi) {
            case 0:
                 intent = new Intent(this, HomeMainActivity.class);
                toActivity(HomeMainActivity.class.getName(),intent);
                break;
            case 1:
                 intent = new Intent(this, AndroidLauncher.class);
                toActivity(AndroidLauncher.class.getName(), intent);
                break;
        }

    }
}
