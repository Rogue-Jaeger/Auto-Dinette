package com.example.maverick.myapplication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class viewmessmenu extends AppCompatActivity {

    TextView tv , btv;
    EditText Fillmeal , Fillday;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmessmenu);

        tv = (TextView)findViewById(R.id.viewmessmenutoolbartext);
        btv = findViewById(R.id.viewmessmenutext);
        Fillday = findViewById(R.id.fillday);
        Fillmeal = findViewById(R.id.fillmeal);
        Submit = findViewById(R.id.viewmessmenusubmitButton);

        Typeface tf = Typeface.createFromAsset(getAssets() , "fonts/freight-sans.ttf");
        tv.setTypeface(tf);
        btv.setTypeface(tf);
        Fillmeal.setTypeface(tf);
        Fillday.setTypeface(tf);
        Submit.setTypeface(tf);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("chala");
                String str = validate(Fillday.getText().toString() , Fillmeal.getText().toString());
                //Toast.makeText(getApplicationContext() , str , Toast.LENGTH_SHORT).show();
                btv.setText(str);
            }
        });

    }


    String validate(String fillday , String fillmeal){
        if(fillday.toLowerCase().equals("monday") && fillmeal.toLowerCase().equals("breakfast")) return "Onion parantha, curd, milk";
        else if(fillday.toLowerCase().equals("monday") && fillmeal.toLowerCase().equals("lunch")) return "Moong Daal, Chapati, Raita, Salad";
        else if(fillday.toLowerCase().equals("monday") && fillmeal.toLowerCase().equals("dinner")) return "Palak Paneer, roti, Gulab jamun";
        else if(fillday.toLowerCase().equals("tuesday") && fillmeal.toLowerCase().equals("breakfast")) return "Aloo parantha, curd, milk";
        else if(fillday.toLowerCase().equals("tuesday") && fillmeal.toLowerCase().equals("lunch")) return "Moongi daal, roti, Rooh afza";
        else if(fillday.toLowerCase().equals("tuesday") && fillmeal.toLowerCase().equals("dinner")) return "Mah ki daal + Rajma, Roti, chawal";
        else if(fillday.toLowerCase().equals("wednesday") && fillmeal.toLowerCase().equals("breakfast")) return "Methi prantha , curd , milk";
        else if(fillday.toLowerCase().equals("wednesday") && fillmeal.toLowerCase().equals("lunch")) return "Kadhai Paneer, Lassi, roti";
        else if(fillday.toLowerCase().equals("wednesday") && fillmeal.toLowerCase().equals("dinner")) return "Moong Daal , chapati";
        else if(fillday.toLowerCase().equals("thursday") && fillmeal.toLowerCase().equals("breakfast")) return "Simple parantha, Aloo Sabzi, curd, milk";
        else if(fillday.toLowerCase().equals("thursday") && fillmeal.toLowerCase().equals("lunch")) return "Rajma, chawal";
        else if(fillday.toLowerCase().equals("thursday") && fillmeal.toLowerCase().equals("dinner")) return "Dal Makni, Raita, Roti, Salad";
        else if(fillday.toLowerCase().equals("friday") && fillmeal.toLowerCase().equals("breakfast")) return "Onion parantha, curd, milk";
        else if(fillday.toLowerCase().equals("friday") && fillmeal.toLowerCase().equals("lunch")) return "Moongi daal, roti, Rooh afza";
        else if(fillday.toLowerCase().equals("friday") && fillmeal.toLowerCase().equals("dinner")) return "Mah ki daal + Rajma, Roti, chawal";
        else if(fillday.toLowerCase().equals("saturday") && fillmeal.toLowerCase().equals("breakfast")) return "Paneer parantha, curd, milk";
        else if(fillday.toLowerCase().equals("saturday") && fillmeal.toLowerCase().equals("lunch")) return "Bhindi, Arhar Daal, Kheer, Roti";
        else if(fillday.toLowerCase().equals("saturday") && fillmeal.toLowerCase().equals("dinner")) return "Moong Daal , chapati";
        else if(fillday.toLowerCase().equals("sunday") && fillmeal.toLowerCase().equals("breakfast")) return "Aloo parantha, Corn Flakes, curd, milk";
        else if(fillday.toLowerCase().equals("sunday") && fillmeal.toLowerCase().equals("lunch")) return "Moongi daal, roti, Rooh afza";
        else return "Moongi daal, roti, Rooh afza";

    }




}
