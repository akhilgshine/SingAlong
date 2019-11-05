package com.example.singalong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView singAlong, karaoke;
    ListView listOfItem;
    ImageView rightArrow, leftArrow;
    RelativeLayout listParent,contentParent;

    String ArrayList[] = {"Information about Te Kōpu Mānia o Kirikiriroa", "Te Kōpu Mānia o Kirikiriroa (Wintec Marae)",
                          "Waka Maumahara (Memorial Pillar)", "Pou Whakarae (Pillars)", "Pou-tūā-rangi (Internal Wharenui Post)",
                          "Pou-tūā-rongo - Tawhaki (Internal Wharenui Post)", "Tomokanga ( Gateway Entrance)", "Pare and Whakawae (Doorway Lintels)",
                          "Kōrupe (Window Lintel)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singAlong = findViewById(R.id.singAlong);
        karaoke = findViewById(R.id.karaoke);
        leftArrow = findViewById(R.id.arrowLeft);
        rightArrow = findViewById(R.id.arrowButton);
        listOfItem = findViewById(R.id.list_item);
        listParent = findViewById(R.id.listParent);
        contentParent = findViewById(R.id.contentParent);
        DetailsAdapter adapter = new DetailsAdapter(this, ArrayList);
        listOfItem.setAdapter(adapter);


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
            }
        });
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listParent.setVisibility(View.VISIBLE);
                listParent.animate().translationX(0);
            }
        });
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
                tvSectionTitle.setTextSize(36f);

            } else {
                // if item


            }
            tvSectionTitle.setTag(position);
            tvSectionTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int) tvSectionTitle.getTag();
                    if (pos == 1) {
                        Intent karaoke = new Intent(MainActivity.this, MaraeCulture.class);
                        startActivity(karaoke);

                    } else if (pos == 2) {
                        Intent karaoke = new Intent(MainActivity.this, MaraeTemple.class);
                        startActivity(karaoke);

                    } else if (pos == 3) {
                        Intent karaoke = new Intent(MainActivity.this, MaraeCarvings.class);
                        startActivity(karaoke);

                    } else if (pos == 4) {
                        Intent karaoke = new Intent(MainActivity.this, Karoke.class);
                        startActivity(karaoke);

                    }


                }
            });

            return convertView;
        }

        /**
         * Filter
         */

    }
}
