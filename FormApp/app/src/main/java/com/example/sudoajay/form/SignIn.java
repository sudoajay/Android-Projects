package com.example.sudoajay.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    private EditText userName,passWord;
    private ImageButton imageButton;
    private ReadFile readFile = new ReadFile();
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        userName = (EditText) findViewById(R.id.userNameEditText);
        passWord = (EditText) findViewById(R.id.passwordEditText);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (readFile.Check_For_UserName_And_Password(userName.getText().toString(), passWord.getText().toString()
                        , SignIn.this, userName, passWord)) {
                    readFile.Remember_Me_Write(SignIn.this, checkBox.isChecked(), userName, passWord);
                    Intent intent = new Intent(getApplicationContext(), Info_Activity.class);
                    intent.putExtra("com.example.sudoajay.form.userName1", userName.getText().toString());
                    startActivity(intent);


                }      }

        });
    }
}
