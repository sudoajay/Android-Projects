package com.example.sudoajay.dinosaur;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sudoajay on 10/1/17.
 */

public class mainDesign extends View {
    private ArrayList<Cloud> arrayForCloud = new ArrayList<>();
    private ArrayList<Rock> arrayForRock= new ArrayList<>();
    private ArrayList<Obstacles> arrayForObstacles= new ArrayList<>();
    private Paint paint=new Paint();
    private ThreadingScore threadingScore;
    private MediaPlayer player;
    private Random random = new Random();
    private  Dino dino ;
    private int setY,speed= 0 ,check =100 ,heigth ,width ;
    private boolean stop ;
    private MainPage page =new MainPage();
    public mainDesign(Context context,MainPage page ) {
        super(context);
        this.page = page;
        threadingScore = new ThreadingScore();
        arrayForCloud.add(new Cloud(1000,random.nextInt(200)+40,ReturnBack(1),this));
        arrayForRock.add(new Rock(20,950));
        arrayForObstacles.add(new Obstacles(800,ReturnBack(2),setY,this,width,heigth));
        player= MediaPlayer.create(page,R.raw.sounds);
        dino = new Dino(100,860,this);
        this.setOnTouchListener(dino);
        DrawObstacles();
        for (int x= 0 ; x <25;x++) {
           DrawRockArray();
       }
    }



    public void onDraw(Canvas c)
    {
        super.onDraw(c);

        // draw String
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        paint.setTypeface(Typeface.create("sans-serif-light", Typeface.ITALIC));
        c.drawText(" H S "+threadingScore.getHighScore(),getWidth()-300,50,paint);
        c.drawText(" S "+threadingScore.getShowScore()+threadingScore.getScore(),getWidth()-150,50,paint);

        // draw cloud
        for (int i = arrayForCloud.size()-1;i>=0;i--) {
            c.drawBitmap(arrayForCloud.get(i).getCloud(), arrayForCloud.get(i).getX(), arrayForCloud.get(i).getY(), null);
            arrayForCloud.get(i).CloudUpdate(ChangeSpeed());
            if(arrayForCloud.get(i).getX() <= 0-arrayForCloud.get(i).getCloud().getWidth()){
               if(arrayForCloud.size() < 2)
                MakeCloudArray();
                arrayForCloud.remove(i);
            }
        }
        //draw  below line
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#d6d6d6"));
        c.drawLine(0,getHeight()-200,getWidth(),getHeight()-200,paint);

        //draw rock Side the Line
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        for (int i = arrayForRock.size()-1;i>=0;i--) {
            c.drawCircle(arrayForRock.get(i).getX(),arrayForRock.get(i).getY(),2,paint);
            arrayForRock.get(i).RockUpdate(ChangeSpeed());
            if(arrayForRock.get(i).getX() < -10){
                arrayForRock.remove(i);
                DrawRockArray();
            }

        }

        //draw Obstacles
        for (int i = arrayForObstacles.size()-1;i>=0;i--) {
            c.drawBitmap(arrayForObstacles.get(i).getObstakleBitMap(), arrayForObstacles.get(i).getX(), arrayForObstacles.get(i).getY(), null);
            arrayForObstacles.get(i).ObStaclesUpdate(ChangeSpeed());
            if(arrayForObstacles.get(i).getX() <= 0-arrayForObstacles.get(i).getObstakleBitMap().getWidth()){
                if(arrayForObstacles.size() <= 2)
                DrawObstacles();
                arrayForObstacles.remove(i);

            }
        }
        // draw Dino
            c.drawBitmap(dino.getDinoBit() , dino.getDinoRect().left ,dino.getDinoRect().top,null);

        collapseDino();
        if(!stop)
        invalidate();

    }
    public void MakeCloudArray(){
        int get = random.nextInt(2)+1;
        for (int i = 0 ; i < get;i++)
        arrayForCloud.add(new Cloud(random.nextInt(1500)+getWidth(),random.nextInt(200)+40,ReturnBack(1),this));

    }

    public void DrawRockArray(){
        arrayForRock.add(new Rock(arrayForRock.get(arrayForRock.size()-1).getX()+random.nextInt(100)+100
                , random.nextInt(40)+950));
    }
    public void DrawObstacles(){
        arrayForObstacles.add(new Obstacles(arrayForObstacles.get(arrayForObstacles.size()-1).getX()+
                random.nextInt(400)+800,ReturnBack(2),setY  ,this,width ,heigth));
        arrayForObstacles.add(new Obstacles(arrayForObstacles.get(arrayForObstacles.size()-1).getX()+
                random.nextInt(200)+600,ReturnBack(2),setY  ,this,width ,heigth));

    }
    public int ReturnBack(int no) {
        if (no == 1) {
            switch (random.nextInt(4) + 1) {
                case 1:
                    return R.drawable.cloud1;
                case 2:
                    return R.drawable.cloud2;
                case 3:
                    return R.drawable.cloud3;
                case 4:
                    return R.drawable.cloud4;
            }
        } else {
            switch (random.nextInt(3)+1) {
                case 1:setY = 805;
                        width = heigth=80;
                    return R.drawable.tree;
                case 2:setY = 775;
                    width = heigth=100;
                    return R.drawable.tree1;
                case 3:setY = 845;
                    width = heigth=60;
                    return R.drawable.tree3;
            }
        }
        return 0;
    }
    public int ChangeSpeed(){
        if(threadingScore.getS() >=check) {
            check += 100;
            speed += 1;
        }
        return  speed;
    }
    public void collapseDino() {

            for (int i = arrayForObstacles.size() - 1; i >= 0; i--) {
                if (arrayForObstacles.get(0).getWidth() == 100) {
                    if (dino.getDinoRect().intersect(arrayForObstacles.get(i).getX() + 50, arrayForObstacles.get(i).getY()+10,
                            (arrayForObstacles.get(i).getX() + arrayForObstacles.get(0).getWidth() + 50), (arrayForObstacles.get(i).getY()+10 + arrayForObstacles.get(0).getHeigth()))) {
                        player.start();
                        stop = true;
                    }
                } else if (arrayForObstacles.get(0).getWidth() == 80) {
                    if (dino.getDinoRect().intersect(arrayForObstacles.get(i).getX() + 35, arrayForObstacles.get(i).getY() - 10,
                            (arrayForObstacles.get(i).getX() + arrayForObstacles.get(0).getWidth() + 35), (arrayForObstacles.get(i).getY() - 10 + arrayForObstacles.get(0).getHeigth()))) {
                        player.start();
                        stop = true;
                    }
                } else {
                    if (dino.getDinoRect().intersect(arrayForObstacles.get(i).getX() + 20, arrayForObstacles.get(i).getY() - 10,
                            (arrayForObstacles.get(i).getX() + arrayForObstacles.get(0).getWidth() + 20), (arrayForObstacles.get(i).getY() - 10 + arrayForObstacles.get(0).getHeigth()))) {
                        player.start();
                        stop = true;

                    }
                }
                if (stop) {

                    GameOver();
                }



        }
    }
    public void GameOver(){
        dino.GmeStartAgain(100,860);
        AlertDialog.Builder alert = new AlertDialog.Builder(page);
        alert.setTitle("     Game Over ! ");
        alert.setMessage("You Played Well & Your Score is " + threadingScore.getS() + " & Wanna Play Again ? " );
        if(threadingScore.getS() > threadingScore.getH()){
            threadingScore.setHighScore( threadingScore.getShowScore()+threadingScore.getScore());
            threadingScore.setH(threadingScore.getS());
            alert.setMessage("Well Done You Just Beat The HighScore & Wanna Play Again ? ");
        }
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                GameRestart();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alert.show();

    }
        public void GameRestart(){
            arrayForObstacles.clear();
            threadingScore.setS(0);
            arrayForCloud.clear();


            arrayForCloud.add(new Cloud(1000,random.nextInt(200)+40,ReturnBack(1),this));
            arrayForObstacles.add(new Obstacles(800,ReturnBack(2),setY,this,width,heigth));

            speed= 1;
            stop =false;
            invalidate();
        }

}
