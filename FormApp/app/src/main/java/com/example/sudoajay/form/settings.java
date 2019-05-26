package com.example.sudoajay.form;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.regex.Pattern;

public class settings extends Fragment {
    private View view;
    private ReadFile readFile= new ReadFile();
    private EditText first_Name_Edit_Text,last_Name_Edit_Text,new_Password_Edit_Text,old_Password_Edit_Text,
            new_Confirm_Password_Edit_Text;
    private ImageButton checked_Image_Button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_settings, container, false);
        first_Name_Edit_Text = (EditText) view.findViewById(R.id.first_Name_Edit_Text);
        last_Name_Edit_Text = (EditText) view.findViewById(R.id.last_Name_Edit_Text);
        new_Password_Edit_Text = (EditText) view.findViewById(R.id.new_Password_Edit_Text);
        new_Confirm_Password_Edit_Text = (EditText) view.findViewById(R.id.new_Confirm_Password_Edit_Text);
        old_Password_Edit_Text = (EditText) view.findViewById(R.id.old_Password_Edit_Text);
        checked_Image_Button = (ImageButton) view.findViewById(R.id.checked_Image_Button);
        Bundle bundle = getArguments();
        if (bundle != null) {
            readFile.Read_While_Setting(this, bundle.getString("com.example.sudoajay.form.UserName"));
            first_Name_Edit_Text.setText(readFile.getSaveEverthing().get(0));
            last_Name_Edit_Text.setText(readFile.getSaveEverthing().get(1));
        }
        checked_Image_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckForErrors()){
                    if(!first_Name_Edit_Text.getText().toString().equals(""))
                        readFile.getSaveEverthing().set(0,first_Name_Edit_Text.getText().toString());
                    if(!last_Name_Edit_Text.getText().toString().equals(""))
                        readFile.getSaveEverthing().set(1,last_Name_Edit_Text.getText().toString());
                    if(!new_Password_Edit_Text.getText().toString().equals("")) {
                        readFile.Save_UserName_Password(settings.this);
                        readFile.Check_And_Save_Change(settings.this,new_Password_Edit_Text.getText().toString());
                        readFile.getSaveEverthing().set(3, new_Password_Edit_Text.getText().toString());
                    }
                        readFile.Write_The_Changes(settings.this);
                Snackbar.make(getView(),"Save Changes" , Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    public boolean CheckForErrors(){
        if(first_Name_Edit_Text.getText().toString().equals("")) {
            first_Name_Edit_Text.setError("Fill This  With your First Name");
            return false;
        }
        else {
            if (!Pattern.matches("\\w+",first_Name_Edit_Text.getText().toString())) {
                first_Name_Edit_Text.setError("Write Your First Name Correctly");
                first_Name_Edit_Text.setText("");
                return false;
            }
        }
        if(last_Name_Edit_Text.getText().toString().equals("")) {
            last_Name_Edit_Text.setError("Fill This With your Last Name");
            return false;
        }
        else {
            if (!Pattern.matches("\\w+", last_Name_Edit_Text.getText().toString())) {
                last_Name_Edit_Text.setError("Write Your Last Name Correctly");
                last_Name_Edit_Text.setText("");
                return false;
            }
        }
        if(!new_Password_Edit_Text.getText().toString().equals("")) {
            if (!Pattern.matches("\\S{8,}+", new_Password_Edit_Text.getText().toString())) {
                new_Password_Edit_Text.setError("Password Should Be more The 8 Char");
                new_Password_Edit_Text.setText("");
                return false;
            }
            if (!new_Password_Edit_Text.getText().toString().equals(new_Confirm_Password_Edit_Text.getText().toString())) {
                new_Confirm_Password_Edit_Text.setError("These passwords don't match. Try again?");
                new_Confirm_Password_Edit_Text.setText("");
                return false;
            }
        }

        if(!readFile.getSaveEverthing().get(3).equals(old_Password_Edit_Text.getText().toString())){
            if(old_Password_Edit_Text.getText().toString().equals("")){
                old_Password_Edit_Text.setError("Fill With Old Password");
            }else{
                old_Password_Edit_Text.setError("Password Is not Matching With Old Password");
            }
            return false;
        }
        return true;
        }
}
