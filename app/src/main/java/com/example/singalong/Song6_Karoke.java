package com.example.singalong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Song6_Karoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song6__karoke);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Pua Te Kowhai");

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        //2. point to video resource
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.pua_te_kowhai_karaoke);

        //add media Control
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        //run it
        videoView.start();
    }
}
