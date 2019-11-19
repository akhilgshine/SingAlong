package com.example.singalong;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MaraeCulture extends AppCompatActivity {
    TextView Title,Content;
    String titleText,contentText,pos;
    ImageView maraeImage;
    int DrawableId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_layout);
        Title=findViewById(R.id.title);
        Content=findViewById(R.id.content);
        titleText=getIntent().getStringExtra("title");
        contentText=getIntent().getStringExtra("content");
        pos=getIntent().getStringExtra("position");

        Title.setText(titleText);
        maraeImage=findViewById(R.id.maraeImage);
        titleText=getIntent().getStringExtra("title");
        contentText=getIntent().getStringExtra("content");
        DrawableId=getIntent().getIntExtra("image",0);
        pos=getIntent().getStringExtra("position");

        Title.setText(titleText);
        maraeImage.setImageResource(DrawableId);
        if(pos.equals("1")||pos.equals("2"))
        {
            Spanned result;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                result = Html.fromHtml(contentText, Html.FROM_HTML_MODE_LEGACY);
            } else {
                //noinspection deprecation
                result = Html.fromHtml(contentText);
            }
            Content.setLinksClickable(true);
            Content.setLinkTextColor(Color.parseColor("#1D75FF"));
            Content.setMovementMethod(LinkMovementMethod.getInstance());
            Content.setText(result);

        }
        else
        Content.setText(contentText);

    }
}
