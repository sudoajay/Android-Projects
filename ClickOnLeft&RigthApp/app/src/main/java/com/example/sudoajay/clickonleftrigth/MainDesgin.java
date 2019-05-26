package com.example.sudoajay.clickonleftrigth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainDesgin extends AppCompatActivity {
    private TextView textView;
    private  String getInterested ;
    private ImageView imageView , imageView1 ,imageView2, imageView3;
    private final int timing =1500;
    private Drawable save_Latest_Crush;
    private MainLogic mainLogic;
    private int count = 1,limit;
    private boolean close =false;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_desgin);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);


        if (getIntent().getExtras().getString("com.example.sudoajay.clickonleftrigth.woman")
                != null) {
            getInterested = "woman";
            limit = 50;
        } else {
            limit = 20;
            getInterested = "men";
        }
        mainLogic = new MainLogic(getInterested);
        Add_Images_From_Resources();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count != limit) {
                    if (imageView2.getAlpha() == 1f) {
                        imageView2.animate().alpha(0f).setDuration(timing);
                        imageView3.animate().alpha(1f).setDuration(timing);

                        // set New Image
                        imageView3.setImageResource(mainLogic.getNumber().get(count));
                        count++;
                    } else if (imageView2.getAlpha() == 0f) {
                        imageView2.animate().alpha(1f).setDuration(timing);
                        imageView3.animate().alpha(0f).setDuration(timing);

                        // set New Image
                        imageView2.setImageResource(mainLogic.getNumber().get(count));
                        count++;
                    } else {
                        Toast.makeText(MainDesgin.this, "Let The Animation Load First",
                                Toast.LENGTH_SHORT).show();
                    }

                    if (imageView.getAlpha() == 0) {
                        save_Latest_Crush = imageView1.getDrawable();
                    } else {
                        save_Latest_Crush = imageView.getDrawable();
                    }

                } else {
                    GameOver();
                }

            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count != limit) {
                    if (imageView.getAlpha() == 1f) {
                        imageView.animate().alpha(0f).setDuration(timing);
                        imageView1.animate().alpha(1f).setDuration(timing);

                        // set New Image
                        imageView1.setImageResource(mainLogic.getNumber().get(count));
                        count++;
                    } else if (imageView.getAlpha() == 0f) {
                        imageView.animate().alpha(1f).setDuration(timing);
                        imageView1.animate().alpha(0f).setDuration(timing);

                        // set New Image
                        imageView.setImageResource(mainLogic.getNumber().get(count));
                        count++;
                    } else {
                        Toast.makeText(MainDesgin.this, "Let The Animation Load First",
                                Toast.LENGTH_SHORT).show();
                    }

                    if (imageView2.getAlpha() == 0) {
                        save_Latest_Crush = imageView3.getDrawable();
                    } else {
                        save_Latest_Crush = imageView2.getDrawable();
                    }
                } else {
                    GameOver();
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainDesgin.this);
                alert.setTitle("     Stop !");
                alert.setMessage("You Found Your Crush ? ");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        GameOver();
                    }
                });
                alert.setNegativeButton("No", null);
                alert.show();


            }
        });
    }
            public void Add_Images_From_Resources() {
                imageView.setImageResource(mainLogic.getNumber().get(count));
                count++;
                imageView1.setImageResource(mainLogic.getNumber().get(count));
                count++;
                imageView2.setImageResource(mainLogic.getNumber().get(count));
                count++;
                imageView3.setImageResource(mainLogic.getNumber().get(count));
                count++;
                save_Latest_Crush = imageView2.getDrawable();

            }

            public void onBackPressed() {

                if (close) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    return;
                }

                this.close = true;
                Toast.makeText(this, " Click on Back To Go to Home ", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        close = false;
                    }
                }, 2000);
            }

            public void GameOver() {

                Bitmap bitmap = ((BitmapDrawable) save_Latest_Crush).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();

                Intent intent = new Intent(getApplicationContext(), Crush_Blank_CLass.class);
                intent.putExtra("crush", b);
                startActivity(intent);


            }
        }

