package com.example.sudoajay.flappybird;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;

/**
 * Created by sudoajay on 10/7/17.
 */

public class FlappyBird implements View.OnClickListener {
    private int x ,y ,width =50,height=45,save;
    private Bitmap bitmap;
    private Rect flappyBird = new Rect();
    private MainClass mainClass;
    private boolean onTouch =false,goDown = true,jump ;
    private Thread thread;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        if(!onTouch){
            if(goDown) {
                mainClass.setRectForTap( new Rect(mainClass.getRectForTap().left,mainClass.getRectForTap().top+1
                        ,mainClass.getRectForTap().right,mainClass.getRectForTap().bottom+1));

                flappyBird.set(flappyBird.left, flappyBird.top + 1, flappyBird.right, (flappyBird.bottom) + 1);
                if(flappyBird.top>=500) goDown =false;
            }else{
                mainClass.setRectForTap( new Rect(mainClass.getRectForTap().left,mainClass.getRectForTap().top-1
                        ,mainClass.getRectForTap().right,mainClass.getRectForTap().bottom-1));

                flappyBird.set(flappyBird.left, flappyBird.top - 1,flappyBird.right, (flappyBird.bottom) - 1);
                if(flappyBird.top<=350) goDown =true;
            }

            }else{
                if(!jump) {
                    if (flappyBird.top <= 820)
                        flappyBird.set(flappyBird.left, flappyBird.top + 3, flappyBird.right, flappyBird.bottom + 3);
                       else{
                        mainClass.setStop(true);
                    }
                }else{
                        if(flappyBird.top >=0)
                    flappyBird.set(flappyBird.left, flappyBird.top - 5, flappyBird.right, flappyBird.bottom - 5);
                    else{
                            jump =false;
                        }
                    if(save-100 >= flappyBird.top  )jump =false;
                }
        }
        }

    };
    public FlappyBird(int x ,int y,MainClass mainClass){
        this.x = x;
        this.y =y;
        this.mainClass = mainClass;
        RunThread();
        thread.start();
        flappyBird.set(x,y,x+width,y+height);
    }
    public void ChangeDrawable(int drawable){
        bitmap = BitmapFactory.decodeResource(mainClass.getResources(),drawable);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rect getFlappyBird() {
        return flappyBird;
    }

    public void setFlappyBird(Rect flappyBird) {
        this.flappyBird = flappyBird;
    }

    @Override
    public void onClick(View view) {
        if(!onTouch)
        onTouch =true;
        if(!jump) {
            jump = true;
        mainClass.getJumpSound().start();
        }
        save = flappyBird.top;
    }

    public boolean getOnTouch() {
        return onTouch;
    }

    public void setOnTouch(boolean onTouch) {
        this.onTouch = onTouch;
    }
    public void RunThread(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
