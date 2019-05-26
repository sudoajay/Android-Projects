package com.example.sudoajay.dinosaur;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutMe extends AppCompatActivity{
    private TextView aboutMeTextView;
    private Typeface face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        aboutMeTextView = (TextView) findViewById(R.id.aboutTextView);
        face = Typeface.createFromAsset(getAssets() , "fonts.otf");
        aboutMeTextView.setTypeface(face);
    }
}
