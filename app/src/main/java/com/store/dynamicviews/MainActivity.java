package com.store.dynamicviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button listBtn,gridBtn,recyclerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBtn = findViewById(R.id.listViewBtn);
        gridBtn = findViewById(R.id.gridViewBtn);
        recyclerBtn = findViewById(R.id.recyclerViewBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intents(ListViewClass1.class);
            }
        });
        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intents(GridViewClass1.class);
            }
        });
        recyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intents(RecyclerViewClass1.class);
            }
        });

    }

    public void intents(Class className){
        Intent intent = new Intent(MainActivity.this,className);
        startActivity(intent);
    }
}