package com.example.sudoajay.flappybird;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Typeface typeface ;
    private TextView mainTextView;
    private Button play,aboutGame,howToPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = (TextView) findViewById(R.id.textView);
        play = (Button) findViewById(R.id.button);
        play.setOnClickListener(this);
        aboutGame = (Button) findViewById(R.id.button2);
        aboutGame.setOnClickListener(this);
        howToPlay = (Button) findViewById(R.id.button1);
        howToPlay.setOnClickListener(this);


        typeface = Typeface.createFromAsset(getAssets() ,"font.otf");
        mainTextView.setTypeface(typeface);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                Intent intent = new Intent(getApplicationContext() ,Aboutgame.class);
                startActivity(intent);
                break;
            case R.id.button1:
                Intent intent1 = new Intent(getApplicationContext() ,HowToPlay.class);
                startActivity(intent1);
                break;
            case R.id.button:
                Intent intent2 = new Intent(getApplicationContext() ,Play.class);
                startActivity(intent2);                break;
        }
    }
}
