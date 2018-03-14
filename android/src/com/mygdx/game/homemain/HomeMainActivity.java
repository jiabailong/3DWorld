package com.mygdx.game.homemain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mygdx.game.R;
import com.mygdx.game.equipinfo.EquipActivity;
import com.mygdx.game.navigation.NavigationActivity;
import com.mygdx.game.widget.arcmenu.ArcMenuGroup;
import com.mygdx.game.widget.arcmenu.ArcMenuItem;
import com.mygdx.game.widget.circlemenu.view.CircleLayout;

public class HomeMainActivity extends Activity implements ArcMenuGroup.ArcMenuItemClick {
    int aiview_width = 160, aiview_height = 160;
    int sprite_initx = 500, sprite_inity = 500;
    FrameLayout frameLayout;
    Button dh_qh;
    ArcMenuGroup arcMenuGroup;
    CircleLayout circleLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemain);
//		ArcMenuGroup.r=200;
//		 arcMenuGroup = (ArcMenuGroup) findViewById(R.id.arc_group);
////		arcMenuGroup.addArcClickListener(this);
//
//        arcMenuGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                getArcItemData(arcMenuGroup);
//                arcMenuGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//            }
//        });
        final NavigationActivity navigationActivity= (NavigationActivity) this.getParent();
        circleLayout=findViewById(R.id.main_circle);
        circleLayout.setOnItemClickListener(new CircleLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id, String name) {
                Intent intent=new Intent(HomeMainActivity.this, EquipActivity.class);
                navigationActivity.toActivity(EquipActivity.class.getName(),intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    int firstx, firsty;

    public void getArcItemData(ArcMenuGroup arcMenuGroup) {
        int w = 180, h = 170;
        FrameLayout.LayoutParams lps = new FrameLayout.LayoutParams(w, h);
        for(int i=0;i<9;i++) {
            ArcMenuItem arcMenuItem = createArcItem();
            arcMenuItem.w = w;
            arcMenuItem.h = h;
            arcMenuItem.setText("雷达"+i);
            arcMenuGroup.addArcItem(arcMenuItem, lps,9);
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
