package com.example.conveniencestoreapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {


    public ArrayList<ListViewItem> arrayList=new ArrayList<>();

    public ListViewAdapter(){}
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Context context=parent.getContext();

        if (view==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_item,parent,false);
        }

        TextView textView1=(TextView)view.findViewById(R.id.category);
        TextView textView2=(TextView)view.findViewById(R.id.title);
        TextView textView3=(TextView)view.findViewById(R.id.content);
        ImageView imageView1=(ImageView)view.findViewById(R.id.itemImage);

        ListViewItem listViewItem=arrayList.get(position);
        textView1.setText(listViewItem.getText1());
        textView2.setText(listViewItem.getText2());
        textView3.setText(listViewItem.getText3());
//        imageView1.setImageDrawable(listViewItem.getImage1());

        return view;
    }

    public void addItem(String text1, String text2, String text3){

        ListViewItem listViewItem=new ListViewItem();
        listViewItem.setText1(text1);
        listViewItem.setText2(text2);
        listViewItem.setText3(text3);
//        listViewItem.setImage1(image1);

        arrayList.add(listViewItem);
    }
}
