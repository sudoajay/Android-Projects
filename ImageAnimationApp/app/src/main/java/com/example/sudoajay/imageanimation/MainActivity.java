package com.example.sudoajay.imageanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView ,imageView1;
    private final int timing = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView1 = (ImageView) findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView.getAlpha() == 1f) {
                    imageView.animate().alpha(0f).setDuration(timing);
                    imageView1.animate().alpha(1f).setDuration(timing);
                }else if(imageView.getAlpha() == 0f){
                    imageView.animate().alpha(1f).setDuration(timing);
                   imageView1.animate().alpha(0f).setDuration(timing);
                }else{
                    Toast.makeText(MainActivity.this, "Let That Animate Be Done First", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
