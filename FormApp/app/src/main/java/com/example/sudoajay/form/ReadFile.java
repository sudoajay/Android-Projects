package com.example.sudoajay.form;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by sudoajay on 10/17/17.
 */

public class ReadFile {
    private BufferedReader br;
    private BufferedWriter bw;
    private File file_Password,file_Username,file_Remember,file_Create_Per_UserName,file_open_Username;
    private  String getUserName ;
    private ArrayList<String> saveTheUserName =  new ArrayList<>(),saveThePassword = new ArrayList<>();
    private ArrayList<String> saveEverthing= new ArrayList<>();
    public boolean checkOnRepeatUserName(SignUp up, String getName, EditText user_Edit_Text){
       saveTheUserName.clear();
        try {
            file_Username =new File(up.getFilesDir(),"UserName.txt");
            if(!file_Username.exists())file_Username.createNewFile();
            br = new BufferedReader(new FileReader(file_Username));
            String name;
            while ((name = br.readLine()) != null) {
                if (name.equals(getName)) {
                    saveTheUserName.clear();
                    user_Edit_Text.setText("");
                    user_Edit_Text.setError("Sorry Try Unique UserName ");
                    return false;
                }
                saveTheUserName.add(name);
            }
            br.close();
        }
         catch (Exception e) {
             Toast.makeText(up,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        return  true;
    }
    public void WriteOnUserName(SignUp up, String getName){
        saveTheUserName.add(getName);
        try {
            file_Username = new File( up.getFilesDir(),"UserName.txt");
            if(!file_Username.exists())file_Username.createNewFile();
            bw = new BufferedWriter(new FileWriter(file_Username));
            for (String save : saveTheUserName) {
                bw.write(save);
                bw.newLine();
            }
            bw.close();
            } catch (Exception e) {
            Toast.makeText(up,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        public void save_And_Write_Passwords(SignUp up , String getPassword ){
            saveThePassword.clear();
            try{
                file_Password= new File(up.getFilesDir(),"Passwords.txt");
                if(!file_Password.exists())file_Password.createNewFile();
                br = new BufferedReader(new FileReader(file_Password));
                String get ;
                while((get = br.readLine()) != null){
                    saveThePassword.add(get);
                }
                br.close();
                bw = new BufferedWriter(new FileWriter(file_Password));
                saveThePassword.add(getPassword);
                for (String write:saveThePassword) {
                    bw.write(write);
                    bw.newLine();
                }
                bw.close();
            }catch(Exception e){
                Toast.makeText(up,e.getMessage(),Toast.LENGTH_LONG).show();
            }
            
        }
        public boolean Check_For_UserName_And_Password(String getUserName , String getPassword , SignIn in
        , EditText userName ,EditText password) {
            saveTheUserName.clear();
            saveThePassword.clear();
            try {
                file_Username = new File(in.getFilesDir(), "UserName.txt");
                if (!file_Username.exists()) file_Username.createNewFile();
                br = new BufferedReader(new FileReader(file_Username));
                String name;
                while ((name = br.readLine()) != null) {
                    saveTheUserName.add(name);
                }
                saveTheUserName.add("ajay");
                br.close();
                file_Password= new File(in.getFilesDir(),"Passwords.txt");
                if(!file_Password.exists())file_Password.createNewFile();
                br = new BufferedReader(new FileReader(file_Password));
                String get ;
                while((get = br.readLine()) != null){
                    saveThePassword.add(get);
                }
                br.close();

                for (int i = 0 ; i<saveTheUserName.size()-1;i++){
                    if(getUserName.equals(saveTheUserName.get(i))){
                        if(getPassword.equals(saveThePassword.get(i))){
                            return true;
                        }else {
                            password.setText("");
                            password.setError("PassWord is Not Matching");
                            Toast.makeText(in,"Error While password not match" , Toast.LENGTH_LONG).show();
                            return false;
                        }
                    }
                }
                userName.setText("");
                userName.setError("Invalid Login !");
                password.setText("");
                Toast.makeText(in,"Error While Invalid Login " , Toast.LENGTH_LONG).show();

            }
            catch (Exception e){
                Toast.makeText(in,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    public void Remember_Me_Write(SignIn in,boolean getCheck,EditText userName , EditText password){
        try{
        file_Remember = new File(in.getFilesDir(),"Remember.txt");
            if(!file_Remember.exists()) file_Remember.createNewFile();
            bw =new BufferedWriter(new FileWriter(file_Remember));
            if(getCheck){
               bw.write(userName.getText().toString());
            }
            else {
                bw.write("");
            }
            bw.close();
        }catch (Exception e){
            Toast.makeText(in,e.getMessage() ,Toast.LENGTH_SHORT).show();
        }

    }
    public String Remember_Me_Read(MainClass mainClass){
        try{
            file_Remember = new File(mainClass.getFilesDir() ,"Remember.txt");
            if(!file_Remember.exists()) file_Remember.createNewFile();
            br = new BufferedReader(new FileReader(file_Remember));
            getUserName = br.readLine();
            if(getUserName == null )return "";
            br.close();
        }catch (Exception e){
            Toast.makeText(mainClass , e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return getUserName;
    }
    public void Save_Info_Per_UserName(SignUp up ,String firstName , String lastName , String userName,
                                       String password ){
        try{
            file_Create_Per_UserName = new File(up.getFilesDir(),userName+".txt");
            if(!file_Create_Per_UserName.exists())file_Create_Per_UserName.createNewFile();
            bw = new BufferedWriter(new FileWriter(file_Create_Per_UserName));
            bw.write(Text_First_Capital(firstName));
            bw.newLine();
            bw.write(Text_First_Capital(lastName));
            bw.newLine();
            bw.write(userName);
            bw.newLine();
            bw.write(password);
            bw.newLine();
            bw.close();
        }catch(Exception e){
            Toast.makeText(up ,e.getMessage() , Toast.LENGTH_SHORT).show();
        }
    }
    public String Get_The_FirstName_LastName( Info_Activity info , String get_File_Name) {
        String firstName = "ajay", lastName = "";
        try {
            file_Create_Per_UserName = new File(info.getFilesDir(), get_File_Name + ".txt");
            if (!file_Create_Per_UserName.exists()) file_Create_Per_UserName.createNewFile();
            br = new BufferedReader(new FileReader(file_Create_Per_UserName));
            firstName = br.readLine();
            lastName = br.readLine();
            br.close();
        } catch (Exception e) {
            Toast.makeText(info, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return firstName + " " + lastName;

    }
    public String Text_First_Capital(String text){
        String save = "";
        for(int i = 0 ; i<= text.length()-1;i++) {
            save += Character.toLowerCase(text.charAt(i))+"";
        }
         return (Character.toUpperCase(text.charAt(0) )+ save.substring(1));

    }
    public void Read_While_Setting(settings settings, String file_Username){
        try{
            file_open_Username = new File(settings.getActivity().getFilesDir(),file_Username+".txt");
            br = new BufferedReader(new FileReader(file_open_Username));
            String  get = "";
            while((get = br.readLine()) != null){
                saveEverthing.add(get);
            }
            br.close();
        }catch(Exception e){
           Toast.makeText(settings.getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<String> getSaveEverthing() {
        return saveEverthing;
    }

    public void setSaveEverthing(ArrayList<String> saveEverthing) {
        this.saveEverthing = saveEverthing;
    }
    public void Write_The_Changes(settings settings) {
        try {
            file_open_Username = new File(settings.getActivity().getFilesDir(), getSaveEverthing().get(2) + ".txt");
            bw = new BufferedWriter(new FileWriter(file_open_Username));
            for (String data : saveEverthing) {
                bw.write(data);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            Snackbar.make(settings.getView(), e.getMessage(), Snackbar.LENGTH_SHORT).show();
        }
    }
        public void Save_UserName_Password(settings settings){
            try{
                saveTheUserName.clear();
                saveThePassword.clear();
                file_Username = new File(settings.getActivity().getFilesDir(),"UserName.txt");
                br = new BufferedReader(new FileReader(file_Username));
                String get="";
                while((get =br.readLine()) !=null){

                    saveTheUserName.add(get);
                }
                br.close();
                file_Password =new File(settings.getActivity().getFilesDir(),"Passwords.txt");
                br =new BufferedReader(new FileReader(file_Password));
                while((get =br.readLine()) !=null){
                    saveThePassword.add(get);

                }
                br.close();
            }catch (Exception e){
                Snackbar.make(settings.getView() , e.getMessage(),Snackbar.LENGTH_SHORT).show();
            }
    }
    public void Check_And_Save_Change(settings settings ,String new_Password ){
        try{
            for(int i = 0;i<saveTheUserName.size();i++){
                if(saveTheUserName.get(i).equals(saveEverthing.get(2))){
                    saveThePassword.set(i,new_Password);

                }
            }
            file_Username = new File(settings.getActivity().getFilesDir(),"UserName.txt");
            bw = new BufferedWriter(new FileWriter(file_Username));
            for (String data: saveTheUserName){
                bw.write(data);
                bw.newLine();
            }
            bw.close();
            file_Password =new File(settings.getActivity().getFilesDir(),"Passwords.txt");
            bw = new BufferedWriter(new FileWriter(file_Password));
            for (String data: saveThePassword){
                bw.write(data);
                bw.newLine();
            }
            bw.close();
        }catch (Exception e){
            Snackbar.make(settings.getView(),e.getMessage(),Snackbar.LENGTH_SHORT).show();
        }
    }
    public void Read_The_Info(Write_Something write_something, String username , String type){
        try{
            saveEverthing.clear();
            file_Create_Per_UserName = new File(write_something.getActivity().getFilesDir(),username+type+".txt");
            if(!file_Create_Per_UserName.exists())file_Create_Per_UserName.createNewFile();
            br =new BufferedReader(new FileReader(file_Create_Per_UserName));
            String get="";
            while((get = br.readLine()) != null){
                saveEverthing.add(get);
            }
            br.close();
        }catch (Exception e){
            Snackbar.make(write_something.getView(),e.getMessage(),Snackbar.LENGTH_SHORT).show();
        }

    }
    public void Write_The_Info(Write_Something write_something,String username , String type,String info){
        try{
            file_Create_Per_UserName = new File(write_something.getActivity().getFilesDir(),username+type+".txt");
            if(!file_Create_Per_UserName.exists())file_Create_Per_UserName.createNewFile();
            bw = new BufferedWriter(new FileWriter(file_Create_Per_UserName));
            bw.write(info);
            bw.close();
        }catch (Exception e){
            Snackbar.make(write_something.getView(),e.getMessage(),Snackbar.LENGTH_SHORT).show();
        }
    }
    public void Read_The_Notes(Notes write_something, String username , String type){
        try{
            file_Create_Per_UserName = new File(write_something.getActivity().getFilesDir(),username+type+".txt");
            if(!file_Create_Per_UserName.exists())file_Create_Per_UserName.createNewFile();
            br =new BufferedReader(new FileReader(file_Create_Per_UserName));
            String get="";
            while((get = br.readLine()) != null){
                saveEverthing.add(get);
            }
            br.close();
        }catch (Exception e){
            Snackbar.make(write_something.getView(),e.getMessage(),Snackbar.LENGTH_SHORT).show();
        }

    }
    public void Write_The_Notes(Notes write_something,String username , String type,String info){
        try{
            saveEverthing.clear();
            file_Create_Per_UserName = new File(write_something.getActivity().getFilesDir(),username+type+".txt");
            if(!file_Create_Per_UserName.exists())file_Create_Per_UserName.createNewFile();
            bw = new BufferedWriter(new FileWriter(file_Create_Per_UserName));
            bw.write(info);
            bw.close();
        }catch (Exception e){
            Snackbar.make(write_something.getView(),e.getMessage(),Snackbar.LENGTH_SHORT).show();
        }
    }
    public void Get_The_FirstName(Home home,String userName){
        saveEverthing.clear();
        try{
            file_Username = new File(home.getActivity().getFilesDir(),userName+".txt");
            if(!file_Username.exists())file_Username.createNewFile();
            br = new BufferedReader(new FileReader(file_Username));
            String get = "";
            while((get = br.readLine()) != null){
                saveEverthing.add(get);
            }
            br.close();
        }catch(Exception e){
            Snackbar.make(home.getView(),e.getMessage() , Snackbar.LENGTH_SHORT).show();
        }

    }
    public void Read_The_Info_Notes(Home home, String username){
        try{
            saveTheUserName.clear();
            saveThePassword.clear();
            file_Username = new File(home.getActivity().getFilesDir(),username+"_write_something.txt");
            if(!file_Username.exists())file_Username.createNewFile();
            br= new BufferedReader(new FileReader(file_Username));
            String get = "";
            while((get = br.readLine()) !=null){
                saveTheUserName.add(get);
            }
            br.close();

            file_Username = new File(home.getActivity().getFilesDir(),username+"_notes.txt");
            if(!file_Username.exists())file_Username.createNewFile();
            br= new BufferedReader(new FileReader(file_Username));
            String gets = "";
            while((gets = br.readLine()) !=null){
                saveThePassword.add(gets);
            }
            br.close();
        }catch (Exception e){
            Toast.makeText(home.getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }

    public ArrayList<String> getSaveTheUserName() {
        return saveTheUserName;
    }

    public void setSaveTheUserName(ArrayList<String> saveTheUserName) {
        this.saveTheUserName = saveTheUserName;
    }

    public ArrayList<String> getSaveThePassword() {
        return saveThePassword;
    }

    public void setSaveThePassword(ArrayList<String> saveThePassword) {
        this.saveThePassword = saveThePassword;
    }
    public void Delete_Remember(Info_Activity info_activity){
        try{
            file_open_Username = new File(info_activity.getFilesDir(),"Remember.txt");
            file_open_Username.delete();
        }catch(Exception e){
            Toast.makeText(info_activity, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
