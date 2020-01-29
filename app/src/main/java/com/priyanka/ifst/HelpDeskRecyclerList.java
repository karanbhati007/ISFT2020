package com.priyanka.ifst;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HelpDeskRecyclerList extends RecyclerView.Adapter<HelpDeskRecyclerList.helpdeskHolder> {

    Context context;
    String[] venue;
    String[] name;
    String[] phone;

    public HelpDeskRecyclerList(Context context,String[] name,String[] venue, String[] phone){
        this.context = context;
        this.name = name;
        this.venue = venue;
        this.phone = phone;

    }

    @NonNull
    @Override
    public helpdeskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.helpdesklayout,parent,false);

        return new helpdeskHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final helpdeskHolder holder, final int position) {

        holder.name.setText(name[position]);
        holder.venue.setText(venue[position]);
        holder.phone.setText(phone[position]);

        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone[position]));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class helpdeskHolder extends RecyclerView.ViewHolder{

        TextView name,phone,venue;

        public helpdeskHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phoneno);
            venue = itemView.findViewById(R.id.venue);






        }
    }
}
