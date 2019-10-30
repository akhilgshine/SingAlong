package com.example.singalong;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MaraeCarvings extends AppCompatActivity {

    TextView Title,Content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_layout);
        Title=findViewById(R.id.title);
        Content=findViewById(R.id.content);
        Title.setText("Marae Carvings");

        //dummy data
        Content.setText("Wintec’s marae features an array of carvings, designed and created by Tainui master carver Warren McGrath, Ngāti Raukawa, a former Wintec student.\n" +
                "\n" +
                "The carvings are made from both traditional and modern materials including totora, concrete and stainless steel.");
    }
}
