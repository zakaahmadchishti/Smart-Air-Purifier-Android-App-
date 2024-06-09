package com.example.greenpakistan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Weather_History extends AppCompatActivity {
    DatabaseReference dref;
    String status;
    TextView textviewa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather__history);

        textviewa=(TextView)findViewById(R.id.textView28);

        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status2;
                status = dataSnapshot.child("Sensors Data").child("Temperature").child("Reading0").getValue().toString();
                textviewa.setText(status);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






















    }
}