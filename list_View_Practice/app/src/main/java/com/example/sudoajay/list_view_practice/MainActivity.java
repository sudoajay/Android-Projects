package com.example.sudoajay.list_view_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> array = new ArrayList<>();
        array.add("Ajay");
        array.add("Singh");

        ListView list_View = findViewById(R.id.list_View);

        
    }
}
