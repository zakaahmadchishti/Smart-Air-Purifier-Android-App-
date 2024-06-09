package com.example.greenpakistan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;

import java.text.NumberFormat;
import java.time.Instant;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {


    Button Air_Quality_internal, Humudity_internal, Carbon_internal, myexpoure, Hisory_internal,temerature_History_internal,weather_history_internal;
    DatabaseReference dref;
TextView percentage,comment,text3,conditioncomment;
    String status;
ProgressBar pb;
   private int i=0;
    private Handler hdlr = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Air_Quality_internal=(Button)findViewById(R.id.Air_Quality);
        Humudity_internal=(Button)findViewById(R.id.Humudity);
        Carbon_internal=(Button)findViewById(R.id.Carbon);
        myexpoure=(Button)findViewById(R.id.My_Exposure);
        Hisory_internal=(Button)findViewById(R.id.Pollen);
        percentage=(TextView)findViewById(R.id.percentage);
        comment=(TextView)findViewById(R.id.comment);
        text3=(TextView)findViewById(R.id.textView3);
        conditioncomment=(TextView)findViewById(R.id.Condition_comment);
        temerature_History_internal=(Button)findViewById(R.id.Temperature);
        weather_history_internal=(Button)findViewById(R.id.Weather);
        pb=(ProgressBar)findViewById(R.id.pb);
//////////////////////////////////////////////////////////////////////////////////////////////////////



        View v;
        i = 0;
        new Thread(new Runnable() {
            public void run() {
                while (i < 125) {
                    i += 1;
                    // Update the progress bar and display the current value in text view
                    hdlr.post(new Runnable() {
                        public void run() {
                            pb.setProgress(i);

                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (i > 0) {
                    i -= 1;
                    // Update the progress bar and display the current value in text view
                    hdlr.post(new Runnable() {
                        public void run() {
                            pb.setProgress(i);

                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while (i < 125) {
                    i += 1;
                    // Update the progress bar and display the current value in text view
                    hdlr.post(new Runnable() {
                        public void run() {
                            pb.setProgress(i);

                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (i > 0) {
                    i -= 1;
                    // Update the progress bar and display the current value in text view
                    hdlr.post(new Runnable() {
                        public void run() {
                            pb.setProgress(i);

                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (i < 90) {
                    i += 1;
                    // Update the progress bar and display the current value in text view
                    hdlr.post(new Runnable() {
                        public void run() {
                            pb.setProgress(i);

                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();




//////////////////////////////////////////////////////////////////////////////////////////////////////progressive copy


        ///////////////////////////////////////prograssive copy
        Air_Quality_internal.setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View view) {
        Intent instent=new Intent (MainActivity.this,Air_Quality_Activity.class);
        startActivity(instent);
        CustomIntent.customType(MainActivity.this,"left-to-right");
    }
});

        Hisory_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instent=new Intent (MainActivity.this,Pollution_History_pollen.class);
                startActivity(instent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
            }
        });

        weather_history_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instent=new Intent (MainActivity.this,Weather_History.class);
                startActivity(instent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
            }
        });


        Humudity_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instent=new Intent (MainActivity.this,Activity_Humuidty.class);
                startActivity(instent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
            }

        });


        Carbon_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instent=new Intent (MainActivity.this,activity_carbon_full.class);
                startActivity(instent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
            }

        });

        temerature_History_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instent=new Intent (MainActivity.this,Temerature_History.class);
                startActivity(instent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
            }
        });



        myexpoure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instent=new Intent (MainActivity.this,my_exposure.class);
                startActivity(instent);
                CustomIntent.customType(MainActivity.this,"left-to-right");
            }

        });
/////////////////////////////////////////////////////////////////////////////////////////////////////progress bar
        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              //  FirebaseDatabase.getInstance().getReference("disconnectmessage").onDisconnect().setValue("I disconnected!");

                String status2;
                status = dataSnapshot.child("Sensors Data").child("Pollution").child("Reading1").getValue().toString();
                status2=status;
                percentage.setText(status+"%");


                status = dataSnapshot.child("Sensors Data").child("Additional").child("Mood").getValue().toString();
                comment.setText(status);
                text3.setText("AIR QUALITY");
                                           ////////////////////////////////loop for calculating percentage
                final int pfa;

                pfa=Integer.parseInt(status2);
                pb.setProgress(pfa);
               if(pfa>75)
               {
                   comment.setText("Unhealthy");
               }
               if(pfa>50&& pfa<75)
               {
                   comment.setText("Moderate");

               }
                if(pfa>25&& pfa<50)
                {
                    comment.setText("Good");

                }
               if(pfa<25)
               {
                   comment.setText("Excellent");
               }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });


///////////////////////////////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////progress bar






















////////////////////////////////////////////////////////////////////////////////////////////

       }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

    }















