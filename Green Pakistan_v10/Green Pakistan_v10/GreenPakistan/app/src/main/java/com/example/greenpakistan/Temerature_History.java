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

public class Temerature_History extends AppCompatActivity {

    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    DatabaseReference dref;
String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temerature__history);

        txt1=(TextView)findViewById(R.id.texta1);
        txt2=(TextView)findViewById(R.id.textView2);
        txt3=(TextView)findViewById(R.id.textView4);
        txt4=(TextView)findViewById(R.id.textView3);
        txt5=(TextView)findViewById(R.id.textView5);
        txt6=(TextView)findViewById(R.id.textView6);
        txt7=(TextView)findViewById(R.id.textView7);



            dref = FirebaseDatabase.getInstance().getReference();
            dref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String status2; int temperature5;
                    status = dataSnapshot.child("Sensors Data").child("Pollution").child("Reading0").getValue().toString();
                    txt1.setText(status);
                    temperature5 = Integer.parseInt(status);


                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });








       /////////////////////////////////











    }
}