package com.example.sudoajay.dinosaur;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HowToPlay extends AppCompatActivity {
    private TextView textView;
    private Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        textView = (TextView) findViewById(R.id.textView);


        typeface = Typeface.createFromAsset(getAssets(),"fonts.otf");
        textView.setTypeface(typeface);

    }
}
