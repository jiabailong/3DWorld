package com.mygdx.game.widget.arcmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jbl on 2016-04-14.
 */
public class ArcMenuGroup extends FrameLayout implements View.OnClickListener {
    List<ArcMenuItem> list = new ArrayList<ArcMenuItem>();
    public int x0 = 10, y0 = 10;
    public static int r = 100;
    int start = 0;
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

    int count;

    public void addArcItem(ArcMenuItem arc, LayoutParams lp, int size) {


        x0 = this.getMeasuredWidth() / 2;
        y0 = this.getMeasuredHeight() / 2;
        int a = x0 - 50;
        int b = y0 - 180;
        list.add(arc);
        arc.setOnClickListener(this);

        int dis = (x0 * 2 - 80) / size;

        int[] loc = cal(dis * list.size() - x0, a, b);
//        arc.x = loc[0] + x0 - 40;
//        arc.y = loc[1] + y0;


        if (list.size() % 2 == 0) {
            arc.x = loc[0] + x0 - 40;
            arc.y = loc[1] + y0;
        }else{
            arc.x = loc[0] + x0 - 40;
            arc.y = -loc[1] + y0;
        }
        addView(arc, lp);
        this.invalidate();

    }

    public void init() {
    }

    public int[] calXY(int angle, int w, int h) {
        int a = w;
        int b = h;
        Log.d("jia", angle + "");
        double ss = Math.sin(angle) * Math.sin(angle) * a * a + b * b * Math.cos(angle) * Math.cos(angle);
        double r = a * b / Math.sqrt(ss);
        int s[] = new int[2];
//        int x = (int) (x0 - w / 2 + r * Math.cos((double) (angle * Math.PI) / 180));
//        int y = (int) (y0 - h / 2 + r * Math.sin((double) (angle * Math.PI) / 180));
        s[0] = (int) (r * Math.cos(angle)) + x0;
        s[1] = (int) (r * Math.sin(angle)) + y0;
        return s;

    }

    public int[] cal(int x, int a, int b) {

        int s[] = new int[2];
//        int x = (int) (x0 - w / 2 + r * Math.cos((double) (angle * Math.PI) / 180));
//        int y = (int) (y0 - h / 2 + r * Math.sin((double) (angle * Math.PI) / 180));
        s[0] = x;
        double h = ((double) (x * x)) / (double) ((a * a));
        double ss = Math.sqrt((1 - h) * (b * b));
        Log.d("jia", ss + "==" + x + "=a=" + a + "=b=" + b + "=" + h);
        s[1] = (int) ss;
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
        RectF f;
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
