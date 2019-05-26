package com.example.sudoajay.flappybird;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Aboutgame extends AppCompatActivity {
    private Typeface  typeface;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutgame);
        typeface = Typeface.createFromAsset(getAssets() ,"font.otf");
        textView = (TextView) findViewById(R.id.textView2);
        textView.setTypeface(typeface);
    }
}
