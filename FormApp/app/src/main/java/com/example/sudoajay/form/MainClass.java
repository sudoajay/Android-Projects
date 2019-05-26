package com.example.sudoajay.form;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainClass extends AppCompatActivity {
    private Typeface typeface1;
    private TextView view,view2;
    private ReadFile file = new ReadFile();
    private Button button,button1;
    private boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);

        view = (TextView) findViewById(R.id.textView);
        view2 = (TextView) findViewById(R.id.textView1);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });
        typeface1 = Typeface.createFromAsset(getAssets(),"Sansation.ttf");
        button.setTypeface(typeface1);
        button1.setTypeface(typeface1);

        if(!file.Remember_Me_Read(this).equals("")){
            Intent intent = new Intent(getApplicationContext(),Info_Activity.class);
            intent.putExtra("com.example.sudoajay.form.UserName2", file.Remember_Me_Read(this));
            startActivity(intent);
        }


    }
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            Finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    public void Finish(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
