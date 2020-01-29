package com.priyanka.ifst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>  {
    private List<Upload> mUploads ;
    private Context mcontext;
    public  GalleryAdapter(Context mContext,List<Upload> mUploads)
    {
        this.mcontext=mContext;
        this.mUploads=mUploads;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album,viewGroup,false);
        ImageViewHolder imageViewHolder=new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Upload currentUpload = mUploads.get(i);
        Picasso.with(mcontext)
                .load(currentUpload.getUrl())
                .placeholder(R.drawable.bu)
                .fit()
                .centerCrop()
                .into(imageViewHolder.album);
    }
    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public  static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView album;
        public ImageViewHolder(View ItemView)
        {
            super(ItemView);
            album= ItemView.findViewById(R.id.album);
        }
    }
}
