package com.ttekobra.sparkresume.ResumeForm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.ttekobra.sparkresume.R;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_01_contact_details;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_02_personal_details;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_03_about_me;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_04_academics_one;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_05_academics_two;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_06_academics_three;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_07_experience_one;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_08_experience_two;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_09_experience_three;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_10_projects_one;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_11_projects_two;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_12_projects_three;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_13_achievements;
import com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_14_skills;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressBar frag_progress_bar;

    FloatingActionButton fab_resume_activity;
    private VerticalViewPager viewPager;
    private PagerAdapter pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_progress_bar = findViewById(R.id.frag_progress_bar);
        fab_resume_activity = findViewById(R.id.fab_resume_activity);

        List<Fragment> list = new ArrayList<>();
        list.add(new Frag_01_contact_details());
        list.add(new Frag_02_personal_details());
        list.add(new Frag_03_about_me());
        list.add(new Frag_04_academics_one());
        list.add(new Frag_05_academics_two());
        list.add(new Frag_06_academics_three());
        list.add(new Frag_07_experience_one());
        list.add(new Frag_08_experience_two());
        list.add(new Frag_09_experience_three());
        list.add(new Frag_10_projects_one());
        list.add(new Frag_11_projects_two());
        list.add(new Frag_12_projects_three());
        list.add(new Frag_13_achievements());
        list.add(new Frag_14_skills());

        viewPager = findViewById(R.id.container);

        pager = new Pager(getSupportFragmentManager(), list);

        viewPager.setAdapter(pager);
        /*VerticalViewPagerAnimation animation = new VerticalViewPagerAnimation();
        viewPager.setPageTransformer(true, animation);*/
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                frag_progress_bar.setProgress(i + 1);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        fab_resume_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yy = viewPager.getCurrentItem();
                if (yy == 13) {
                    Frag_14_skills.GetData();
                } else {
                    viewPager.setCurrentItem(yy + 1, true);
                }
            }
        });
    }
}
