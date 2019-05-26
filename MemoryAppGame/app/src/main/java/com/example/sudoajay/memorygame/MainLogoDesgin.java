package com.example.sudoajay.memorygame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Collections;

public class MainLogoDesgin extends AppCompatActivity implements View.OnClickListener{
    private Button backButton,restartButton,menuButton,stepButton,hintButton;
    private ImageButton[][] arrayButton = new ImageButton[4][5];
    private MainLogic logic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_logo_desgin);
        backButton =(Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
        restartButton =(Button) findViewById(R.id.restartButton);
        restartButton.setOnClickListener(this);
        menuButton =(Button) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(this);
        stepButton = (Button) findViewById(R.id.stepsButton);
        hintButton=(Button) findViewById(R.id.hintButton);
        arrayReference();
        whichoneClicked(getIntent().getExtras().getInt("com.example.sudoajay.memorygame"));
    }
    public void arrayReference(){
        arrayButton[0][0] = (ImageButton) findViewById(R.id.imageButton1);
        arrayButton[0][1] = (ImageButton) findViewById(R.id.imageButton2);
        arrayButton[0][2] = (ImageButton) findViewById(R.id.imageButton3);
        arrayButton[0][3] = (ImageButton) findViewById(R.id.imageButton4);
        arrayButton[0][4] = (ImageButton) findViewById(R.id.imageButton5);
        arrayButton[1][0] = (ImageButton) findViewById(R.id.imageButton6);
        arrayButton[1][1] = (ImageButton) findViewById(R.id.imageButton7);
        arrayButton[1][2] = (ImageButton) findViewById(R.id.imageButton8);
        arrayButton[1][3] = (ImageButton) findViewById(R.id.imageButton9);
        arrayButton[1][4] = (ImageButton) findViewById(R.id.imageButton10);
        arrayButton[2][0] = (ImageButton) findViewById(R.id.imageButton11);
        arrayButton[2][1] = (ImageButton) findViewById(R.id.imageButton12);
        arrayButton[2][2] = (ImageButton) findViewById(R.id.imageButton13);
        arrayButton[2][3] = (ImageButton) findViewById(R.id.imageButton14);
        arrayButton[2][4] = (ImageButton) findViewById(R.id.imageButton15);
        arrayButton[3][0] = (ImageButton) findViewById(R.id.imageButton16);
        arrayButton[3][1] = (ImageButton) findViewById(R.id.imageButton17);
        arrayButton[3][2] = (ImageButton) findViewById(R.id.imageButton18);
        arrayButton[3][3] = (ImageButton) findViewById(R.id.imageButton19);
        arrayButton[3][4] = (ImageButton) findViewById(R.id.imageButton20);

    }
    private void whichoneClicked(int key ){
        switch (key){
            case 1 :logic = new MainLogic(1,stepButton,hintButton,arrayButton,getResources(),MainLogoDesgin.this);
                break;
            case 2 :logic = new MainLogic(2,stepButton,hintButton,arrayButton,getResources(),MainLogoDesgin.this);
                break;
            case 3 :logic = new MainLogic(3,stepButton,hintButton,arrayButton,getResources(),MainLogoDesgin.this);
                break;
            case 4 :logic = new MainLogic(4,stepButton,hintButton,arrayButton,getResources(),MainLogoDesgin.this);
                break;

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backButton:
                Intent intent = new Intent(getApplicationContext(),MainGameDesgin.class);
                startActivity(intent);
                break;
            case R.id.restartButton:RestartGame();
                break;
            case R.id.menuButton:
                Intent intent1 = new Intent(getApplicationContext(),MainGameLauncher.class);
                startActivity(intent1);
                break;
        }
    }
    public void RestartGame(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainLogoDesgin.this);
        alert.setTitle("       Restart The Game ! ");
        alert.setMessage("Are You Sure To Restart It ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                defaultIcon();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }
    public void defaultIcon(){

        for (int i= 0;i<arrayButton.length;i++){
            for (int j = 0 ;j<arrayButton[i].length;j++){
                arrayButton[i][j].setImageResource(R.drawable.hiderimage);
               logic.getArrayBoolean()[i][j] = false;
            }
        }
        Collections.shuffle(logic.getIntegers());
        hintButton.setEnabled(true);
        hintButton.setTextColor(Color.parseColor("#153972"));
        logic.getHintThreading().setStartThread(true);
        logic.setStepCount(0);
        logic.setCount(0);
        logic.getSaveInt().clear();
        stepButton.setText("Steps- " + logic.getStepCount() );
        logic.getSaveInt().clear();
    }
}
