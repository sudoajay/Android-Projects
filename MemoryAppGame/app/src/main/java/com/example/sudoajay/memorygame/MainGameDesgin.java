package com.example.sudoajay.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainGameDesgin extends AppCompatActivity implements View.OnClickListener {
    private Button firstButton,secondButton,thirdButton,forthButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_desgin);
        firstButton = (Button) findViewById(R.id.languageButton);
        firstButton.setOnClickListener(this);
        secondButton = (Button) findViewById(R.id.IdeButton);
        secondButton.setOnClickListener(this);
        thirdButton = (Button) findViewById(R.id.campanyButton);
        thirdButton.setOnClickListener(this);
        forthButton = (Button) findViewById(R.id.sitesButton);
        forthButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.languageButton:
                Intent intent2 = new Intent(getApplicationContext(),MainLogoDesgin.class);
                intent2.putExtra("com.example.sudoajay.memorygame",1);
                startActivity(intent2);
                break;
            case R.id.IdeButton:
                Intent intent4 = new Intent(getApplicationContext(),MainLogoDesgin.class);
                intent4.putExtra("com.example.sudoajay.memorygame",2);
                startActivity(intent4);
                break;
            case R.id.campanyButton:
                Intent intent5 = new Intent(getApplicationContext(),MainLogoDesgin.class);
                intent5.putExtra("com.example.sudoajay.memorygame",3);
                startActivity(intent5);
                break;
            case R.id.sitesButton:
                Intent intent6 = new Intent(getApplicationContext(),MainLogoDesgin.class);
                intent6.putExtra("com.example.sudoajay.memorygame",4);
                startActivity(intent6);
                break;
        }
    }
}
