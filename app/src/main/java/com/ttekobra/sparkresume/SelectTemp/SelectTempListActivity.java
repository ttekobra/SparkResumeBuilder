package com.ttekobra.sparkresume.SelectTemp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ttekobra.sparkresume.R;
import com.ttekobra.sparkresume.ResumeForm.MainActivity;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragFive;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragFour;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragOne;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragSix;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragThree;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragTwo;
import com.ttekobra.sparkresume.SelectTemp.Fragments.SelTempFragViewPagerAdapter;

import java.util.ArrayList;

public class SelectTempListActivity extends AppCompatActivity {

    public static String sel_temp_temp;
    ViewPager sel_temp_list_viewpager;
    FloatingActionButton sel_temp_fab;
    ArrayList<Fragment> list;
    SelTempFragViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_temp_list);
        sel_temp_list_viewpager = findViewById(R.id.sel_temp_list_viewpager);
        sel_temp_fab = findViewById(R.id.sel_temp_fab);

        list = new ArrayList<>();
        list.add(new SelTempFragOne());
        list.add(new SelTempFragTwo());
        list.add(new SelTempFragThree());
        list.add(new SelTempFragFour());
        list.add(new SelTempFragFive());
        list.add(new SelTempFragSix());

        adapter = new SelTempFragViewPagerAdapter(getSupportFragmentManager(), list);
        sel_temp_list_viewpager.setAdapter(adapter);

        sel_temp_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectTempListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        sel_temp_list_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                sel_temp_temp = String.valueOf(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
