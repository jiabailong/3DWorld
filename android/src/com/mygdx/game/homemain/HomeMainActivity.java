package com.mygdx.game.homemain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mygdx.game.widget.arcmenu.ArcMenuGroup;
import com.mygdx.game.widget.arcmenu.ArcMenuItem;

public class HomeMainActivity extends Activity implements ArcMenuGroup.ArcMenuItemClick {
    int aiview_width = 160, aiview_height = 160;
    int sprite_initx = 500, sprite_inity = 500;
    FrameLayout frameLayout;
    Button dh_qh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		ArcMenuGroup.r=200;
		ArcMenuGroup arcMenuGroup = new ArcMenuGroup(this);
        arcMenuGroup.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setContentView(arcMenuGroup);
//		arcMenuGroup.addArcClickListener(this);
		getArcItemData(arcMenuGroup);

    }


    int firstx, firsty;

    public void getArcItemData(ArcMenuGroup arcMenuGroup) {
        int w = 100, h = 100;
        FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(w, h);
        for(int i=0;i<9;i++) {
            ArcMenuItem arcMenuItem = createArcItem();
            arcMenuItem.w = w;
            arcMenuItem.h = h;
            arcMenuItem.setText("雷达"+i);
            arcMenuGroup.addArcItem(arcMenuItem, lps);
        }
    }

    public ArcMenuItem createArcItem() {

        ArcMenuItem arcMenuItem = new ArcMenuItem(this);
        return arcMenuItem;
    }

    @Override
    public void arcItemClick(View v) {

        ArcMenuItem arcMenuItem = (ArcMenuItem) v;


    }


}
