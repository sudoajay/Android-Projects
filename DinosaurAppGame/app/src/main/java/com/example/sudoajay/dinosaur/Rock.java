package com.example.sudoajay.dinosaur;

/**
 * Created by sudoajay on 10/2/17.
 */

public class Rock {
    private int x,y ,speed=8;
    public Rock(int x ,int y ){
        this.x = x;
        this.y = y;

    }
    public void RockUpdate(int no){
        x-=speed+no;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
