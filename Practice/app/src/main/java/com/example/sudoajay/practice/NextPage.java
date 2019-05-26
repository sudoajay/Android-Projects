package com.example.sudoajay.practice;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextPage extends AppCompatActivity {
private Button soundButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
    soundButton =(Button) findViewById(R.id.soundButton);
        final MediaPlayer ring= MediaPlayer.create(NextPage.this,R.raw.a);

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ring.start();

            }
        });
    }
}
