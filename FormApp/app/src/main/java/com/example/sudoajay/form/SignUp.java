package com.example.sudoajay.form;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private ImageButton signUpImageButton;
    private EditText firstNameEditText,lastNameEditText,userNameEditText
            ,passwordEditText,confirmPasswordEditText;
    private CheckBox checkBox;
    private TextView signUpTextView;
    private ReadFile file = new ReadFile();
    private Typeface signUpTypeFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
        lastNameEditText = (EditText) findViewById(R.id.lastNameEditText);
        confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        checkBox = (CheckBox) findViewById(R.id.agreeCheckBox);
        signUpImageButton = (ImageButton) findViewById(R.id.signUpImageButton);
        signUpTextView = (TextView) findViewById(R.id.signUpText);
        signUpTypeFace = Typeface.createFromAsset(getAssets(),"Sansation.ttf");
        signUpTextView.setTypeface(signUpTypeFace);
        signUpImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                if(CheckForErrors() && file.checkOnRepeatUserName(SignUp.this, userNameEditText.getText().toString(),userNameEditText)) {
                    file.WriteOnUserName(SignUp.this,userNameEditText.getText().toString());
                    file.save_And_Write_Passwords(SignUp.this,passwordEditText.getText().toString());
                    file.Save_Info_Per_UserName(SignUp.this , firstNameEditText.getText().toString(),lastNameEditText.getText().toString()
                    ,userNameEditText.getText().toString(),passwordEditText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    public boolean CheckForErrors(){
        if(firstNameEditText.getText().toString().equals("")) {
            firstNameEditText.setError("Fill This  With your First Name");
            return false;
        }
        else {
            if (!Pattern.matches("\\w+",firstNameEditText.getText().toString())) {
                firstNameEditText.setError("Write Your First Name Correctly");
                firstNameEditText.setText("");
                return false;
            }
        }
        if(lastNameEditText.getText().toString().equals("")) {
            lastNameEditText.setError("Fill This With your Last Name");
            return false;
        }
        else {
            if(!Pattern.matches("\\w+",lastNameEditText.getText().toString()) ) {
                lastNameEditText.setError("Write Your Last Name Correctly");
                lastNameEditText.setText("");
                return false;
            }

        }
        if(userNameEditText.getText().toString().equals("")) {
            userNameEditText.setError("Fill This With your User Name");
            return false;
        }
        else {
            if(!Pattern.matches("\\S+",userNameEditText.getText().toString()) ) {
                userNameEditText.setError("Write Your User Name WithOut Space");
                userNameEditText.setText("");
                return false;
            }

        }
        if(passwordEditText.getText().toString().equals("")) {
            passwordEditText.setError("Fill This With your Password");
            return false;
        }
        else {
            if(!Pattern.matches("\\S{8,}+",passwordEditText.getText().toString()) ) {
                passwordEditText.setError("Password Should Be more The 8 Char");
                passwordEditText.setText("");
                return false;
            }

        }
        if(confirmPasswordEditText.getText().toString().equals("")) {
            confirmPasswordEditText.setError("Fill This With your Password");
            confirmPasswordEditText.setText("");
            return false;
        }
        else {
            if (!passwordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString())) {
                confirmPasswordEditText.setError("These passwords don't match. Try again?");
                confirmPasswordEditText.setText("");
                return false;
            }
        }
        if(!checkBox.isChecked()) {
            checkBox.setError("");
            return false;
        }

        return  true;
    }
}
