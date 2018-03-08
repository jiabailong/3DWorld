package com.mygdx.game.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.FrameLayout;

import com.mygdx.game.R;

/**
 * Created by jbl on 18-3-8.
 */

public class NaviItemView extends FrameLayout {
    int width,height;
    Button btn;
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
        FrameLayout.LayoutParams lp=new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.gravity= Gravity.CENTER;
        btn=new Button(this.getContext());
        btn.setBackgroundDrawable(null);
        Drawable drawable=getResources().getDrawable(R.drawable.navicon_home);
        btn.setTextColor(Color.WHITE);
        btn.setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null);
        btn.setText("主页");
        this.addView(btn,lp);


    }



    public void setNormal(){
        this.setBackgroundResource(R.drawable.nav_normal);
    }
    public void setFocus(){
        this.setBackgroundResource(R.drawable.nav_focus);
    }
}
