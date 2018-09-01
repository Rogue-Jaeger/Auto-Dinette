package com.example.maverick.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class viewmessbill extends AppCompatActivity {

    public Button submitbutton;
    public Button selectmonthbutton;
    public DatePickerDialog.OnDateSetListener monthlistener;
    int month,day,year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmessbill);

        submitbutton = (Button)findViewById(R.id.submitbutton);
        selectmonthbutton = (Button)findViewById(R.id.selectmonthbutton);

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




    }
}
