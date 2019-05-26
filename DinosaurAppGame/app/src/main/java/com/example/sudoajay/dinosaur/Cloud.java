package com.example.sudoajay.dinosaur;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.util.Random;

/**
 * Created by sudoajay on 10/1/17.
 */

public class Cloud {
    private Random random = new Random();
    private int size,x,y,speed ;
     private Bitmap cloud;
    public Cloud(int x , int y , int drawable , mainDesign design){
        this.x =x;
        this.y = y;
        cloud= BitmapFactory.decodeResource(design.getResources(), drawable);
        speed =random.nextInt(2)+1;
    }
    public void CloudUpdate(int no){
        x-=speed+no;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public Bitmap getCloud() {
        return cloud;
    }

    public void setCloud(Bitmap cloud) {
        this.cloud = cloud;
    }

}
