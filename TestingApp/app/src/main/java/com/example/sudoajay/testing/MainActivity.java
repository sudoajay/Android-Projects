package com.example.sudoajay.testing;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Button(View view){
        int getid =view.getId();
        Snackbar.make(view , view.getResources().getResourceEntryName(getid)+"",Snackbar.LENGTH_SHORT).show();
    }
}
