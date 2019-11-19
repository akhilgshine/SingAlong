package com.example.singalong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView singAlong, karaoke,langText;
    AppPreferences prefs;
    ListView listOfItem;
    ImageView rightArrow, leftArrow,langToggle,navButton;
    RelativeLayout listParent,contentParent;
    boolean togselected=false;
    String titleArray[]={};
    String contentsArray[]={};
    int imageArray[]={R.drawable.akhil,R.drawable.maraeimage,R.drawable.maraeimage,R.drawable.memorial_pillar,R.drawable.pillars,R.drawable.internal,R.drawable.internal_wharenui,R.drawable.gateway_entrance,R.drawable.doorway_lintels,R.drawable.window_lintels};
    boolean openClose=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        init();
        if(prefs.contains("Language")) {
            langText.setText(prefs.getData("Language"));
            if(prefs.getData("Language").equals("English"))
            {
                langToggle.setImageResource(R.drawable.tog_off);
                togselected=false;
                setLocale("en");
            }
            else
            {
                langToggle.setImageResource(R.drawable.tog_on);
                togselected=true;
                setLocale("mi");

            }
        }
        langToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(togselected)
                {
                    prefs.SaveData("Language","English");
                    prefs.SaveData("lanCode","en");
                    langText.setText("English");
                    langToggle.setImageResource(R.drawable.tog_off);
                    togselected=false;
                    setLocale("en");
                   // init();
                }
                else
                {
                    prefs.SaveData("Language","Maori");
                    prefs.SaveData("lanCode","mi");
                    langText.setText("Maori");
                    langToggle.setImageResource(R.drawable.tog_on);
                    togselected=true;
                    setLocale("mi");
                   // init();


                }
            }
        });


        singAlong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singALongInent = new Intent(MainActivity.this, SingAlong.class);
                startActivity(singALongInent);

            }
        });
        karaoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent karaoke = new Intent(MainActivity.this, Karoke.class);
                startActivity(karaoke);

            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        listParent.setVisibility(View.GONE);
        listParent.animate().translationX(width);


        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                listParent.animate().translationX(width);
                openClose=false;
            }
        });
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listParent.setVisibility(View.VISIBLE);
                listParent.animate().translationX(0);
                openClose=true;
            }
        });

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, navButton);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if(id ==  R.id.app_version){
                            Intent intent = new Intent(getBaseContext(), AppVersion.class);
                            startActivity(intent);

                        }
                        if(id ==  R.id.about_us){
                            Intent intent = new Intent(getBaseContext(), AboutUs.class);
                            startActivity(intent);
                        }
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });

    }

    public void init()
    {
        singAlong = findViewById(R.id.singAlong);
        karaoke = findViewById(R.id.karaoke);
        leftArrow = findViewById(R.id.arrowLeft);
        rightArrow = findViewById(R.id.arrowButton);
        listOfItem = findViewById(R.id.list_item);
        listParent = findViewById(R.id.listParent);
        langToggle = findViewById(R.id.langToggle);
        contentParent = findViewById(R.id.contentParent);
        langText = findViewById(R.id.langText);
        navButton = findViewById(R.id.navButton);
        prefs=new AppPreferences(this,getResources().getString(R.string.app_name));

        singAlong.setText(R.string.sing_along);
        karaoke.setText(R.string.karaoke);

        String langcode=prefs.getData("lanCode");
        titleArray=getResources().getStringArray(R.array.title_array);
        contentsArray=getResources().getStringArray(R.array.content_array);
        DetailsAdapter adapter = new DetailsAdapter(this, titleArray);
        listOfItem.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public class DetailsAdapter extends BaseAdapter {
        private Context context;
        private String[] item;

        public DetailsAdapter() {
            super();
        }

        public DetailsAdapter(Context context, String[] item) {
            this.context = context;
            this.item = item;

        }

        @Override
        public int getCount() {

            return item.length;
        }

        @Override
        public Object getItem(int position) {
            return item[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, parent, false);
            final TextView tvSectionTitle = (TextView) convertView.findViewById(R.id.itemText);
            tvSectionTitle.setText(item[position]);

            if (position == 0) {
                // if section header
                tvSectionTitle.setTextSize(20f);

            }
            tvSectionTitle.setTag(position);
            tvSectionTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int) tvSectionTitle.getTag();

                    if(pos!=0)
                    {
                        Intent nextScreen = new Intent(MainActivity.this, MaraeCulture.class);
                        nextScreen.putExtra("title",titleArray[pos]);
                        nextScreen.putExtra("content",contentsArray[pos]);
                        nextScreen.putExtra("position",String.valueOf(pos));
                        nextScreen.putExtra("image",imageArray[pos]);
                        startActivity(nextScreen);
                    }

                }
            });

            return convertView;
        }

        /**
         * Filter
         */

    }

    public void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        init();

    }

}
