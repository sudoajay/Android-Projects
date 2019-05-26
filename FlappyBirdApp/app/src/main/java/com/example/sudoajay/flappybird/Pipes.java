package com.example.sudoajay.flappybird;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by sudoajay on 10/7/17.
 */

public class Pipes {
    private int x ,y ,speed=3,width =100,height=500;
    private Bitmap bitmap;
    public Pipes(int x ,int y ,MainClass mainClass,int drawable ){
        this.x = x;
        this.y =y;
        bitmap = BitmapFactory.decodeResource(mainClass.getResources(),drawable);
    }
    public void PipesUpdate(){
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
}
