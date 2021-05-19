package com.store.dynamicviews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewClass1 extends AppCompatActivity {
    String[] names = {"Amazon","bing","box","buffer","facebook","google+","instagram","linkdin","quora","reddit","snapchat","tumblr",
            "twitter","vimeo","whatsapp"};
    int[] images = {R.drawable.amazon,R.drawable.bing,R.drawable.box,R.drawable.buffer,R.drawable.facebook,R.drawable.googleplus,
            R.drawable.instagram,R.drawable.linkedin,R.drawable.quora,R.drawable.reddit,
            R.drawable.snapchat, R.drawable.tumblr,R.drawable.twitter,R.drawable.vimeo,R.drawable.whatsapp};
    GridView gridView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        setGridView();
    }

    public void setGridView(){
        gridView1 = findViewById(R.id.gridView);
        GridViewAdapterClass gridViewAdapterClass = new GridViewAdapterClass(getApplicationContext(),images,names);
        gridView1.setAdapter(gridViewAdapterClass);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intentClass1 intent = new intentClass1(getApplicationContext(),OutputClass1.class,names,images);
                intent.intentMethod(getApplicationContext(),position);
            }
        });
    }

}

class GridViewAdapterClass extends ArrayAdapter{
    Context context;
    int[] images;
    String[] names;
    public GridViewAdapterClass(@NonNull Context context, int[] images,String[] names) {
        super(context, R.layout.cardviewgrid,names);
        this.context=context;
        this.images=images;
        this.names=names;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridViewLayout = LayoutInflater.from(context).inflate(R.layout.cardviewgrid,parent,false);
        ImageView imageList = gridViewLayout.findViewById(R.id.cardImage);
        TextView textList = gridViewLayout.findViewById(R.id.cardText);
        imageList.setImageResource(images[position]);
        textList.setText(names[position]);
        return gridViewLayout;
    }
}