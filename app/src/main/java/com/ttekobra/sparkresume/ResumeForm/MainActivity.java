package com.ttekobra.sparkresume.ResumeForm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.FinalActivity;
import com.ttekobra.sparkresume.PojoClasses.AcademicsNullData;
import com.ttekobra.sparkresume.PojoClasses.AchievementsNullData;
import com.ttekobra.sparkresume.PojoClasses.ExperienceNullData;
import com.ttekobra.sparkresume.PojoClasses.ProjectsNullData;
import com.ttekobra.sparkresume.PojoClasses.SkillsNullData;
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

import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_04_academics_one.AcademicsOneDegree;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_04_academics_one.AcademicsOneDuration;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_04_academics_one.AcademicsOnePercentage;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_04_academics_one.AcademicsOneUniversity;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_05_academics_two.AcademicsTwoDegree;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_05_academics_two.AcademicsTwoDuration;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_05_academics_two.AcademicsTwoPercentage;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_05_academics_two.AcademicsTwoUniversity;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_06_academics_three.AcademicsThreeDegree;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_06_academics_three.AcademicsThreeDuration;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_06_academics_three.AcademicsThreePercentage;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_06_academics_three.AcademicsThreeUniversity;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_07_experience_one.companyOneName;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_07_experience_one.jobOneDescription;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_07_experience_one.jobOneDuration;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_07_experience_one.jobOneResponsibility;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_07_experience_one.jobOneTitle;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_08_experience_two.companyTwoName;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_08_experience_two.jobTwoDescription;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_08_experience_two.jobTwoDuration;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_08_experience_two.jobTwoResponsibility;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_08_experience_two.jobTwoTitle;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_09_experience_three.companyThreeName;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_09_experience_three.jobThreeDescription;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_09_experience_three.jobThreeDuration;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_09_experience_three.jobThreeResponsibility;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_09_experience_three.jobThreeTitle;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_10_projects_one.projectOneDescription;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_10_projects_one.projectOneLinks;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_10_projects_one.projectOneTitle;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_11_projects_two.projecttwoDescription;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_11_projects_two.projecttwoLinks;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_11_projects_two.projecttwoTitle;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_12_projects_three.projectthreeDescription;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_12_projects_three.projectthreeLinks;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_12_projects_three.projectthreeTitle;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_13_achievements.achievementDescOne;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_13_achievements.achievementDescTwo;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_13_achievements.achievementTitleOne;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_13_achievements.achievementTitleTwo;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_14_skills.skillTitleOne;
import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_14_skills.skillTitleTwo;

public class MainActivity extends AppCompatActivity {

    ProgressBar frag_progress_bar;

    FloatingActionButton fab_resume_activity;
    private VerticalViewPager viewPager;
    private PagerAdapter pager;
    ImageView main_activity_swipe_navigator;
    boolean navigatorVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_progress_bar = findViewById(R.id.frag_progress_bar);
        fab_resume_activity = findViewById(R.id.fab_resume_activity);
        main_activity_swipe_navigator = findViewById(R.id.main_activity_swipe_navigator);

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
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                frag_progress_bar.setProgress(i + 1);
                if (i == 1){
                    if (Frag_01_contact_details.user_input_fullname.getText().toString().trim().isEmpty()) {
                        Frag_01_contact_details.user_input_fullname.setError("This field can't be empty");
                        Frag_01_contact_details.user_input_fullname.requestFocus();
                        viewPager.setCurrentItem(0);
                    } else if (Frag_01_contact_details.user_input_mobile.getText().toString().trim().isEmpty()) {
                        Frag_01_contact_details.user_input_mobile.setError("This field can't be empty");
                        Frag_01_contact_details.user_input_mobile.requestFocus();
                        viewPager.setCurrentItem(0);
                    } else if (Frag_01_contact_details.user_input_email.getText().toString().trim().isEmpty()) {
                        Frag_01_contact_details.user_input_email.setError("This field can't be empty");
                        Frag_01_contact_details.user_input_email.requestFocus();
                        viewPager.setCurrentItem(0);
                    }
                }
                if (i == 13) {
                    fab_resume_activity.setImageDrawable(getDrawable(R.drawable.ic_cloud_upload));
                } else if (i != 13) {
                    fab_resume_activity.setImageDrawable(getDrawable(R.drawable.ic_go_down_next));
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        main_activity_swipe_navigator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_activity_swipe_navigator.setVisibility(View.GONE);
                navigatorVisible = false;
                fab_resume_activity.setImageDrawable(getDrawable(R.drawable.ic_go_down_next));
            }
        });

        fab_resume_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navigatorVisible) {
                    main_activity_swipe_navigator.setVisibility(View.GONE);
                    navigatorVisible = false;
                    fab_resume_activity.setImageDrawable(getDrawable(R.drawable.ic_go_down_next));
                } else {
                    int yy = viewPager.getCurrentItem();
                    if (yy == 13) {
                        Frag_14_skills.GetData();
                        GetNullData();
                        new AlertDialog.Builder(MainActivity.this).setTitle("Submit Form")
                                .setMessage("If you wish to cancel submission and review you form, press cancel button. Else click submit")
                                .setCancelable(true)
                                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                                .setNegativeButton("Review form", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        viewPager.setCurrentItem(0);
                                    }
                                }).show();
                    } else {
                        viewPager.setCurrentItem(yy + 1, true);
                    }
                }
            }
        });
    }

    public void GetNullData() {
        if (AcademicsTwoDegree.trim().isEmpty() && AcademicsTwoDuration.trim().isEmpty() && AcademicsTwoPercentage.trim().isEmpty() && AcademicsTwoUniversity.trim().isEmpty()
                && AcademicsThreeDegree.trim().isEmpty() && AcademicsThreeDuration.trim().isEmpty() && AcademicsThreePercentage.trim().isEmpty() && AcademicsThreeUniversity.trim().isEmpty()
                && AcademicsOneUniversity.trim().isEmpty() && AcademicsOnePercentage.trim().isEmpty() && AcademicsOneDuration.trim().isEmpty() && AcademicsOneDegree.trim().isEmpty()) {
            AcademicsNullData nullData = new AcademicsNullData("");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("AcademicsCounter").setValue(nullData);
        } else {
            AcademicsNullData nullData = new AcademicsNullData("1");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("AcademicsCounter").setValue(nullData);
        }
        if (companyTwoName.trim().isEmpty() && jobTwoDescription.trim().isEmpty() && jobTwoDuration.trim().isEmpty() && jobTwoResponsibility.trim().isEmpty() && jobTwoTitle.trim().isEmpty()
                && companyThreeName.trim().isEmpty() && jobThreeDescription.trim().isEmpty() && jobThreeDuration.trim().isEmpty() && jobThreeResponsibility.trim().isEmpty() && jobThreeTitle.trim().isEmpty()
                && companyOneName.trim().isEmpty() && jobOneDescription.trim().isEmpty() && jobOneDuration.trim().isEmpty() && jobOneResponsibility.trim().isEmpty() && jobOneTitle.trim().isEmpty()) {
            ExperienceNullData nullData = new ExperienceNullData("");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("ExperienceCounter").setValue(nullData);
        } else {
            ExperienceNullData nullData = new ExperienceNullData("1");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("ExperienceCounter").setValue(nullData);
        }
        if (projecttwoDescription.trim().isEmpty() && projecttwoLinks.trim().isEmpty() && projecttwoTitle.trim().isEmpty()
                && projectOneDescription.trim().isEmpty() && projectOneLinks.trim().isEmpty() && projectOneTitle.trim().isEmpty()
                && projectthreeDescription.trim().isEmpty() && projectthreeLinks.trim().isEmpty() && projectthreeTitle.trim().isEmpty()) {
            ProjectsNullData nullData = new ProjectsNullData("");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("ProjectCounter").setValue(nullData);
        } else {
            ProjectsNullData nullData = new ProjectsNullData("1");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("ProjectCounter").setValue(nullData);
        }
        if (achievementDescOne.trim().isEmpty() && achievementDescTwo.trim().isEmpty()
                && achievementTitleOne.trim().isEmpty() && achievementTitleTwo.trim().isEmpty()) {
            AchievementsNullData nullData = new AchievementsNullData("");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("AchievementCounter").setValue(nullData);
        } else {
            AchievementsNullData nullData = new AchievementsNullData("1");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("AchievementCounter").setValue(nullData);
        }
        if (skillTitleOne.trim().isEmpty() && skillTitleTwo.trim().isEmpty()) {
            SkillsNullData nullData = new SkillsNullData("");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("SkillsCounter").setValue(nullData);
        } else {
            SkillsNullData nullData = new SkillsNullData("1");
            FirebaseDatabase.getInstance().getReference("Users")
                    .child(Frag_01_contact_details.MobileNumber)
                    .child("SkillsCounter").setValue(nullData);
        }
    }
}
