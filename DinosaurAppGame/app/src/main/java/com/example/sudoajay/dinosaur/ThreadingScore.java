package com.example.sudoajay.dinosaur;

/**
 * Created by sudoajay on 10/2/17.
 */

public class ThreadingScore  {
    private Thread threadTheScore;
    private int s ,h;
    private String score="00",no="0000",showScore="00",highScore="0000";

    public ThreadingScore(){
        RunThread();
        threadTheScore.start();
    }
    public void RunThread(){
        threadTheScore = new Thread(new Runnable() {
            @Override
            public void run() {
                    while(true){
                        try {
                            Thread.sleep(300);
                            scoreEdit();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        });
    }
    public void scoreEdit(){
        s++;
        score= ""+s;
        showScore= no.substring(score.length(),no.length());

    }

    public String getScore() {
        return score;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getShowScore() {
        return showScore;
    }

    public void setShowScore(String showScore) {
        this.showScore = showScore;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
