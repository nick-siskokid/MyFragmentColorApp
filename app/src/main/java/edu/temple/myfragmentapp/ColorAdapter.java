package edu.temple.myfragmentapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context c;

    String[] s;

    //color adapter constructor accepts context and string array as parameters
    public ColorAdapter(Context c, String[] s){
        this.c = c;
        this.s = s;
    }
    @Override
    public int getCount() {
        //return al.size();
        return s.length;
    }

    @Override
    public Object getItem(int position) {
        //return al.get(position);
        return s[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textview;
        if(convertView instanceof TextView){
            textview = (TextView) convertView;
        }
        else{
            textview = new TextView(c);
        }
        textview.setText(String.valueOf(getItem(position)));
        //textview.setBackgroundColor(Color.parseColor(getItem(position).toString()));
        return textview;
    }
}


