package com.example.singalong;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AppVersion extends AppCompatActivity {

    ListView listView;
    KarokeListAdapter adapter;
    String[] title;
    String[] description;
    int[] images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_version);
    }
}
