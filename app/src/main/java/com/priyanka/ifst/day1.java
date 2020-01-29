package com.priyanka.ifst;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class day1 extends Fragment {

private RecyclerView recyclerView;
private EventListAdapter eventListAdapter;
    private ArrayList<EventLists> mEventLists;
    private DatabaseReference databaseReference;
    public day1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root=  inflater.inflate(R.layout.fragment_day1, container, false);
        recyclerView= root.findViewById(R.id.day1recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mEventLists=new ArrayList<EventLists>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Day1");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(getContext(),"hdss",Toast.LENGTH_SHORT);
                if(dataSnapshot.exists()) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        EventLists eventLists = postSnapshot.getValue(EventLists.class);
                        if (eventLists != null)
                            mEventLists.add(eventLists);
                    }
                    eventListAdapter = new EventListAdapter(getActivity(), mEventLists);

                    recyclerView.setAdapter(eventListAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),databaseError.toString(),Toast.LENGTH_SHORT);
            }
        });
        eventListAdapter= new EventListAdapter(getActivity(),mEventLists);

        recyclerView.setAdapter(eventListAdapter);
        return root;


    }


}
