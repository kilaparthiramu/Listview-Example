package com.example.rkilaparthi.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rkilaparthi on 9/26/2016.
 */
public class BaseAdapterActivity extends BaseAdapter {

     LayoutInflater inflater;
     Context context;
     ArrayList myList=new ArrayList();

    public BaseAdapterActivity(Context context, ArrayList myList){

        this.context = context;
        this.myList = myList;
        inflater=LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public ListData getItem(int position) {
        return (ListData) myList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView == null){
            convertView=inflater.inflate(R.layout.row,parent,false);
            holder=new MyViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (MyViewHolder) convertView.getTag();
        }
        ListData listdata=getItem(position);
        holder.txt_title.setText(listdata.getTitle());
        holder.txt_description.setText(listdata.getDescription());
        holder.img.setImageResource(listdata.getImage());
        return convertView;
    }
    private class MyViewHolder{
        TextView txt_title,txt_description;
        ImageView img;
        public MyViewHolder(View item){
            img=(ImageView)item.findViewById(R.id.image_view);
            txt_title=(TextView)item.findViewById(R.id.txt_view_title);
            txt_description=(TextView)item.findViewById(R.id.txt_view_description);
        }


    }
}
