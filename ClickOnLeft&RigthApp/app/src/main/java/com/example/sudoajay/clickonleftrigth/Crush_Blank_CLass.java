package com.example.sudoajay.clickonleftrigth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Crush_Blank_CLass extends AppCompatActivity {
    private boolean close =false;
   private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crush__blank__class);
        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("crush");
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
        imageView = (ImageView) findViewById(R.id.imageView4);
        imageView.setImageBitmap(bmp);

    }
    public void onBackPressed() {

        if (close) {
            Intent intent =new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            return;
        }

        this.close = true;
        Toast.makeText(this, " Click on Back To Go to Home ", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                close=false;
            }
        }, 2000);
    }

}
