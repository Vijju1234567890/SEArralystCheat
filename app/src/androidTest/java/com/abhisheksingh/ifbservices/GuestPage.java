package com.abhisheksingh.ifbservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class GuestPage extends AppCompatActivity {

    Button rateus,contactus,request;
    RatingBar rb;
    static float rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_page);
        rateus=(Button)findViewById(R.id.rate_us_btn);
        contactus=(Button)findViewById(R.id.contact_us_btn);
        rb=(RatingBar)findViewById(R.id.ratingBar_guest);
        request=(Button)findViewById(R.id.contact_support_btn);
        rb.setRating(FirstPage.total/FirstPage.num);
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rating=rb.getRating();
                FirstPage.total+=rating;
                FirstPage.num++;
                Toast.makeText(GuestPage.this,"Thank You!",Toast.LENGTH_LONG).show();
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuestPage.this, ContactUsPage.class));
            }
        });
       request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"f20160081@hyderabad.bits-pilani.ac.in"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Customer Support");
                try
                {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    ex.getStackTrace();
                }
            }
        });
    }
}
