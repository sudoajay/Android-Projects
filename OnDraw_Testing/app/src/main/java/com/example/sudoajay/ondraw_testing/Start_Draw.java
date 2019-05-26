package com.example.sudoajay.ondraw_testing;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
/**
 * Created by sudoajay on 2/5/18.
 */


public class Start_Draw extends Activity {
    Draw_View drawView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView = new Draw_View(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);

    }
}

