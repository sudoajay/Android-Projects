package com.example.sudoajay.dinosaur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.constraint.solver.widgets.Rectangle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sudoajay on 10/3/17.
 */

public class Dino implements View.OnTouchListener {
    private Rect dinoRect = new Rect();
    private Thread thread;
    private Bitmap dinoBit ;
    private int width = 40,heigth=43,x,y;
    private boolean jump,down = false;
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(!down) {
                dinoRect.set(dinoRect.left, dinoRect.top -=1, dinoRect.right, dinoRect.bottom-=1);
                if(dinoRect.top <= 550)down = true;
            }else{
                dinoRect.set(dinoRect.left ,dinoRect.top+=1,dinoRect.right, dinoRect.bottom+=1);
                if(dinoRect.top >= 860 )jump =false;
            }
        }
        };
    public Dino (int x , int y , mainDesign design){
         dinoRect.set(x,y,(x+width),(y+heigth));
        this.x = x ;
        this.y =y;
        runThread();
        thread.start();
        dinoBit= BitmapFactory.decodeResource(design.getResources(), R.drawable.dino);


    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(!jump) {
            jump = true;
            down =false;
        }
        return true;
    }
    public void runThread(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(jump){
                        try {
                            Thread.sleep(1);
                            handler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public Rect getDinoRect() {
        return dinoRect;
    }

    public Bitmap getDinoBit() {
        return dinoBit;
    }
    public void GmeStartAgain(int x, int y){
        dinoRect.set(x,y,(x+width),(y+heigth));
        jump = true;
        down =false;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }
}
