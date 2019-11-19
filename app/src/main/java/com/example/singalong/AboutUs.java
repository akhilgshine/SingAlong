package com.example.singalong;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AboutUs extends AppCompatActivity {

    LinearLayout listView;
    String[] name={"Akhil Geetha Shine","Amarender Mominpet","Callum Gott","Kyle Jameson","Maria Susainathan Dominic Maria Joseph","Teniel Nieuwoudt"};
    String[] roleofperson={"App Programmer","Documentation Specialist","Team Leader\n" + "Audio Editor","Media Expert","App Programmer","Lead Designer"};
    int[] images={R.drawable.akhil,R.drawable.akhil,R.drawable.akhil,R.drawable.akhil,R.drawable.maria,R.drawable.akhil};
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        listView = findViewById(R.id.personalList);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        listView.removeAllViews();
        //  for (int i = response1.getJSONArray("result").length()-1; i > -1; i--) {
        for (int i = 0; i < name.length; i++) {
            final View view = inflater.inflate(R.layout.about_uslist, null);
            view.setTag(i);

            TextView personName = (TextView) view.findViewById(R.id.name);
            TextView role = (TextView) view.findViewById(R.id.role);
            ImageView Image = view.findViewById(R.id.personImage);

            personName.setText(name[i]);
            role.setText(roleofperson[i]);
            Image.setImageResource(images[i]);


            listView.addView(view);
        }
    }
}
