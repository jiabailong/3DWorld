package com.mygdx.game.equipinfo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.mygdx.game.R;

import java.util.List;

/**
 * Created by ATI on 2017/9/18.
 */
public class EquipRightAdapter extends RecyclerView.Adapter<EquipRightAdapter.MViewHolder> {
    List<Object> list;
    Context c;
    private ViewGroup parent;
    private int viewType;
    RecycleItemClick recycleItemClick;
    RecycleLongItemClick recycleLongItemClick;
    String[] colors = {"#3992ea", "#aeb65b", "#e6a46c",

            "#8e5cd5", "#c6636c"};

    public EquipRightAdapter(Context c, List<Object> list) {
        this.c = c;
        this.list = list;
    }

    public void setOnRecycleItemClick(RecycleItemClick recycleItemClick) {
        this.recycleItemClick = recycleItemClick;
    }

    public void setOnRecycleLongItemClick(RecycleLongItemClick recycleLongItemClick) {
        this.recycleLongItemClick = recycleLongItemClick;
    }

    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.lib_equip_right_item, parent, false);
        return new MViewHolder(v);
    }

    public void onBindViewHolder(final MViewHolder holder, int position) {
        final int poi = position;
//        final PicMainHistory pic = list.get(position);
//        CardView cardView= (CardView) holder.itemView;
//        cardView.setCardBackgroundColor(Color.parseColor(colors[poi%colors.length]));
//
////        holder.name.setText("创建时间："+pic.date);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (recycleItemClick != null) {
//                    recycleItemClick.onRecycleItemClick(holder.itemView, poi, pic);
//                }
//            }
//        });
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                new AlertDialog.Builder(v.getContext()).setTitle("确定删除数据").setNegativeButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        if (recycleLongItemClick != null) {
//                            recycleLongItemClick.onRecycleLongItemClick(holder.itemView, poi, pic);
//                        }
//                    }
//                })
//                        .setPositiveButton("取消", null).show();
//
//                return true;
//            }
//        });
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public MViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
        }

    }

    public interface RecycleItemClick {
        public void onRecycleItemClick(View v, int posi, Object obj);
    }

    public interface RecycleLongItemClick {
        public void onRecycleLongItemClick(View v, int posi, Object obj);
    }
}
