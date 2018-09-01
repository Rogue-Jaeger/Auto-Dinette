package com.example.maverick.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dayofabsence extends AppCompatActivity {

    public Button singleday;
    public Button multipledays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayofabsence);

        singleday = (Button)findViewById(R.id.singleday);
        multipledays = (Button)findViewById(R.id.multipledays);

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
    }
}
