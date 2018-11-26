package com.example.maverick.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Hello extends AppCompatActivity {

    public Button markabsencebutton;
    public Button messbillbutton;
    public Button messmenubutton;
    public TextView text;


    public FrameLayout fl;
    public BottomNavigationView bnv;

    //public HomeFragment homeFragment;
    public view_monthly_mess_bill_fragment messbillfragment;
    public contact_us_fragment contactusfragment;
    public rating_fragment ratingfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);



        text = (TextView)findViewById(R.id.hellotoolbartext);

        Typeface tf = Typeface.createFromAsset(getAssets() , "fonts/freight-sans.ttf");
//        markabsencebutton.setTypeface(tf);
//        messmenubutton.setTypeface(tf);
//        messbillbutton.setTypeface(tf);
        text.setTypeface(tf);


        messbillfragment = new view_monthly_mess_bill_fragment();
        contactusfragment = new contact_us_fragment();
        ratingfragment = new rating_fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.helloactivityframelayout , new home_fragment()).commit();


        fl = (FrameLayout)findViewById(R.id.helloactivityframelayout);
        bnv = (BottomNavigationView)findViewById(R.id.hello_bottom_nav_bar);





        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.nav_home:
                        setFragment(new home_fragment());
                        return true;

                    case R.id.nav_acc_bal:
                        setFragment(new view_monthly_mess_bill_fragment());
                        return true;

                    case R.id.nav_contact_mail:
                        setFragment(new contact_us_fragment());
                        return true;

                    case R.id.nav_rating:
                        setFragment(new rating_fragment());
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.helloactivityframelayout , fragment);
        ft.commit();
    }
}
