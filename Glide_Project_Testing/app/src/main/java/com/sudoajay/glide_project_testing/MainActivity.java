package com.sudoajay.glide_project_testing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<File> save_Data = new ArrayList<>();
    private ArrayList<String> get_Data = new ArrayList<>();
    private  final  int My_Permission_Request=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Storage_Permission_Granted();

        File dir = Environment.getExternalStorageDirectory();
        String path = dir.getAbsolutePath();

        Grab_All_File_Path(path+"/My Punjabi Songs/");

        for(File get:save_Data)
            get_Data.add(get.getAbsolutePath());

        ListView listView = findViewById(R.id.list_View);
        Array_List_View array_list_view = new Array_List_View(this , get_Data,save_Data);

        listView.setAdapter(array_list_view);
        Log.e("Exception " , listView.getCount()+"");

    }
    public void Grab_All_File_Path(String path){
            File file = new File(path);
            Log.e("OPath" , file.getAbsolutePath());
            Get_FIle_Recursive(file);

    }
    public void Get_FIle_Recursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
            Get_FIle_Recursive(child);
            save_Data.add(fileOrDirectory);
    }
    public  void Storage_Permission_Granted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, My_Permission_Request);
                } else {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, My_Permission_Request);
                }
            }
        }
    }
}
