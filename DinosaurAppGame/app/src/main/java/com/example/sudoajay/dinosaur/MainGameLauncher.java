package com.example.sudoajay.dinosaur;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainGameLauncher extends AppCompatActivity implements View.OnClickListener{

    private Button playButton , howToPlayButton,aboutMeButton;
    private Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_launcher);

        playButton =(Button) findViewById(R.id.button1);
        howToPlayButton =(Button) findViewById(R.id.button2);
        aboutMeButton =(Button) findViewById(R.id.button3);

        typeface = Typeface.createFromAsset(getAssets() , "font.otf");

        playButton.setTypeface(typeface);
        howToPlayButton.setTypeface(typeface);
        aboutMeButton.setTypeface(typeface);

        playButton.setOnClickListener(this);
        howToPlayButton.setOnClickListener(this);
        aboutMeButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button1:
                Intent intent1 = new Intent(getApplicationContext(),MainPage.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(getApplicationContext(),HowToPlay.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(getApplicationContext(),AboutMe.class);
                startActivity(intent3);
                break;
        }
    }
}
