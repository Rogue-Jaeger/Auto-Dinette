package com.example.maverick.myapplication;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class rating_fragment extends Fragment {


    View v;
    TextView tv;
    Button b;

    public rating_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_rating_fragment, container, false);

        tv = (TextView)v.findViewById(R.id.ratingfragmenttextView);
        b = (Button) v.findViewById(R.id.ratingfragmentsubmitbutton);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets() , "fonts/freight-sans.ttf");
        tv.setTypeface(tf , Typeface.ITALIC);
        b.setTypeface(tf);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity() , "Thanks for submitting your response!" , Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
