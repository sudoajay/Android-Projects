package com.example.sudoajay.themes_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button, button1;
    private Theme theme =new Theme();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(darkTheme ? R.style.AppThemeDark : R.style.AppThemeLight);

        theme.onActivityCreateSetTheme(this);

        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button2);

    }
        public void Onclick(View v){
        switch(v.getId()){
            case R.id.button:
                theme.changeToTheme(this,Theme.BLACK);
                break;
            case R.id.button2:
                theme.changeToTheme(this,Theme.BLUE);
                break;
        }

    }


}
