package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.security.DigestOutputStream;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
   DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        //open drawer
        openDrawer(drawerLayout);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        // open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer
        closeDrawer(drawerLayout);
        setContentView(R.layout.activity_main);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activity
        recreate();
    }
    public void ClickDashboard(View view){
        //Redirect activity to Dashboard
        redirectActivity(this,Dashboard.class);
    }
    public void ClickAboutUs(View view){
        //Redirect activity to about us
        redirectActivity(this,AboutUs.class);
    }

    public void ClickLogout(View view){
        //close app
        Logout(this);

    }

    public static void Logout(final Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        // Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to?");
        //Positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Finish
                activity.finishAffinity();
                //Exist app
                System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Dismiss
                dialogInterface.dismiss();
            }
        });
        //Show dialog
        builder.show();

    }



    public static void redirectActivity(Activity activity,Class aclass){
        //Initialize intent
        Intent intent = new Intent(activity, aclass);
        //set falg
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }



    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}