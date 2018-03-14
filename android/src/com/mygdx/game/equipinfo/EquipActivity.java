package com.mygdx.game.equipinfo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;

import com.mygdx.game.R;
import com.mygdx.game.entity.ClsFault;
import com.mygdx.game.entity.ClsSonFault;

import java.util.ArrayList;

/**
 * Created by jbl on 18-3-14.
 */

public class EquipActivity extends Activity {
    ExpandableListView expandableListView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equip_view);
        expandableListView=findViewById(R.id.left);
        ArrayList<ClsFault> list=new ArrayList<>();
        for(int i=0;i<4;i++){
            ClsFault clsFault=new ClsFault();
            clsFault.list=new ArrayList<>();
            for(int j=0;j<4;j++){
                ClsSonFault clsSonFault=new ClsSonFault();
                clsFault.list.add(clsSonFault);

            }
            list.add(clsFault);
        }
        EquipLeftAdapter equipLeftAdapter=new EquipLeftAdapter(this,list);
        expandableListView.setAdapter(equipLeftAdapter);


        recyclerView=findViewById(R.id.right);
        GridLayoutManager layoutManage = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManage);
        ArrayList<Object> names=new ArrayList();
       for(int i=0;i<10;i++){
           names.add(new Object());
       }
        recyclerView.setAdapter(new EquipRightAdapter(this,names));
    }
}
