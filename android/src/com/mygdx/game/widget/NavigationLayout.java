package com.mygdx.game.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.mygdx.game.R;

/**
 * Created by jbl on 18-3-8.
 */

public class NavigationLayout extends LinearLayout {
    String[] names = {"主页", "军用模型", "模型数据", "使用帮助"};
    int []icons={R.drawable.navicon_home,R.drawable.navicon_air,R.drawable.navicon_home,R.drawable.navicon_help};
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

    public void addItemToLayout() {
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.weight = 1;
        for (int i = 0; i < 4; i++) {
            NaviItemView naviItemView = new NaviItemView(this.getContext());
            naviItemView.setNormal();
            naviItemView.setPosotion(i);
            naviItemView.setWidgetName(names[i]);
            naviItemView.setWidgetIcon(icons[i]);
            this.addView(naviItemView, lp);
            if (i == 0) {
                curview = naviItemView;
                curview.setFocus();
            }
            naviItemView.setOnTouchListener(new ShotTouchListener());
//            naviItemView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//
//                }
//            });
        }
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        for (int i = 0; i < this.getChildCount(); i++) {
            View naviItemView = (View) this.getChildAt(i);
            int width = naviItemView.getWidth();
            int height = naviItemView.getHeight();
            int move_dance = (int) (0.28 * height) * (i - 1);
            naviItemView.layout(0, height * i - move_dance, width, (i + 1) * height - move_dance);
        }
    }

    public class ShotTouchListener implements OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent arg1) {
            NaviItemView img = (NaviItemView) view;
            // int mArrayColor[] = null;
            int x = (int) (arg1.getX());
            int y = ((int) arg1.getY());
            Bitmap b = ((BitmapDrawable) (img.getBackground())).getBitmap();
            int img_height = img.getHeight();
            int img_width = img.getWidth();
            double scale_height = (double) b.getHeight() / (double) img_height;
            double scale_width = (double) b.getWidth() / (double) img_width;

            if (y < b.getHeight() && x > 0 && y > 0 && x < b.getWidth()) {
                int color = b.getPixel((int) (x * scale_width),
                        (int) (y * scale_height));
                if (Color.alpha(color) == 0) {
                    return false;
                } else {
                    curview.setNormal();
                    curview = (NaviItemView) NavigationLayout.this.getChildAt((((NaviItemView) view).getPosotion()));
                    curview.setFocus();
                    if(arg1.getAction()==MotionEvent.ACTION_UP){
                        if(naviItemClickListener!=null){
                            naviItemClickListener.onNaviItemClick(((NaviItemView) view).getPosotion());
                        }
                    }

                    return true;
                }
            }


            return false;
        }
    }
    public void setNaviItemClickListener(NaviItemClickListener naviItemClickListener){
        this.naviItemClickListener=naviItemClickListener;
    }
    public NaviItemClickListener naviItemClickListener;
    public interface NaviItemClickListener{
        public void onNaviItemClick(int poi);
    }
}
