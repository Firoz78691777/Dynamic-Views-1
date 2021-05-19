package com.store.dynamicviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListViewCustomAdapter extends ArrayAdapter {
    Context context;
    String[] names;
    int[] images;
    public ListViewCustomAdapter(@NonNull Context context, int[] images,String[] names) {
        super(context,R.layout.litemlistandrecycle,names);
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.litemlistandrecycle,parent,false);
        ImageView imageList = listItem.findViewById(R.id.imgList);
        TextView textList = listItem.findViewById(R.id.textView);
        imageList.setImageResource(images[position]);
        textList.setText(names[position]);
        return listItem;
    }
}
