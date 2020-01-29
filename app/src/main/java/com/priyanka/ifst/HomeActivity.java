package com.priyanka.ifst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    Button spoc;
    ImageView comm,developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        RelativeLayout relativeLayout5 = findViewById(R.id.cardRelative5);
        RelativeLayout relativeLayout1 = findViewById(R.id.cardRelative1);
        RelativeLayout relativeLayout4 = findViewById(R.id.cardRelative4);
        RelativeLayout relativeLayoutEvent= findViewById(R.id.eventcard);
        RelativeLayout relativeLayoutGallery = findViewById(R.id.relativeViewGallery);
        RelativeLayout relativeLayoutHelpDesk = findViewById(R.id.cardRelative6);
        spoc= findViewById(R.id.spoc);
        comm= findViewById(R.id.conference);
        developer=findViewById(R.id.developer);
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,developer.class));
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,committee.class));
            }
        });
        spoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,spoc.class));
            }
        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Collaborators.class));
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Organizers.class));
            }
        });

        relativeLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SpeakersList.class));
            }
        });
        relativeLayoutGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,Gallery.class));
            }
        });
        relativeLayoutEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,Event.class));
            }
        });


        relativeLayoutHelpDesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,HelpDesk.class));
            }
        });


    }
}
