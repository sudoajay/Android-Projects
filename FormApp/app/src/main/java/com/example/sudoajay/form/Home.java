package com.example.sudoajay.form;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sudoajay on 11/2/17.
 */

public class Home extends Fragment {
    private View view;
    private Write_Something write_something = new Write_Something();
    private Notes notes = new Notes();
    private TextView textView1, textView2,textView3 ;
    private Bundle bundle;
    private ReadFile readFile = new ReadFile();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        textView1 = (TextView) view.findViewById(R.id.textView9);
        textView2 = (TextView) view.findViewById(R.id.textView12);
        textView3 = (TextView) view.findViewById(R.id.textView15);
        bundle=getArguments();
        readFile.Get_The_FirstName(this,bundle.getString("com.example.sudoajay.form.Home.UserName"));
        textView1.append( " " + readFile.getSaveEverthing().get(0) );
        readFile.Read_The_Info_Notes(this,bundle.getString("com.example.sudoajay.form.Home.UserName"));
        if(readFile.getSaveTheUserName().isEmpty())textView2.setText("There is Nothing to Show");
        else{
            textView2.setText("");
            for(String data :readFile.getSaveTheUserName()){
                textView2.append(data);
            }
        }
        if(readFile.getSaveThePassword().isEmpty())textView3.setText("There is Nothing to Show");
        else{
            textView3.setText("");
            for(String data :readFile.getSaveThePassword()){
                textView3.append(data);
            }
        }








        return view;
    }
}
