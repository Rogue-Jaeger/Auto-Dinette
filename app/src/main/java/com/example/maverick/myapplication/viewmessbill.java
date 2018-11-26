package com.example.maverick.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class viewmessbill extends AppCompatActivity {

    public Button submitbutton;
    public Button selectmonthbutton;
    public DatePickerDialog.OnDateSetListener monthlistener;
    public TextView SelectMonthButton;
    int month,day,year;
    public BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmessbill);

        bnv = (BottomNavigationView)findViewById(R.id.viewmessbill_bottom_nav_bar);
        submitbutton = (Button)findViewById(R.id.viewmessbillsubmitbutton);
        selectmonthbutton = (Button)findViewById(R.id.viewmessbillselectmonthbutton);
        SelectMonthButton = (TextView) findViewById(R.id.selectmonthbutton);

        Typeface tf = Typeface.createFromAsset(getAssets() , "fonts/freight-sans.ttf");
        submitbutton.setTypeface(tf);
        selectmonthbutton.setTypeface(tf);
        SelectMonthButton.setTypeface(tf);

        selectmonthbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                month = cal.get(Calendar.MONTH);

                DatePickerDialog dialog = new DatePickerDialog(viewmessbill.this,
                        android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,
                        monthlistener,
                        year,
                        month,
                        day
                );

                dialog.show();
            }

        });


        monthlistener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int startyear, int startmonth, int startday) {

                startmonth++;
                day = startday;
                month = startmonth;
                year = startyear;
                String oops = startday + " / " + startmonth + " / " + startyear;

            }
        };


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(viewmessbill.this , monthlymessbill.class);
                startActivity(go);
            }
        });


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        startActivity(new Intent(viewmessbill.this , Hello.class) );
                        return true;

                    default:
                        return false;
                }
            }
        });




    }
}
