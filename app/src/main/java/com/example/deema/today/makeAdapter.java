package com.example.deema.today;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Deema on 8/21/2017.
 */

public class makeAdapter extends BaseAdapter {

    ArrayList<SingleRow> list;

    Context context;
   public makeAdapter(Context c){
       context=c;
       list=new ArrayList<SingleRow>();
       Resources res = c.getResources();
       String[] mnames = res.getStringArray(R.array.names);
       String[] mphones = res.getStringArray(R.array.phones);
       int[] mimg={R.mipmap.aa,R.mipmap.bb,R.mipmap.ccc,R.mipmap.dddd};
       int length =mnames.length;
       for(int i=0;i<length;i++){
           list.add(new SingleRow(mnames[i],mphones[i],mimg[i]));
       }
   }
    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int postion) {
        return postion;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row,parent,false);

        TextView name = (TextView)row.findViewById(R.id.name);
        TextView phone = (TextView)row.findViewById(R.id.phone);
        ImageView img = (ImageView) row.findViewById(R.id.img);

        SingleRow temp =list.get(position);
        name.setText(temp.name);
        phone.setText(temp.phone);
        img.setImageResource(temp.img);
      return row;
    }
}
