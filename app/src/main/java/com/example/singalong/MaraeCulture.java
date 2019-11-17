package com.example.singalong;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MaraeCulture extends AppCompatActivity {
    TextView Title,Content;
    String titleText,contentText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_layout);
        Title=findViewById(R.id.title);
        Content=findViewById(R.id.content);
        titleText=getIntent().getStringExtra("title");
        contentText=getIntent().getStringExtra("content");

        Title.setText(titleText);
        Content.setText(contentText);
    }
}
