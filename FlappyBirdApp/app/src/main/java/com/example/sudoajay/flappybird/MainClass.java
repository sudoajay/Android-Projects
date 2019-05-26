package com.example.sudoajay.flappybird;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sudoajay on 10/5/17.
 */

public class MainClass extends View {
    private ArrayList<Pipes> arrayForPipe= new ArrayList<>();
    private Bitmap backgroundBitmap;
    private Play play;
    private Typeface typeface;
    private Thread thread;
    private Random random = new Random();
    private ArrayList<Background> arrayForBackground = new ArrayList<>();
    private ArrayList<Cloud> arrayForCloud = new ArrayList<>();
    private FlappyBird flappyBird;
    private Boolean firstImage=true,stop=false;
    private Paint paint = new Paint();
    private Rect rectForTap = new Rect(350,425,350,425);
    private  int flappyDrawable =R.drawable.flappyfirststep,score=0;
    private MediaPlayer hitSound,jumpSound;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(firstImage){
                firstImage = false;
                flappyDrawable= R.drawable.flappyfirststep;
            }else{
                firstImage=true;
                flappyDrawable= R.drawable.flappyseondstep;
            }


        }
    };


    public MainClass(Context context, Play play) {
        super(context);
        this.play = play;
        hitSound = MediaPlayer.create(play,R.raw.sounds);
        jumpSound = MediaPlayer.create(play,R.raw.jump);

        Run();
        thread.start();
        flappyBird = new FlappyBird(200,350,this);
        this.setOnClickListener(flappyBird);
        Starting();

    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#dbe8ff"));


        if(flappyBird.getOnTouch()) {

            //draw and Cloud
            for (int i = arrayForCloud.size() - 1; i >= 0; i--) {
                canvas.drawBitmap(arrayForCloud.get(i).getBitmap(), arrayForCloud.get(i).getX(), arrayForCloud.get(i).getY(), null);
                arrayForCloud.get(i).CloudUpdate();
                if (arrayForCloud.get(i).getX() <= -150) {
                    if (arrayForCloud.size() <= 1)
                        DrawCloud();
                    arrayForCloud.remove(i);
                }
            }

            // draw Pipes
            for (int i = arrayForPipe.size() - 1; i >= 0; i--) {
                canvas.drawBitmap(arrayForPipe.get(i).getBitmap(), arrayForPipe.get(i).getX(), arrayForPipe.get(i).getY(), null);
                arrayForPipe.get(i).PipesUpdate();
                if (arrayForPipe.get(i).getX() <= -arrayForPipe.get(i).getWidth() - 50) {
                    if (i % 2 == 0)
                        DrawPipes();
                    arrayForPipe.remove(i);
                }
            }
        }else{
            typeface = Typeface.createFromAsset(play.getAssets() , "tap.otf");
            paint.setTypeface(typeface);
            paint.setColor(Color.parseColor("#ffa126"));
            paint.setTextSize(80);
            canvas.drawText("Tap" ,rectForTap.left ,rectForTap.top , paint);
        }

        // draw an ground
        for (int i = arrayForBackground.size() - 1; i >= 0; i--) {
            canvas.drawBitmap(arrayForBackground.get(i).getBitmap(), arrayForBackground.get(i).getX(), arrayForBackground.get(i).getY(), null);
                arrayForBackground.get(i).BackGroundUpdate();
            if (arrayForBackground.get(i).getX() <= -500) {
                DrawBackgound();
                arrayForBackground.remove(i);
            }
        }

        // draw an FlappyBird
        flappyBird.ChangeDrawable(flappyDrawable);
        canvas.drawBitmap(flappyBird.getBitmap(),flappyBird.getFlappyBird().left,flappyBird.getFlappyBird().top,null);

        // draw  an ScoreBoard
        typeface = Typeface.createFromAsset(play.getAssets() , "score.ttf");
        paint.setColor(Color.BLACK);
        paint.setTypeface(typeface);
        paint.setTextSize(100);
        canvas.drawText(""+score/2,getWidth()/2 , 80,paint);

        checkForScore();
        Intersection();

        if(!stop)
        invalidate();
        else{
            hitSound.start();
            GameEnd();
        }
    }

    public void DrawBackgound() {
        arrayForBackground.add(new Background(arrayForBackground.get(arrayForBackground.size() - 1).getX() + 500, 900, this));
    }

    public void DrawCloud() {
        int getRandomNo = random.nextInt(5) + 1;
        arrayForCloud.add(new Cloud(arrayForCloud.get(arrayForCloud.size() - 1).getX() + random.nextInt(300)+800, random.nextInt(100) + 50, this,CloudDrawable()));
        for (int i = 1; i < getRandomNo; i++)
            arrayForCloud.add(new Cloud(arrayForCloud.get(arrayForCloud.size() - 1).getX() + random.nextInt(100)+400, random.nextInt(100) + 50, this,CloudDrawable()));
    }

    public int CloudDrawable() {
        switch (random.nextInt(2) + 1) {
            case 1:
                return R.drawable.cloud1;
            case 2:
                return R.drawable.cloud4;
        }
        return 0;
    }
    public void DrawPipes() {
        switch (random.nextInt(5) + 1) {
            case 1 :arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX()+random.nextInt(300)+400, -290, this, R.drawable.pipe1));
                    arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX(), 590, this, R.drawable.pipe));
                break;
            case 2 :arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX()+random.nextInt(300)+400, -390, this, R.drawable.pipe1));
                    arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX(), 490, this, R.drawable.pipe));
                break;
            case 3 :arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX()+random.nextInt(300)+400, -490, this, R.drawable.pipe1));
                    arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX(), 390, this, R.drawable.pipe));
                break;
            case 4 :arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX()+random.nextInt(300)+400, -190, this, R.drawable.pipe1));
                    arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX(), 700, this, R.drawable.pipe));
                break;
            case 5 :arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX()+random.nextInt(300)+400, -90, this, R.drawable.pipe1));
                    arrayForPipe.add(new Pipes(arrayForPipe.get(arrayForPipe.size()-1).getX(), 800, this, R.drawable.pipe));
                break;
        }
    }

    public void Run(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
            while(true) {
                try {
                        Thread.sleep(200);
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            }
        });
    }

    public Rect getRectForTap() {
        return rectForTap;
    }

    public void setRectForTap(Rect rectForTap) {
        this.rectForTap = rectForTap;
    }

    public void checkForScore(){
        for (int i =0; i < arrayForPipe.size(); i++) {
            if(i % 2 ==0) {
                for (int j = 0; j <= 5; j++) {
                    if (flappyBird.getFlappyBird().left == arrayForPipe.get(i).getX() + j && flappyBird.getFlappyBird().left == arrayForPipe.get(i + 1).getX() + j) {
                        score++;
                        break;
                    }
                }
            }
        }
    }
    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    public void Intersection() {
        for (int i =0; i < arrayForPipe.size(); i++) {
            if(i % 2 != 0) {
                if (flappyBird.getFlappyBird().intersect(arrayForPipe.get(i).getX()-30, arrayForPipe.get(i).getY()-30
                        , arrayForPipe.get(i).getWidth()-30 + arrayForPipe.get(i).getX(),
                        arrayForPipe.get(i).getHeight() + arrayForPipe.get(i).getY()-30))
                    stop= true;
            }else{
                if (flappyBird.getFlappyBird().intersect(arrayForPipe.get(i).getX()-20, arrayForPipe.get(i).getY()+90
                        , arrayForPipe.get(i).getWidth() + arrayForPipe.get(i).getX()-20,
                        arrayForPipe.get(i).getHeight() + arrayForPipe.get(i).getY()+90 ))
                    stop= true;
            }
        }
    }
    public void GameEnd(){

            AlertDialog.Builder alert = new AlertDialog.Builder(play);
            alert.setTitle("   Game Over !");
            alert.setMessage("You Score is " + (score / 2) + " & You Wanna Play Again ? ");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    GameRestart();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(play.getApplicationContext(), MainActivity.class);
                    play.startActivity(intent);
                }
            });
            alert.show();

    }
    public void GameRestart(){
        arrayForPipe.clear();
        arrayForCloud.clear();
        arrayForBackground.clear();

        Starting();
        score = 0;
        stop = false;
        flappyBird.setOnTouch(false);
        flappyBird.setFlappyBird(new Rect(200,350,50+200,45+350));
        rectForTap.set(350,425,350,425);

        invalidate();
    }
    public void Starting(){

        arrayForBackground.add(new Background(0, 900, this));
        arrayForCloud.add(new Cloud(800, random.nextInt(100) + 50, this,CloudDrawable()));
        arrayForPipe.add(new Pipes(800, -290, this, R.drawable.pipe1));
        arrayForPipe.add(new Pipes(800, 590, this, R.drawable.pipe));
        DrawPipes();
        DrawCloud();
        DrawBackgound();
        backgroundBitmap = BitmapFactory.decodeResource(play.getResources(), R.drawable.ground);

    }

    public MediaPlayer getJumpSound() {
        return jumpSound;
    }

    public void setJumpSound(MediaPlayer jumpSound) {
        this.jumpSound = jumpSound;
    }
}
