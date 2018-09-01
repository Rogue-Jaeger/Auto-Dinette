package com.example.maverick.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hello extends AppCompatActivity {

    public Button markabsencebutton;
    public Button messbillbutton;
    public Button messmenubutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        markabsencebutton = (Button)findViewById(R.id.markabsencebutton);
        messbillbutton = (Button)findViewById(R.id.messbillbutton);
        messmenubutton = (Button)findViewById(R.id.messmenubutton);


        markabsencebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Hello.this , dayofabsence.class);
                startActivity(go);
            }
        });

        messbillbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go1 = new Intent(Hello.this , viewmessbill.class);
                startActivity(go1);
            }
        });

        messmenubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go2 = new Intent(Hello.this , viewmessmenu.class);
                startActivity(go2);
            }
        });
    }
}
