package com.example.maverick.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public EditText fillrollnumber;
    public EditText fillpassword;
    public Button loginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillrollnumber = (EditText)findViewById(R.id.fillrollnumber);
        fillpassword = (EditText)findViewById(R.id.fillpassword);
        loginbutton = (Button)findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate( fillrollnumber.getText().toString() , fillpassword.getText().toString() );
            }
        });
    }


    private void validate(String rollnumber, String password){
        String oops = "Wrong Credentials";
        String welcome = "Welcome! \n"+ rollnumber;

        if( ( rollnumber.equals("101503251") ) && ( password.equals("1") )){
            Intent go = new Intent(MainActivity.this , Hello.class);
            startActivity(go);
            Toast.makeText(getApplicationContext(), welcome , Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), oops , Toast.LENGTH_LONG).show();
        }
    }


}
