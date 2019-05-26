package com.example.sudoajay.memorygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainLogic implements View.OnClickListener {
    private int stepCount,whichType,count=0;
    private MainLogoDesgin logoDesgin;
    private  Button stepButton,hintButton;
    private ImageButton[][] arrayButton = new ImageButton[4][5];
    private ArrayList<Integer> integers = new ArrayList<>(),saveInt = new ArrayList<>();
    private Boolean[][] arrayBoolean = new Boolean[4][5];
    private HintThreading hintThreading;
    private Resources resources ;
    private Thread threading;
    private Drawable firstDrawable;
    private MediaPlayer soundEffect;
    private boolean start = false;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {

                arrayButton[saveInt.get(count-4)][saveInt.get(count-3)].setImageResource(R.drawable.hiderimage);
                arrayButton[saveInt.get(count-2)][saveInt.get(count-1)].setImageResource(R.drawable.hiderimage);

            start =false;
        }
    };



    public MainLogic(int whichType, Button stepButton,Button hintButton , ImageButton[][] arrayButton
            ,Resources resources,MainLogoDesgin logoDesgin){
        this.stepButton = stepButton;
        this.logoDesgin= logoDesgin;
        this.resources =resources;
        this.hintButton =hintButton;
        this.arrayButton = arrayButton;
        this.whichType =whichType;
        stepButton.setText("Steps- "+stepCount);
        soundEffect= MediaPlayer.create(logoDesgin,R.raw.sounds);
        onClickImageButton();
        threading.start();
        hintThreading = new HintThreading(arrayButton,arrayBoolean,this,hintButton);
        setImage(whichType);
        onclickListener();

    }
    public void onclickListener(){
        hintButton.setOnClickListener(this);
        for (int i = 0 ;i<arrayButton.length;i++){
            for (int j=0;j<arrayButton[i].length;j++){
                arrayButton[i][j].setOnClickListener(this);
                arrayBoolean[i][j] = false;
            }
        }
    }

    @Override
    public void onClick(View view) {
    if(!start){
           switch (view.getId()) {
               case R.id.hintButton:
                   clickOnHintButton();
                   break;
               case R.id.imageButton1:
                   getImage(0, 0, 1);
                   break;
               case R.id.imageButton2:
                   getImage(0, 1, 2);
                   break;
               case R.id.imageButton3:
                   getImage(0, 2, 3);
                   break;
               case R.id.imageButton4:
                   getImage(0, 3, 4);
                   break;
               case R.id.imageButton5:
                   getImage(0, 4, 5);
                   break;
               case R.id.imageButton6:
                   getImage(1, 0, 6);
                   break;
               case R.id.imageButton7:
                   getImage(1, 1, 7);
                   break;
               case R.id.imageButton8:
                   getImage(1, 2, 8);
                   break;
               case R.id.imageButton9:
                   getImage(1, 3, 9);
                   break;
               case R.id.imageButton10:
                   getImage(1, 4, 10);
                   break;
               case R.id.imageButton11:
                   getImage(2, 0, 11);
                   break;
               case R.id.imageButton12:
                   getImage(2, 1, 12);
                   break;
               case R.id.imageButton13:
                   getImage(2, 2, 13);
                   break;
               case R.id.imageButton14:
                   getImage(2, 3, 14);
                   break;
               case R.id.imageButton15:
                   getImage(2, 4, 15);
                   break;
               case R.id.imageButton16:
                   getImage(3, 0, 16);
                   break;
               case R.id.imageButton17:
                   getImage(3, 1, 17);
                   break;
               case R.id.imageButton18:
                   getImage(3, 2, 18);
                   break;
               case R.id.imageButton19:
                   getImage(3, 3, 19);
                   break;
               case R.id.imageButton20:
                   getImage(3, 4, 20);
                   break;
           }
       }
        GameEnd();
        stepButton.setText("Steps- "+stepCount);
    }
    public void setImage(int no){
        if(no == 1){
            integers.clear();

                integers.add(R.drawable.javaicon);
                integers.add(R.drawable.javascripticon);
                integers.add(R.drawable.cicon);
                integers.add(R.drawable.clicon);
                integers.add(R.drawable.ckicon);
                integers.add(R.drawable.swifticon);
                integers.add(R.drawable.phpicon);
                integers.add(R.drawable.html5icon);
                integers.add(R.drawable.css3icon);
                integers.add(R.drawable.kotlinicon);
                integers.add(R.drawable.javaicon);
                integers.add(R.drawable.javascripticon);
                integers.add(R.drawable.cicon);
                integers.add(R.drawable.clicon);
                integers.add(R.drawable.ckicon);
                integers.add(R.drawable.swifticon);
                integers.add(R.drawable.phpicon);
                integers.add(R.drawable.html5icon);
                integers.add(R.drawable.css3icon);
                integers.add(R.drawable.kotlinicon);


        }else if(no == 2){
            for(int j = 0;j<2 ;j++) {
                integers.add(R.drawable.eclipseicon);
                integers.add(R.drawable.androidstudioicon);
                integers.add(R.drawable.netbeansicon);
                integers.add(R.drawable.intellijicon);
                integers.add(R.drawable.codeblocksicon);
                integers.add(R.drawable.aptanastudioicon);
                integers.add(R.drawable.visualstudioicon);
                integers.add(R.drawable.komodoicon);
                integers.add(R.drawable.pycharmicon);
                integers.add(R.drawable.turboicon);
            }
        }
        else if(no == 3){
            for(int k = 0;k<2 ;k++) {
                integers.add(R.drawable.appleicon);
                integers.add(R.drawable.alienwareicon);
                integers.add(R.drawable.hpicon);
                integers.add(R.drawable.dellicon);
                integers.add(R.drawable.corsairicon);
                integers.add(R.drawable.intelicon);
                integers.add(R.drawable.nvidiaicon);
                integers.add(R.drawable.radeonicon);
                integers.add(R.drawable.vaioicon);
                integers.add(R.drawable.microsofticon);
            }
        }
        else {
            for(int l = 0;l<2 ;l++) {
                integers.add(R.drawable.googleicon);
                integers.add(R.drawable.youtubeicon);
                integers.add(R.drawable.facebookicon);
                integers.add(R.drawable.githubicon);
                integers.add(R.drawable.stackoverflowicon);
                integers.add(R.drawable.codewarsicon);
                integers.add(R.drawable.amazonicon);
                integers.add(R.drawable.flipkartcon);
                integers.add(R.drawable.snapdealicon);
                integers.add(R.drawable.gaanaicon);
            }
        }
        Collections.shuffle(integers);
    }
        public void getImage(int x, int y , int no){
            if(arrayButton[x][y].getDrawable().getConstantState().equals(resources.getDrawable(R.drawable.hiderimage).getConstantState())  ) {
                stepCount++;
                soundEffect.start();
                arrayButton[x][y].setImageResource(integers.get(no - 1));
                arrayBoolean[x][y] = true;

                    if (firstDrawable == null) {
                            saveInt.add(x);
                            saveInt.add(y);
                        count+=2;
                        firstDrawable = arrayButton[x][y].getDrawable();
                    } else {
                        saveInt.add(x);
                        saveInt.add(y);
                        count+=2;
                        if (!EqualDrawable(firstDrawable, x, y)) {
                            start = true;
                            arrayBoolean[saveInt.get(count-4)][saveInt.get(count-3)] = false;
                            arrayBoolean[saveInt.get(count-2)][saveInt.get(count-1)] = false;
                        }
                        firstDrawable = null;
                    }
            }
    }
    public ArrayList<Integer> getIntegers() {
        return integers;
    }
    public void clickOnHintButton(){
        int k =0;
        hintButton.setEnabled(false);
        hintThreading.setStartThread(true);
            hintButton.setTextColor(Color.parseColor("#e0e1e2"));
        for (int i = 0 ;i<arrayButton.length;i++){
            for (int j = 0 ; j<arrayButton[i].length;j++){
                arrayButton[i][j].setImageResource(integers.get(k));
                k++;
            }
        }
    }
    public Boolean[][] getArrayBoolean() {
        return arrayBoolean;
    }

    public HintThreading getHintThreading() {
        return hintThreading;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public void onClickImageButton(){
        threading = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (start) {
                        try {
                            Thread.sleep(130);
                            handler.sendEmptyMessage(0);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
    public boolean EqualDrawable(Drawable firstDrawable,int x ,int y ){
       if(firstDrawable.getConstantState().equals(arrayButton[x][y].getDrawable().getConstantState()))return true;
        return false;
    }
    public ArrayList<Integer> getSaveInt() {
        return saveInt;
    }


    public void GameEnd(){
        if(CheckForEnd()){
            AlertDialog.Builder alert = new AlertDialog.Builder(logoDesgin);
            alert.setTitle("    Game End !");
            alert.setMessage("Well Done You have Completed it on " + stepCount+ " steps ! Play Again ");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    logoDesgin.defaultIcon();

                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.show();
        }
    }
    public boolean CheckForEnd(){
        for (int i =0;i<arrayBoolean.length;i++){
            for (int j= 0 ;j <arrayBoolean[i].length ; j++){
                if(arrayBoolean[i][j] == false)return false;
            }
        }
        return true;
    }
    public int getStepCount() {
        return stepCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
