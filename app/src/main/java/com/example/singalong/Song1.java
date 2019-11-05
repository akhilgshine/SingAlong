package com.example.singalong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Song1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song1);
        //Basic of video
        //1. get video view
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        //2. point to video resource
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

        //add media Control
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        //run it
        videoView.start();
    }
}
