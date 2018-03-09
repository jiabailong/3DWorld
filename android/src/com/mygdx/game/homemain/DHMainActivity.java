package com.mygdx.game.homemain;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mygdx.game.widget.arcmenu.ArcMenuGroup;
import com.mygdx.game.widget.arcmenu.ArcMenuItem;

public class DHMainActivity extends Activity implements ArcMenuGroup.ArcMenuItemClick {
    int aiview_width = 160, aiview_height = 160;
    int sprite_initx = 500, sprite_inity = 500;
    FrameLayout frameLayout;
    Button dh_qh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //	iHomeActivity.setBarGone();
//		setContentView(R.layout.lib_dhactivity);

//		ArcMenuGroup.r=(hitview.getWidth()+100)/2;
//		ArcMenuGroup arcMenuGroup = new ArcMenuGroup(this);
//		//arcMenuGroup.setBackgroundColor(Color.parseColor("#50000000"));
//
//		arcMenuGroup.addArcClickListener(this);
//
//
//		getArcItemData(arcMenuGroup);

    }


    int firstx, firsty;

    public void getArcItemData(ArcMenuGroup arcMenuGroup) {
        int w = 100, h = 100;
        FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(w, h);
        ArcMenuItem arcMenuItem = createArcItem();
        arcMenuItem.w = w;
        arcMenuItem.h = h;

//			arcMenuItem.obj = branchEntity;
//			arcMenuItem.setText(branchEntity.name);
        arcMenuGroup.addArcItem(arcMenuItem, lps);
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
