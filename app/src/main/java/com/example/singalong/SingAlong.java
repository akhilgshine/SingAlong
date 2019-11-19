package com.example.singalong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SingAlong extends AppCompatActivity {

    ListView listView;
    SingAlongListAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_along);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Songs List");

        title = new String[]{"E Kore Koe E Ngaro", "He Maimai Aroha Nā Tāwhiao", "Waikato Te Awa", "Tutira Mai Nga Iwi", "Pupuke Te Hihiri", "Pua Te Kowhai", "I Te Whare Whakapiri"};
        description = new String[]{"Written by Te Iti Kahurangi", "Kingi Tāwhiao", "Rivers journey", "Written by Wī Huata ", "Written by Nganehu Turner", "Yellow flowers of the Kowhai tree ", "loss of identity and culture of a person"};
        icon = new int[]{R.drawable.song1_image, R.drawable.song2_iamge, R.drawable.song3_image, R.drawable.song4_image,
                R.drawable.song5_image, R.drawable.song6_image, R.drawable.song7_image};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings
            arrayList.add(model);
        }
        //pass results to listViewAdapter class
        adapter = new SingAlongListAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);
    }

    //Searching the list by passing values in the search bar
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    //Navigation to home page and exit application
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if(id ==  R.id.action_settings){
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.exit){
            finishAffinity();
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}