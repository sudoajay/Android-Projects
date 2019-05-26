package com.example.sudoajay.memorygame;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by sudoajay on 9/29/17.
 */

public class HintThreading {
    public boolean isStartThread() {
        return startThread;
    }

    private boolean startThread;
    private Thread thread;
    private Button hintButton;
    private MainLogic mainLogic;
    private Boolean[][] arrayBoolean = new Boolean[4][5];
    private ImageButton[][] arrayImageButton = new ImageButton[4][5];
    private Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            startThread =false;
            for (int i = 0 ; i< arrayImageButton.length;i++){
                for (int j = 0 ; j<arrayImageButton[i].length;j++){

                    if(arrayBoolean[i][j]==false)
                    arrayImageButton[i][j].setImageResource(R.drawable.hiderimage);

                }
            }
        }

    };
    public HintThreading(ImageButton[][] arrayImageButton, Boolean[][] arrayBoolean, MainLogic mainLogic
    , Button hintButton){
        this.arrayImageButton = arrayImageButton;
        this.hintButton=hintButton;
        this.mainLogic = mainLogic;
        this.arrayBoolean = arrayBoolean;
        Threading();
        thread.start();
    }
    private void Threading(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if (startThread) {
                        try {
                            Thread.sleep(1000 * 3);
                            handler.sendEmptyMessage(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void setStartThread(boolean startThread){
        this.startThread = startThread;
    }


}
