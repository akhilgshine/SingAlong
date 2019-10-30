package com.example.singalong;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MaraeTemple extends AppCompatActivity {
    TextView Title,Content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_layout);
        Title=findViewById(R.id.title);
        Content=findViewById(R.id.content);
        Title.setText("Marae Temple");
        //dummy data
        Content.setText("Some of the most mystical locales in Tahiti are on land: the stone marae (temples) that the ancient Polynesians held sacred, and modern Tahitians still do today. While the Polynesians have always revered the sea, and for the majority of tourists today Tahiti is all about its incredibly blue lagoons, it is the land that holds the key to much of its cultural lore.\n" +
                "\n" +
                "\n" +
                "The best way to understand the ancient Polynesian culture is to visit a marae, Today, most marae are just piles of stones, but before the arrival of Europeans in the 18th century, they were the center for social, political and religious activity-including human sacrifice.");
    }
}
