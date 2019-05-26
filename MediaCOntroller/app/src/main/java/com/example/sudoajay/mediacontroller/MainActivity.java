package com.example.sudoajay.mediacontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaPlayer_Testing mediaPlayer_testing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.guitar_shikda_video_song);
        mediaPlayer_testing  = new MediaPlayer_Testing(this);
        mediaPlayer_testing .setAnchorView();
        videoView.setMediaController(mediaPlayer_testing );
        videoView.start();

    }
}
