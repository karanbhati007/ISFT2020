package com.priyanka.ifst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Organizers extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizers);
        viewPager=findViewById(R.id.viewpager);
        int[]image={R.drawable.isft,R.drawable.jcbust};
        viewPager.setAdapter(new MyAdapter(image,Organizers.this));

    }
}
class MyAdapter extends PagerAdapter
{
    int[]image;
    Context context;
    public MyAdapter(int[] image, Context context){
        this.image=image;
        this.context=context;
    }
    @Override
    public int getCount() {
        return image.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return true;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.details_1,container,false);
        container.addView(v);
        ImageView imageView=v.findViewById(R.id.ymca);
        imageView.setImageResource(image[position]);
        return v;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        View v =(View) object;
        container.removeView(v);
    }
}
