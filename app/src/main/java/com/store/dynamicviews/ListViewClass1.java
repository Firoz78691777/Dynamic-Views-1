package com.store.dynamicviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import static com.store.dynamicviews.R.id.listView;

public class ListViewClass1 extends AppCompatActivity {
    String[] names = {"Amazon","bing","box","buffer","facebook","google+","instagram","linkdin","quora","reddit","snapchat","tumblr",
            "twitter","vimeo","whatsapp"};
    int[] images = {R.drawable.amazon,R.drawable.bing,R.drawable.box,R.drawable.buffer,R.drawable.facebook,R.drawable.googleplus,
            R.drawable.instagram,R.drawable.linkedin,R.drawable.quora,R.drawable.reddit,
            R.drawable.snapchat, R.drawable.tumblr,R.drawable.twitter,R.drawable.vimeo,R.drawable.whatsapp};
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        setListView1();
    }

    public void setListView1(){
        listView1 = findViewById(R.id.listView);
        ListViewCustomAdapter listViewCustomAdapter = new ListViewCustomAdapter(getApplicationContext(),images,names);
        listView1.setAdapter(listViewCustomAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intentClass1 intent = new intentClass1(getApplicationContext(),OutputClass1.class,names,images);
                intent.intentMethod(getApplicationContext(),position);
            }
        });
    }
}