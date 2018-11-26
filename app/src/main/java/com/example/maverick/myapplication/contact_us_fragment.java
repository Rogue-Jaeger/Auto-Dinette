package com.example.maverick.myapplication;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class contact_us_fragment extends Fragment {

    public TextView tv1,tv2;
    public Button b1;
    View v;


    public contact_us_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_contact_us_fragment, container, false);

        tv1 = (TextView)v.findViewById(R.id.contactusfragmentcontacttextview);
        tv2 = (TextView)v.findViewById(R.id.contactusfragmenthellotextview);
        b1 = (Button)v.findViewById(R.id.contactusfragmentmailButton);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets() , "fonts/freight-sans.ttf");
        tv1.setTypeface(tf , Typeface.ITALIC);
        tv2.setTypeface(tf);
        b1.setTypeface(tf);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent mailClient = new Intent(Intent.ACTION_VIEW);
                mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivityGmail");
                startActivity(mailClient);*/


                /*Intent mailClient = new Intent(Intent.ACTION_VIEW);

                        mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail")
                        .setType("plain/text")
                        .setData(Uri.parse("test@gmail.com"))
                        //.putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"})
                        .putExtra(Intent.EXTRA_SUBJECT, "test")
                        .putExtra(Intent.EXTRA_TEXT, "hello. this is a message sent from my demo app :-)")
                        ;

                startActivity(mailClient);*/

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "autodinette@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Please care enter your roll number here....!");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Thanks for your feedback.....!");
                startActivity(Intent.createChooser(emailIntent, null));
            }
        });

        return v;
    }

}
