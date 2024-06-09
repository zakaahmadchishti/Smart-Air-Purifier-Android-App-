package com.example.greenpakistan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import maes.tech.intentanim.CustomIntent;

public class Activity_Humuidty extends AppCompatActivity {
    TextView monday_temp,Tuesday_temp,wednesday_temp,thrusday_temp,friday_temp,realtime_humudity;
    ImageView monday_img,tuesday_img,wednesday_img, thrusday_img,friday_img;
    DatabaseReference dref;
    String status;
Button button;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__humuidty);
        monday_temp=(TextView)findViewById(R.id.text_monday);
        Tuesday_temp=(TextView)findViewById(R.id.text_tuesday);
        wednesday_temp=(TextView)findViewById(R.id.text_wednesday);
        thrusday_temp=(TextView)findViewById(R.id.text_thrusday);
        friday_temp=(TextView)findViewById(R.id.text_friday);

        realtime_humudity=(TextView)findViewById(R.id.realtime_humudity);

        button=(Button)findViewById(R.id.button);




        monday_img=(ImageView)findViewById(R.id.image_monday);
        tuesday_img=(ImageView)findViewById(R.id.image_tuesday);
        wednesday_img=(ImageView)findViewById(R.id.image_wednesday);
        thrusday_img=(ImageView)findViewById(R.id.image_thrusday);
        friday_img=(ImageView)findViewById(R.id.image_friday);
//////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////
        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final int temperature1, temperature2, temperature3, temperature4, temperature5;
///////////////////////////////////////////////////////

                status = dataSnapshot.child("Sensors Data").child("Day Temperature").child("Monday").getValue().toString();
                temperature1 = Integer.parseInt(status);
                monday_temp.setText(status+" RH");
                if(temperature1>45)
                {
                    monday_img.setImageResource(R.drawable.sunny);
                }
                if(temperature1<35)
                {
                    monday_img.setImageResource(R.drawable.partially_cloudy);
                }
                if(temperature1<20)
                {
                    monday_img.setImageResource(R.drawable.raining_sunny);
                }
                if(temperature1<20)
                {
                    monday_img.setImageResource(R.drawable.raining);
                }
////////////////////////////////////////////////////////////////////////
               String status1 = dataSnapshot.child("Sensors Data").child("Day Temperature").child("Wednesday").getValue().toString();
                temperature3 = Integer.parseInt(status1);
                wednesday_temp.setText(status1+" RH");
                if(temperature3>45)
                {
                    wednesday_img.setImageResource(R.drawable.sunny);
                }
                if(temperature3<35)
                {
                    wednesday_img.setImageResource(R.drawable.partially_cloudy);
                }
                if(temperature3<20)
                {
                    wednesday_img.setImageResource(R.drawable.raining_sunny);
                }
                if(temperature3<20)
                {
                    wednesday_img.setImageResource(R.drawable.raining);
                }


/////////////////////////////////////////////////////////////////////

                String status2 = dataSnapshot.child("Sensors Data").child("Day Temperature").child("Tuesday").getValue().toString();
                temperature2 = Integer.parseInt(status2);
                Tuesday_temp.setText(status2+" RH");
                if(temperature2>45)
                {
                    tuesday_img.setImageResource(R.drawable.sunny);
                }
                if(temperature2<35)
                {
                    tuesday_img.setImageResource(R.drawable.partially_cloudy);
                }
                if(temperature2<20)
                {
                    tuesday_img.setImageResource(R.drawable.raining_sunny);
                }
                if(temperature2<20)
                {
                    tuesday_img.setImageResource(R.drawable.raining);
                }

//////////////////////////////////////////////////////////////////////////////////////////////////////

                status = dataSnapshot.child("Sensors Data").child("Day Temperature").child("Thrusday").getValue().toString();
                temperature4 = Integer.parseInt(status);
                thrusday_temp.setText(status+" RH");
                if(temperature4>45)
                {
                    thrusday_img.setImageResource(R.drawable.sunny);
                }
                if(temperature4<35)
                {
                    thrusday_img.setImageResource(R.drawable.partially_cloudy);
                }
                if(temperature4<20)
                {
                    thrusday_img.setImageResource(R.drawable.raining_sunny);
                }
                if(temperature4<20)
                {
                    thrusday_img.setImageResource(R.drawable.raining);
                }
/////////////////////////////////////////////////////////////////////////////////////

                status = dataSnapshot.child("Sensors Data").child("Day Temperature").child("Friday").getValue().toString();
                temperature5 = Integer.parseInt(status);
                friday_temp.setText(status+" RH");
                if(temperature5>45)
                {
                    friday_img.setImageResource(R.drawable.sunny);
                }
                if(temperature5<35)
                {
                    friday_img.setImageResource(R.drawable.partially_cloudy);
                }
                if(temperature5<20)
                {
                    friday_img.setImageResource(R.drawable.raining_sunny);
                }
                if(temperature5<20)
                {
                    friday_img.setImageResource(R.drawable.raining);
                }


/////////////////////////////////////////////////////////////////////

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });














//////////////////////////////////////////////////////////////////////////////////









    }
}