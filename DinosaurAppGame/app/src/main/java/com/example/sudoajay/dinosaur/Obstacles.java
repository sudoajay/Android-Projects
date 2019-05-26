package com.example.sudoajay.dinosaur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sudoajay on 10/2/17.
 */

public class Obstacles {
    private int x,y ,speed=8,width ,heigth;
    private Bitmap obstakleBitMap;
    public Obstacles(int x  ,int drawable,int y ,mainDesign design , int width ,int height){
        this.x = x;
        this.y = y;
        this.width =width;
        this.heigth =height;
        obstakleBitMap = BitmapFactory.decodeResource(design.getResources(), drawable);

    }
    public void ObStaclesUpdate(int no){
        x-=speed+no;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public Bitmap getObstakleBitMap() {
        return obstakleBitMap;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

}
