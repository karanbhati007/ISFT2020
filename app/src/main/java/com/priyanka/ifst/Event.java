package com.priyanka.ifst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Event extends AppCompatActivity {

    Button day1,day2;
    ViewPager viewPager;
    TextView pdf;
    ViewPager.OnPageChangeListener onPageChangeListener= new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int x= viewPager.getCurrentItem();
            if(x==0){
                day1.setBackground(getDrawable(R.drawable.roundbutton));
                day2.setBackground(getDrawable(R.drawable.buttoncolor));
            }
            else{
                day1.setBackground(getDrawable(R.drawable.buttoncolor));
                day2.setBackground(getDrawable(R.drawable.roundbutton));
            }

        }

        @Override
        public void onPageSelected(int position) {


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        viewPager= findViewById(R.id.eventViewpager);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        DayAdapter adapter= new DayAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        day1= findViewById(R.id.btn1);
        day2= findViewById(R.id.btn2);
        pdf= findViewById(R.id.pdf);
pdf.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Event.this,schedule.class));
    }
});
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,true);
            }
        });
        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
            }
        });

    }
}
