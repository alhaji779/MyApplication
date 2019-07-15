package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button about;
    Button btn_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about =(Button) findViewById(R.id.btn_about);
        btn_profile = (Button) findViewById(R.id.btn_profile);


       about.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this, webView.class);
               i.putExtra(webView.WEBSITE_ADDRESS, "https://www.google.com");
               startActivity(i);
           }
       });

       //andela.com/alc
       btn_profile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, profile.class);
               startActivity(intent);
           }
       });
    }
}
