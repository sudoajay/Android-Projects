package com.example.sudoajay.filehandler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {
    private Button write_Button, read_Button;
    private EditText edit_Text;
    private File f;
    private BufferedWriter bw;
    private BufferedReader br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        write_Button = (Button) findViewById(R.id.write_Button);
        read_Button = (Button) findViewById(R.id.read_Button);
        edit_Text = (EditText) findViewById(R.id.edit_Text);

        write_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save_It(edit_Text.getText().toString());
            }
        });

        read_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Load_It();
            }
        });
    }
        public void Save_It(String get){
        try {
            FileOutputStream fos = openFileOutput("Ajay.txt", Context.MODE_PRIVATE);
            fos.write(get.getBytes());
            fos.close();
            Toast.makeText(this,"Changes Done " , Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(this,"Error While Write" , Toast.LENGTH_SHORT).show();
        }
    }
    public void Load_It(){
        String getname = "sad";
        try {
            FileInputStream fis = openFileInput("Ajay.txt");
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            getname = new String(buffer);
            Toast.makeText(this,getname , Toast.LENGTH_SHORT).show();
            fis.close();
        }catch(Exception e){
            Toast.makeText(this,"Error While Read" , Toast.LENGTH_SHORT).show();
        }
    }

}

