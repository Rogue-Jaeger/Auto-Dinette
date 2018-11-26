package com.example.maverick.myapplication;


import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class view_monthly_mess_bill_fragment extends Fragment implements View.OnClickListener{

    int day,month,year,currentyear,currentmonth,currentday;
    public DatePickerDialog.OnDateSetListener onDateSetListener;
    public Button selectmonthbutton;
    public Button submitbutton;
    public View v;


    public view_monthly_mess_bill_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_view_monthly_mess_bill_fragment, container, false);
        selectmonthbutton = (Button)v.findViewById(R.id.viewmonthlymessbillfragmentmessbillbutton);
        submitbutton = (Button)v.findViewById(R.id.viewmonthlymessbillfragmentsubmitbutton);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets() , "fonts/freight-sans.ttf");
        selectmonthbutton.setTypeface(tf);
        submitbutton.setTypeface(tf);

        selectmonthbutton.setOnClickListener(this);
        submitbutton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {

        if(v == selectmonthbutton){
                Calendar cal = Calendar.getInstance();
                day = cal.get(Calendar.DAY_OF_MONTH);
                month = cal.get(Calendar.MONTH);
                year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme_DeviceDefault_Dialog_NoActionBar,
                        onDateSetListener,
                        year,
                        month,
                        day);

                dialog.show();

                onDateSetListener = new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int inputyear, int inputmonth , int inputday){
                        inputmonth++;
                        day = inputday;
                        month = inputmonth;
                        year = inputyear;
                        String date = inputday + " / " + inputmonth + " / " + inputyear;
                        selectmonthbutton.setText(date);
                    }
                };
        }

    }
}
