package com.example.sudoajay.flappybird;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by sudoajay on 10/6/17.
 */

public class Background {
    private int x ,y ,speed=3;
    private Bitmap bitmap;
    public Background(int x ,int y , MainClass mainClass){
        this.x = x;
        this.y =y;
        bitmap = BitmapFactory.decodeResource(mainClass.getResources(),R.drawable.ground);
    }
    public void BackGroundUpdate(){
        x-=speed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
