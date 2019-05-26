package com.example.sudoajay.clickonleftrigth;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Typeface typeface;
    private boolean close= false;
    private ImageView imageView, imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView) findViewById(R.id.textView);
        typeface =Typeface.createFromAsset(getAssets(),"font.otf");
        textView.setTypeface(typeface);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 =(ImageView) findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),MainDesgin.class);
                intent.putExtra("com.example.sudoajay.clickonleftrigth.man","man");
                startActivity(intent);

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),MainDesgin.class);
                intent.putExtra("com.example.sudoajay.clickonleftrigth.woman","woman");
                startActivity(intent);

            }
        });

    }
    public void onBackPressed() {

        if (close) {
            Finish();
            return;
        }

        this.close = true;
        Toast.makeText(this, " Click on Back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                close=false;
            }
        }, 2000);
    }

    public void Finish(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }
}
