package com.store.dynamicviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OutputClass1 extends AppCompatActivity {
    ImageView image;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_class1);
        image = findViewById(R.id.cardImage1);
        text = findViewById(R.id.cardText1);

        image.setImageResource(getIntent().getIntExtra("images",0));
        text.setText(getIntent().getStringExtra("names"));
    }
}