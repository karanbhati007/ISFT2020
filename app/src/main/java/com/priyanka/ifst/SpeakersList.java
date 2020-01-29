package com.priyanka.ifst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SpeakersList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakerslist);


        String[] name = {"Prof. Rajiv Dubey","Dr. Stephen Sundar Rao","Prof. Autar Kaw","Prof. Sreekantha Jonnalagadda","Prof. Olivier Francais","Dr. Sudip Chakraborty","Dr. Stefano Curcio","Dr. Vincenza Calabrò","Dr. Napat Watjanatepin","Prof. Hideak Ohghaki","Prof. Naureddin Takorabet","Prof. Sanjeev Khanna","Dr. Vinod Kumar Sharma","Prof. Rick Reidy","Prof. Wolfgang Borutzky","Prof. G. D. Najafpour","Prof. Michael Monticino","Prof. Junhua Ding","Prof. Mohammad Pazouki","Prof. Victor Prybutok","Dr. Gayle Prybutok"};

        String[] desig = {"University of South Florida","University of South Florida","University of South Florida","University of KwaZulu-Natal","ESIEE, Paris","University of Calabria,Italy","University of Calabria,Italy","University of Calabria,Italy","Rajamangala University of Technology Suvarnabhumi","Institute of advance energy, Kyoto University","University of Lorraine (UdL)","University of Missouri College of Engineering","ENEA","University of North Texas","Hochschule Bonn-Rhein-Sieg University, Germany","Babol Noshirvani University of Technology Babol, Iran","University of North Texas, USA","University of North Texas, USA","Materials and Energy Research Center, Karaj, Iran","University of North Texas, USA","University of North Texas, USA"};

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new RecycleLists(this,name,desig));

    }
}
