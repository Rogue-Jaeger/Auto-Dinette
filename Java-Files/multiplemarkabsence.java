package com.example.maverick.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class multiplemarkabsence extends AppCompatActivity {

    int startingday,startingmonth,startingyear,endingyear,endingday,endingmonth,currentyear,currentmonth,currentday;

    public Button startingdatebutton;
    public Button endingdatebutton;
    public Button submitbutton;
    public TextView oopsy;
    public DatePickerDialog.OnDateSetListener onstartingDateSetListener;
    public DatePickerDialog.OnDateSetListener onendingDateSetListener;
    String submitted = "Your response has been submitted!";
    String notsubmittedday = "Enter a valid day!";
    String notsubmittedmonth = "Enter a valid month!";
    String notsubmittedyear = "Enter a valid year!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplemarkabsence);



        startingdatebutton = (Button)findViewById(R.id.startingdatebutton);
        endingdatebutton = (Button)findViewById(R.id.endingdatebutton);
        submitbutton = (Button)findViewById(R.id.submitbutton);
        //oopsy = (TextView)findViewById(R.id.oopsy);


        startingdatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar startdate = Calendar.getInstance();
                startingday = startdate.get(Calendar.DAY_OF_MONTH);
                startingmonth = startdate.get(Calendar.MONTH);
                startingyear = startdate.get(Calendar.YEAR);

                DatePickerDialog dialog1 = new DatePickerDialog(multiplemarkabsence.this,
                        android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,
                        onstartingDateSetListener,
                        startingyear,
                        startingmonth,
                        startingday);

                dialog1.show();
            }
        });

        onstartingDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int startyear, int startmonth, int startday) {

                startmonth++;
                startingday = startday;
                startingmonth = startmonth;
                startingyear = startyear;
                String oops = startday + " / " + startmonth + " / " + startyear;
                startingdatebutton.setText(oops);


            }
        };



        endingdatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar enddate = Calendar.getInstance();
                endingday = enddate.get(Calendar.DAY_OF_MONTH);
                endingmonth = enddate.get(Calendar.MONTH);
                endingyear = enddate.get(Calendar.YEAR);

                DatePickerDialog dialog2 = new DatePickerDialog(multiplemarkabsence.this,
                        android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,
                        onendingDateSetListener,
                        endingyear,
                        endingmonth,
                        endingday);

                dialog2.show();
            }
        });

        onendingDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int endyear, int endmonth, int endday) {

                endmonth++;
                endingmonth = endmonth;
                endingyear = endyear;
                endingday = endday;
                String oops = endday + " / " + endmonth + " / " + endyear;

                endingdatebutton.setText(oops);

            }
        };




        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar today = Calendar.getInstance();
                currentyear = today.get(Calendar.YEAR);
                currentmonth = today.get(Calendar.MONTH);
                currentday = today.get(Calendar.DAY_OF_MONTH);
                currentmonth++;

                String garbage = currentmonth + " " + currentyear + " " + startingmonth + " " + startingyear + " " + endingmonth + " " + endingyear;
                //oopsy.setText(garbage);

                if( ( startingyear - currentyear < 0 )  ||  ( endingyear - startingyear < 0) ){
                    Toast.makeText(getApplicationContext() ,  notsubmittedyear  , Toast.LENGTH_LONG).show();
                }
                else if((((startingyear - currentyear) == 0) && ((startingmonth - currentmonth) < 0)) ||
                        (((endingyear - startingyear) == 0) && ((endingmonth - startingmonth) < 0))){
                    Toast.makeText(getApplicationContext() ,  notsubmittedmonth  , Toast.LENGTH_LONG).show();
                }
                else if((((startingday - currentday) < 0) && ((startingmonth - currentmonth) == 0)) ||
                        (((endingday - startingday) < 0) && ((endingmonth - startingmonth) == 0))){
                    Toast.makeText(getApplicationContext() ,  notsubmittedday  , Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), submitted, Toast.LENGTH_LONG).show();
                }
            }
        });












    }


}
