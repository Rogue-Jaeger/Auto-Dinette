package com.example.maverick.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maverick.myapplication.Internet.Login;
import com.example.maverick.myapplication.Internet.User;
import com.example.maverick.myapplication.Internet.UserClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    public EditText fillrollnumber;
    public EditText fillpassword;
    public Button loginbutton;

    TextView text , bottomtext;


    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://18.218.227.179:8000/api/request/").addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();

    UserClient userClient = retrofit.create(UserClient.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillrollnumber = (EditText)findViewById(R.id.fillrollnumber);
        fillpassword = (EditText)findViewById(R.id.fillpassword);
        loginbutton = (Button)findViewById(R.id.loginbutton);
        text = (TextView)findViewById(R.id.mainactivitytoolbartext);
        bottomtext = (TextView)findViewById(R.id.mainactivitytext);

        Typeface tf = Typeface.createFromAsset(getAssets() , "fonts/freight-sans.ttf");
        text.setTypeface(tf);
        fillpassword.setTypeface(tf);
        fillrollnumber.setTypeface(tf);
        loginbutton.setTypeface(tf);
        bottomtext.setTypeface(tf);


        new Retrieve().execute();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate( fillrollnumber.getText().toString() , fillpassword.getText().toString() );
            }
        });
    }


    public void validate(String username, String password){
        Login login = new Login(password , username);
        Call<User> call= userClient.login(login);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Welcome!" , Toast.LENGTH_LONG).show();
                    Intent go = new Intent(MainActivity.this , Hello.class);
                    startActivity(go);
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong Credentials!" , Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Internet Error!" , Toast.LENGTH_LONG).show();

            }
        });

        /*if( ( rollnumber.equals("101503251") ) && ( password.equals("1") )){
            Intent go = new Intent(MainActivity.this , Hello.class);
            startActivity(go);
            Toast.makeText(getApplicationContext(), welcome , Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), oops , Toast.LENGTH_LONG).show();
        }

        String s  = "opsops";
        Log.d(s , "sjls");*/

    }







   public class Retrieve extends AsyncTask<Void , Void , Void>{

       @Override
       protected Void doInBackground(Void... params) {
           try {
               String jkl = "ds";
               Log.d(jkl , "CHALA #######################################################################################################");

               URL urlForGetRequest = new URL("http://18.218.227.179:8000/api/request/get/?format=json");
               String readLine = null;
               HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
               conection.setRequestMethod("GET");

               //conection.setRequestProperty("id", "roll_no"); // set userId its a sample here

               int x = 5;
               boolean y = true;
               while(y){
                   Log.d( jkl , "oops");
                   x--;
                   if(x == 0) y = false;
               }

               //int responseCode = conection.getResponseCode();
               //x = 1000;
               y = true;
               int responseCode = 1;
               while(y) {
                   Log.d( jkl , "akdaidknoikaqnodioaikjsodioaisjodijaoisjmdojaodsjoiqweadiaoknjwesd");
                   responseCode = conection.getResponseCode();
                   //Log.d( jkl , Integer.toString(responseCode));
                   //jkl += ;
                   x--;
                   y = false;
               }



               Log.d(jkl , "CHALA ****************************************");

               if (responseCode == HttpURLConnection.HTTP_OK) {
                   BufferedReader in = new BufferedReader(
                           new InputStreamReader(conection.getInputStream()));
                   StringBuffer response = new StringBuffer();
                   while ((readLine = in.readLine()) != null) {
                       response.append(readLine);
                       System.out.println(readLine);
                   }
                   in.close();
                   // print result


                   //GetAndPost.POSTRequest(response.toString());
               } else {

                   Log.d(jkl , "CHALA %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
               }


           } catch (IOException e) {
               String y = "ipdsoidf";
               Log.d(y , "CHALA @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
               //Toast.makeText(getApplicationContext(), y , Toast.LENGTH_LONG).show();
           }
           String o = "ds";
           return null;
       }
   }





}
