package com.example.toolsshops;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewTitle;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();
        imageView = findViewById(R.id.imageViewDrillLogo);
        textViewInfo = findViewById(R.id.textView2);
        textViewTitle = findViewById(R.id.textViewTitle);

        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("image")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("image", -1);
            imageView.setImageResource(resId);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
        }
        else {
            Intent intent1 = new Intent(this, DrillCategoryActivity.class);
            startActivity(intent1);
        }
    }
}