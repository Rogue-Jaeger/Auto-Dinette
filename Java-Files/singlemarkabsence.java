package com.example.maverick.myapplication;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class singlemarkabsence extends AppCompatActivity {

    int day,month,year,currentyear,currentmonth,currentday;

    public Button submitbutton;
    public Button pickadatebutton;
    public TextView ondisplaydate;
    public DatePickerDialog.OnDateSetListener onDateSetListener;
    String submitted = "Your response has been submitted!";
    String notsubmitted = "Enter a valid date!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlemarkabsence);

        submitbutton = (Button)findViewById(R.id.submitbutton);
        pickadatebutton = (Button)findViewById(R.id.pickadatebutton);
        //ondisplaydate = (TextView)findViewById(R.id.displaydate);


        pickadatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                day = cal.get(Calendar.DAY_OF_MONTH);
                month = cal.get(Calendar.MONTH);
                year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(
                        singlemarkabsence.this,
                        android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,
                        onDateSetListener,
                        year,
                        month,
                        day);

                dialog.show();
            }
        });


        onDateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int inputyear, int inputmonth , int inputday){
                inputmonth++;
                day = inputday;
                month = inputmonth;
                year = inputyear;
                String date = inputday + " / " + inputmonth + " / " + inputyear;
                pickadatebutton.setText(date);
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

                String oops = day + " / " + month + " / " + year + " * " + currentday + " / " + currentmonth + " / " + currentyear;

                //ondisplaydate.setText( oops ) ;


                if( year - currentyear < 0 ){
                    Toast.makeText(getApplicationContext() ,  notsubmitted  , Toast.LENGTH_LONG).show();
                }
                else if( year - currentyear == 0 && month - currentmonth < 0 ){
                    Toast.makeText(getApplicationContext() ,  notsubmitted  , Toast.LENGTH_LONG).show();
                }
                else if( day - currentday < 0 && month - currentmonth == 0 ){
                    Toast.makeText(getApplicationContext() ,  notsubmitted  , Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), submitted, Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
