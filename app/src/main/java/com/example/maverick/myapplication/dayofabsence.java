package com.example.maverick.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dayofabsence extends AppCompatActivity {

    public Button singleday;
    public Button multipledays;
    public TextView tv;
    public BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayofabsence);

        singleday = (Button)findViewById(R.id.singleday);
        multipledays = (Button)findViewById(R.id.multipledays);
        tv = (TextView)findViewById(R.id.dayofabesncetoolbartext);


        Typeface tf = Typeface.createFromAsset(getAssets() , "fonts/freight-sans.ttf");
        singleday.setTypeface(tf);
        multipledays.setTypeface(tf);
        tv.setTypeface(tf);

        bnv = (BottomNavigationView)findViewById(R.id.dayofabsence_bottom_nav_bar);


        singleday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(dayofabsence.this , singlemarkabsence.class );
                startActivity(go);
            }
        });

        multipledays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go1 = new Intent( dayofabsence.this , multiplemarkabsence.class );
                startActivity(go1);
            }
        });

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(dayofabsence.this , Hello.class) );
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
}
