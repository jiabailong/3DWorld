package com.mygdx.game.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.mygdx.game.R;

/**
 * Created by jbl on 18-3-8.
 */

public class NaviItemView extends FrameLayout {
    int width,height;
    int pos;
    AppCompatButton btn;
    public NaviItemView(@NonNull Context context) {
        super(context);
        init();
    }
    public NaviItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public NaviItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
//                Drawable drawable=getResources().getDrawable(R.drawable.nav_normal);
//        Bitmap bmp=((BitmapDrawable)drawable).getBitmap();
//        width=bmp.getWidth();
//        height=bmp.getHeight();
        setNormal();
        FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
        lp.gravity= Gravity.CENTER;
        lp.topMargin=10;
        btn=new AppCompatButton(this.getContext());
//        btn.setBackgroundDrawable(null);
//        btn.setBackgroundColor(Color.BLACK);
        Drawable drawable=getResources().getDrawable(R.drawable.navicon_home);
        btn.setTextColor(Color.WHITE);
        btn.setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null);
        btn.setText("主页");
        btn.setTextSize(10);
        btn.setGravity(Gravity.LEFT);
        btn.setSingleLine();
        btn.setFocusable(false);
        btn.setClickable(false);
        this.addView(btn,lp);


    }

    public void setWidgetName(String s){
            btn.setText(s);
    }
    public void setWidgetIcon(int id){
        Drawable top=getResources().getDrawable(id);
        btn.setCompoundDrawablesWithIntrinsicBounds(null,top,null,null);
    }

    public void setNormal(){
        this.setBackgroundResource(R.drawable.nav_normal);
    }
    public void setFocus(){
        this.setBackgroundResource(R.drawable.nav_focus);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        btn.setOnClickListener(l);
    }
    public void setPosotion(int poi){
        pos=poi;
        btn.setTag(poi);
    }
    public int getPosotion(){
        return pos;
    }
}
