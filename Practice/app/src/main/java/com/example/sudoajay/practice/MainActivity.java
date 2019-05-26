package com.example.sudoajay.practice;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity  {
    private Button button2 ,threading;
    private TextView textView;
    private Thread thread;
     private Handler handler = new Handler(){
         @Override
         public void handleMessage(Message msg) {
                textView.setText("" + msg.toString());
         }


     };



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);
        Button secondPage = (Button) findViewById(R.id.button);
        secondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent second = new Intent(getApplicationContext(),NextPage.class);
                startActivity(second);
            }
        });
        threading = (Button) findViewById(R.id.Threading);
        threading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThreadWorking();
                thread.start();
            }
        });




    }

    public void ThreadWorking(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=10 ;i>0;i-- ){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


 }
