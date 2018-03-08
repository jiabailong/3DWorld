package com.mygdx.game.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by jbl on 18-3-8.
 */

public class NavigationLayout extends LinearLayout {
    NaviItemView curview;
    public NavigationLayout(@NonNull Context context) {
        super(context);
        addItemToLayout();
    }
    public NavigationLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        addItemToLayout();
    }
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public NavigationLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addItemToLayout();
    }
    public void addItemToLayout(){
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.weight=1;
        for(int i=0;i<4;i++){
        NaviItemView naviItemView=new NaviItemView(this.getContext());
        naviItemView.setNormal();
            naviItemView.setPosotion(i);
        this.addView(naviItemView,lp);
        if(i==0){
            curview=naviItemView;
            curview.setFocus();
        }
        naviItemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                curview.setNormal();
                curview= (NaviItemView) NavigationLayout.this.getChildAt((int)(view.getTag()));
                curview.setFocus();
            }
        });
    }
    }



    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed,left,top,right,bottom);
            for(int i=0;i<this.getChildCount();i++){
                View naviItemView= (View) this.getChildAt(i);
                int width=naviItemView.getWidth();
                int height=naviItemView.getHeight();
                int move_dance= (int) (0.28*height)*(i-1);
                naviItemView.layout(0,height*i-move_dance,width,(i+1)*height-move_dance);
            }
    }
}
