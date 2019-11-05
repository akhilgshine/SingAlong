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

public class Karoke extends AppCompatActivity {

    ListView listView;
    KarokeListAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karoke);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("asdsad");

        title = new String[]{"Northern White Rhino", "Pinta Island Tortoise", "The Golden Toad", "Madeiran Large White", "Falkland Islands Wolf"};
        description = new String[]{"East and Central Africa", "Ecuador's Pinta Island", "Monteverde, Costa Rica", "Portugal's Madeira Islands", "Falkland Islands"};
        icon = new int[]{R.drawable.rhino, R.drawable.tortoise, R.drawable.toad, R.drawable.butterfly,
                R.drawable.wolf};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings
            arrayList.add(model);
        }
        //pass results to listViewAdapter class
        adapter = new KarokeListAdapter(this, arrayList);

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

