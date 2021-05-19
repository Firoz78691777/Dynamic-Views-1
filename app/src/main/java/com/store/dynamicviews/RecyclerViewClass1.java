package com.store.dynamicviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewClass1 extends AppCompatActivity {
    String[] names = {"Amazon","bing","box","buffer","facebook","google+","instagram","linkdin","quora","reddit","snapchat","tumblr",
            "twitter","vimeo","whatsapp"};
    int[] images = {R.drawable.amazon,R.drawable.bing,R.drawable.box,R.drawable.buffer,R.drawable.facebook,R.drawable.googleplus,
            R.drawable.instagram,R.drawable.linkedin,R.drawable.quora,R.drawable.reddit,
            R.drawable.snapchat, R.drawable.tumblr,R.drawable.twitter,R.drawable.vimeo,R.drawable.whatsapp};
    RecyclerView recyclerView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setRecyclerView1();
    }

    public void setRecyclerView1(){
        recyclerView1 = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);
        RecyclerViewCustomAdapter recyclerViewCustomAdapter = new RecyclerViewCustomAdapter(getApplicationContext(),images,names);
        recyclerView1.setAdapter(recyclerViewCustomAdapter);
    }
}

class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.MyViewHolder>{
    Context context;int[] images;String[] names;

    public RecyclerViewCustomAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.imgList);
            text = itemView.findViewById(R.id.textView);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.litemlistandrecycle,parent,false);
        return new MyViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.images.setImageResource(images[position]);
        holder.text.setText(names[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentClass1 intent = new intentClass1(context,OutputClass1.class,names,images);
                intent.intentMethod(context,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

}

