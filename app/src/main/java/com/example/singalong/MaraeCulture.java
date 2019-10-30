package com.example.singalong;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MaraeCulture extends AppCompatActivity {
    TextView Title,Content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_layout);
        Title=findViewById(R.id.title);
        Content=findViewById(R.id.content);
        Title.setText("Marae Culture");
        //dummy data
        Content.setText("Unique to the Māori cultural experience is the marae. The marae is a communal and sacred meeting ground which provides everything from eating, sleeping, religious and educational facilities. In western terms there is no comparison or equivalent building that encapsulates each of these aspects, which is why marae are so paramount to contemporary Māori.");
    }
}
