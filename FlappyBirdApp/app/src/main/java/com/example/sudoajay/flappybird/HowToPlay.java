package com.example.sudoajay.flappybird;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HowToPlay extends AppCompatActivity {
    private Typeface typeface;
    private TextView mainTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        mainTextView = (TextView) findViewById(R.id.textView4);

        typeface = Typeface.createFromAsset(getAssets() ,"font.otf");
        mainTextView.setTypeface(typeface);
    }
}
