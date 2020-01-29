package com.priyanka.ifst;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class day2 extends Fragment {
    private RecyclerView recyclerView;
    private EventListAdapter eventListAdapter;
    private ArrayList<EventLists> mEventLists;
    private DatabaseReference databaseReference;
    public day2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root=  inflater.inflate(R.layout.fragment_day2, container, false);
        recyclerView= root.findViewById(R.id.day2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mEventLists=new ArrayList<EventLists>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Day2");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren())
                {
                    EventLists eventLists=postSnapshot.getValue(EventLists.class);
                    mEventLists.add(eventLists);
                }
                eventListAdapter= new EventListAdapter(getActivity(),mEventLists);

                recyclerView.setAdapter(eventListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        eventListAdapter= new EventListAdapter(getActivity(),mEventLists);

        recyclerView.setAdapter(eventListAdapter);
        return root;




    }




}
