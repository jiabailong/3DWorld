package com.mygdx.game.widget.arcmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jbl on 2016-04-14.
 */
public class ArcMenuGroup extends FrameLayout implements View.OnClickListener {
    List<ArcMenuItem> list = new ArrayList<ArcMenuItem>();
    public int x0 = 10, y0 = 10;
    public static int r = 100;
    int start = -90;
    int an = 40;
    ArcMenuItemClick cliclListener;

    public ArcMenuGroup(Context context) {
        super(context);
        init();
    }

    public ArcMenuGroup(Context context, int x, int y) {
        super(context);
        init();
    }

    public ArcMenuGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArcMenuGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onAttachedToWindow() {

//        this.getMeasuredWidth();

        super.onAttachedToWindow();
    }

    public void addArcItem(ArcMenuItem arc, LayoutParams lp) {
        x0 = this.getLayoutParams().width / 2;
        y0 = this.getLayoutParams().height / 2;
//    	  x0 = this.getLayoutParams().width ;
//          y0 = this.getLayoutParams().height;
        list.add(arc);
        arc.setOnClickListener(this);
        int size = list.size();

        int[] loc = calXY(start + (size - 1) * an, arc.w, arc.h);
        arc.x = loc[0];
        arc.y = loc[1];
        addView(arc, lp);
        this.invalidate();

    }

    public void init() {
        //this.setBackgroundColor(Color.argb(90,0,0,0));

    }

    public int[] calXY(int angle, int w, int h) {
        int s[] = new int[2];
        int x = (int) (x0 - w / 2 + r * Math.cos((double) (angle * Math.PI) / 180));
        int y = (int) (y0 - h / 2 + r * Math.sin((double) (angle * Math.PI) / 180));
        s[0] = x;
        s[1] = y;
        return s;

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        for (int i = 0; i < list.size(); i++) {
            ArcMenuItem arcMenuItem = (ArcMenuItem) getChildAt(i);
            int width = arcMenuItem.getMeasuredWidth();
            int height = arcMenuItem.getMeasuredHeight();
            int x = arcMenuItem.x;
            int y = arcMenuItem.y;
            arcMenuItem.layout(x, y, x + width, y + height);
        }
    }


    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
//        Paint p=new Paint();
//  	  p.setStrokeWidth(10);
//        p.setAntiAlias(true);
//        p.setColor(Color.RED);
//        canvas.drawPoint(x0, y0, p);
    }

    public void addArcClickListener(ArcMenuItemClick arcMenuItemClick) {

        cliclListener = arcMenuItemClick;
    }

    public interface ArcMenuItemClick {
        public void arcItemClick(View v);
    }

    @Override
    public void onClick(View view) {
        if (cliclListener != null) {
            cliclListener.arcItemClick(view);
        }
    }
}
