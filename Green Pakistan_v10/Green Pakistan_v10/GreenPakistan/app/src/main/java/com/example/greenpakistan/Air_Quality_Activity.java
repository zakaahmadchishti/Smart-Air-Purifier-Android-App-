package com.example.greenpakistan;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Air_Quality_Activity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3;
    DatabaseReference dref;
    String status;
    TextView pollutionrealtime;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_quality);
        pollutionrealtime = (TextView) findViewById(R.id.Pollution_realtime);

        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status2;
                status = dataSnapshot.child("Sensors Data").child("Pollution").child("Reading0").getValue().toString();
                pollutionrealtime.setText(status);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });













    }
}