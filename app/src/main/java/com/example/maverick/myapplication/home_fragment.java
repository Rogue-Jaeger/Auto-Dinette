package com.example.maverick.myapplication;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class home_fragment extends Fragment implements View.OnClickListener{


    public home_fragment() {
        // Required empty public constructor
    }


    public Button markabsencebutton;
    public Button messbillbutton;
    public Button messmenubutton;
//    public TextView text;


    public FrameLayout fl;
    public BottomNavigationView bnv;

    //public HomeFragment homeFragment;
    public view_monthly_mess_bill_fragment messbillfragment;
    public contact_us_fragment contactusfragment;
    public rating_fragment ratingfragment;


    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        markabsencebutton = (Button)v.findViewById(R.id.homefragmentmarkabsencebutton);  // we have to insert v before find view by id
        messbillbutton = (Button)v.findViewById(R.id.homefragmentmessbillbutton);
        messmenubutton = (Button)v.findViewById(R.id.homefragmentmessmenubutton);
//        text = (TextView)v.findViewById(R.id.hellotoolbartext);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets() , "fonts/freight-sans.ttf");
        markabsencebutton.setTypeface(tf);
        messmenubutton.setTypeface(tf);
        messbillbutton.setTypeface(tf);
//        text.setTypeface(tf);

//
//        messbillfragment = new view_monthly_mess_bill_fragment();
//        contactusfragment = new contact_us_fragment();
//        ratingfragment = new rating_fragment();
//
//
//        fl = (FrameLayout)v.findViewById(R.id.helloactivityframelayout);
//        bnv = (BottomNavigationView)v.findViewById(R.id.hello_bottom_nav_bar);


        markabsencebutton.setOnClickListener(this);
        messbillbutton.setOnClickListener(this);
        messmenubutton.setOnClickListener(this);
//
//
//        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//
//                    case R.id.nav_home:
//                        bnv.setItemBackgroundResource(R.color.Instagram_blue);
//                        setFragment(messbillfragment);
//                        return true;
//
//                    case R.id.nav_acc_bal:
//                        bnv.setItemBackgroundResource(R.color.Instagram_blue);
//                        setFragment(messbillfragment);
//                        return true;
//
//                    case R.id.nav_contact_mail:
//                        bnv.setItemBackgroundResource(R.color.Instagram_blue);
//                        setFragment(contactusfragment);
//                        return true;
//
//                    case R.id.nav_rating:
//                        bnv.setItemBackgroundResource(R.color.Instagram_blue);
//                        setFragment(ratingfragment);
//                        return true;
//
//                    default:
//                        return false;
//                }
//            }
//        });
        return v;
    }

//    private void setFragment(Fragment fragment) {
//        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction(); // see we have to use get activity here
//        ft.replace(R.id.helloactivityframelayout , fragment);
//        ft.commit();
//    }
//
    @Override
    public void onClick(View v) {

        if(v == markabsencebutton){
                Intent go = new Intent(getActivity() , dayofabsence.class);
                startActivity(go);
        }
        else if(v == messbillbutton){
                Intent go1 = new Intent(getActivity() , viewmessbill.class);
                startActivity(go1);
        }
        else if(v == messmenubutton){
                Intent go2 = new Intent(getActivity() , viewmessmenu.class);
                startActivity(go2);
        }

    }
}
