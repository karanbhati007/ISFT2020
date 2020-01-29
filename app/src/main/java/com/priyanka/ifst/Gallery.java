package com.priyanka.ifst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Gallery extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GalleryAdapter galleryAdapter;
    private List<Upload> uploads;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recyclerView = findViewById(R.id.recyclerViewGallery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar =findViewById(R.id.progress_circular);
        uploads=new ArrayList<Upload>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Images");

//        databaseReference.orderByValue().limitToLast(4).addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, String previousChild) {
//                Log.d(TAG, "The " + snapshot.getKey() + " dinosaur's score is " + snapshot.getValue());
//            }
        Toast.makeText(this, "To view Gallery Please Connect to Internet", Toast.LENGTH_SHORT).show();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Toast.makeText(Gallery.this,"Loaded",Toast.LENGTH_SHORT).show();

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren())
                {
                   // Upload upload = postSnapshot.getValue(Upload.class);
                    Upload upload=new Upload();
                    upload.setUrl(postSnapshot.getValue().toString());
                    uploads.add(upload);
                }

                galleryAdapter =new GalleryAdapter(Gallery.this,uploads);
                recyclerView.setAdapter(galleryAdapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Gallery.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        galleryAdapter =new GalleryAdapter(Gallery.this,uploads);
        recyclerView.setAdapter(galleryAdapter);

    }
}
