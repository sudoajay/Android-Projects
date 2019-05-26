package com.example.sudoajay.form;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by sudoajay on 11/2/17.
 */

public class Write_Something extends Fragment {
    private View view;
    private EditText text;
    private ImageButton imageButton;
    private Bundle bundle;
    private ReadFile readFile = new ReadFile();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_write_something, container, false);
        text = (EditText) view.findViewById(R.id.editText);

        imageButton = (ImageButton) view.findViewById(R.id.imageButton2);
        bundle = getArguments();
        readFile.Read_The_Info(this,bundle.getString("com.example.sudoajay.form.Write_Something.UserName"),"_write_something");
       text.setText("");
        for (String  data : readFile.getSaveEverthing()){
           text.append(data);
       }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bundle != null){
                    readFile.Write_The_Info(Write_Something.this,bundle.getString("com.example.sudoajay.form.Write_Something.UserName"),"_write_something",
                           text.getText().toString() );
                    Snackbar.make(view , "Save Changes "  ,Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }

    public EditText getText() {
        return text;
    }

    public void setText(EditText text) {
        this.text = text;
    }
}
