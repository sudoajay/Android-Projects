package com.example.sudoajay.form;


import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Info_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String save_UserName, save_Info;
    private ReadFile readFile = new ReadFile();
    private TextView user_Info_Text_View;
    private Boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("com.example.sudoajay.form.UserName", save_UserName);
                settings fragobj = new settings();
                fragobj.setArguments(bundle);
                loadFragment(fragobj);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // coding

        if (getIntent().getExtras().getString("com.example.sudoajay.form.userName1") != null) {

            save_UserName = getIntent().getExtras().getString("com.example.sudoajay.form.userName1");
        } else {

            save_UserName = getIntent().getExtras().getString("com.example.sudoajay.form.UserName2");
        }
        save_Info = readFile.Get_The_FirstName_LastName(this, save_UserName);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        user_Info_Text_View = hView.findViewById(R.id.user_Info);
        user_Info_Text_View.setText(save_Info);


        setTitle("Home");
        Bundle bundles = new Bundle();
        bundles.putString("com.example.sudoajay.form.Home.UserName", save_UserName);
        Home homes = new Home();
        homes.setArguments(bundles);
        loadFragment(homes);
    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            Finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.info_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            setTitle("Home");
            Bundle bundle = new Bundle();
            bundle.putString("com.example.sudoajay.form.Home.UserName", save_UserName);
            Home home = new Home();
            home.setArguments(bundle);
            loadFragment(home);
        } else if (id == R.id.nav_Write_Something) {
            setTitle("Write Something");
            Bundle bundle = new Bundle();
            bundle.putString("com.example.sudoajay.form.Write_Something.UserName", save_UserName);
            Write_Something write_something = new Write_Something();
            write_something.setArguments(bundle);
            loadFragment(write_something);
        } else if (id == R.id.nav_notes) {
            setTitle("Notes");
            Bundle bundle = new Bundle();
            bundle.putString("com.example.sudoajay.form.Notes.UserName", save_UserName);
            Notes notes = new Notes();
            notes.setArguments(bundle);
            loadFragment(notes);
        } else if (id == R.id.nav_About_Maker) {
            setTitle("About Maker");
            About_Maker about_maker = new About_Maker();
            loadFragment(about_maker);
        } else if (id == R.id.nav_Log_Out) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("   Log Out ! ");
            alert.setMessage("Are You Sure To Log Out ?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(getApplicationContext(), MainClass.class);
                   readFile.Delete_Remember(Info_Activity.this);
                    startActivity(intent);
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

    public void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        android.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
    public void Finish(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }

}
