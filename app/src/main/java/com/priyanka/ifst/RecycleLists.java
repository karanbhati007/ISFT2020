package com.priyanka.ifst;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class RecycleLists extends RecyclerView.Adapter<RecycleLists.RecycleHolder> {

    public Context context;
    public String[] name1;
    public String[] desig1;

    public RecycleLists(Context context,String[] name,String[] desig)
    {
        this.context =context;
        this.name1=name;
        this.desig1=desig;
    }


    @NonNull
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.recyclelist,parent,false);

        return new RecycleHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder holder, int position) {

        int index=position+1;

        String uri = "@drawable/sp"+index;
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource);
        holder.photo.setImageDrawable(res);

        holder.name.setText(name1[position]);
        holder.desig.setText(desig1[position]);

    }

    @Override
    public int getItemCount() {
        return 21;
    }

    public class RecycleHolder extends RecyclerView.ViewHolder {

        TextView name,desig;
        CircularImageView photo;

        public RecycleHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            desig = itemView.findViewById(R.id.university);
            photo = itemView.findViewById(R.id.photo);

        }
    }
}
