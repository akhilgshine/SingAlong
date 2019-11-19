package com.example.singalong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Song5_Karoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song5__karoke);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Pupuke Te Hihiri");

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        //2. point to video resource
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.pupuke_te_hirihiri_karaoke);

        //add media Control
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        //run it
        videoView.start();
    }
}
