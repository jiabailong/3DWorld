package com.mygdx.game.equipinfo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mygdx.game.R;
import com.mygdx.game.entity.ClsFault;
import com.mygdx.game.entity.ClsSonFault;

import java.util.List;


public class EquipLeftAdapter extends BaseExpandableListAdapter {
    String[] colors = {"#3992ea", "#3992ea", "#3992ea",

            "#aeb65b", "#aeb65b", "#aeb65b",
            "#e6a46c", "#e6a46c", "#e6a46c",

            "#8e5cd5", "#8e5cd5", "#8e5cd5",
            "#c6636c", "#c6636c", "#c6636c",};
    List<ClsFault> list;
    private LayoutInflater layoutInflater;
    Context c;

    public EquipLeftAdapter(Context c, List<ClsFault> list) {
        // TODO Auto-generated constructor stub
        this.list = list;
        layoutInflater = LayoutInflater.from(c);
        this.c = c;
    }

    @Override
    public Object getChild(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return arg1;
    }



    @SuppressWarnings("unused")
    @Override
    public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
                             ViewGroup arg4) {
        int pos = arg1;
        ViewHolder holder = null;
        if (holder == null) {
            holder = new ViewHolder();
            arg3 = layoutInflater.inflate(R.layout.lib_cls_rightitem2, null);
            holder.date = (TextView) arg3.findViewById(R.id.date_text);
            arg3.setTag(holder);
        } else {
            holder = (ViewHolder) arg3.getTag();
        }
        ClsSonFault clsSonFault=list.get(arg0).list.get(arg1);
//        holder.date.setText(clsSonFault.description);
        return arg3;
    }

    @Override
    public int getChildrenCount(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).list.size();
    }

    @Override
    public Object getGroup(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @SuppressWarnings("unused")
    @Override
    public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
        ClsFault expanLevel = list.get(arg0);
        final int posi = arg0;
        ParentHolder holder = null;
        if (holder == null) {
            holder = new ParentHolder();
            arg2 = layoutInflater.inflate(R.layout.lib_cls_airlevelitem_par, null);
//			holder. date = (TextView) arg2.findViewById(R.id.date_text);
            holder.img = (ImageView) arg2
                    .findViewById(R.id.btn_tubiao);
            arg2.setTag(holder);
        } else {
            holder = (ParentHolder) arg2.getTag();
        }
//        if (arg0 == 0) {
//            holder.right_content.setBackgroundColor(Color.parseColor("#9baec8"));
//        } else {
//            holder.right_content.setBackgroundColor(Color.parseColor("#2b90d9"));
//        }

		holder.img.setImageResource(arg1?R.drawable.lib_open:R.drawable.lib_close);
//		holder.date.setText(expanLevel.date);
        return arg2;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }

    class ViewHolder {
        TextView date;
    }

    class ParentHolder {
        TextView date;
        ImageView img;
        FrameLayout right_content;
    }
}
