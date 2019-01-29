package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.AchievementDetails;
import com.ttekobra.sparkresume.R;

public class Frag_12_achievements extends Fragment {

    TextInputEditText user_input_ach_title_one, user_input_ach_desc_one, user_input_ach_title_two, user_input_ach_desc_two;
    FloatingActionButton fab_achievement;

    String achievementTitleOne;
    String achievementDescOne;
    String achievementTitleTwo;
    String achievementDescTwo;

    public void GetData() {
        achievementTitleOne = user_input_ach_title_one.getText().toString();
        achievementDescOne = user_input_ach_desc_one.getText().toString();
        achievementTitleTwo = user_input_ach_title_two.getText().toString();
        achievementDescTwo = user_input_ach_desc_two.getText().toString();

        AchievementDetails achievementDetailsOne = new AchievementDetails(achievementTitleOne, achievementDescOne);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName).child("AchievementDetailsOne").setValue(achievementDetailsOne);

        AchievementDetails achievementDetailsTwo = new AchievementDetails(achievementTitleTwo, achievementDescTwo);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName).child("AchievementDetailsTwo").setValue(achievementDetailsTwo);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_12_achievements, container, false);
        MainActivity.toolbar.setTitle("Achievements");
        MainActivity.frag_progress_bar.setProgress(12);

        user_input_ach_title_one = view.findViewById(R.id.user_input_ach_title_one);
        user_input_ach_desc_one = view.findViewById(R.id.user_input_ach_desc_one);
        user_input_ach_title_two = view.findViewById(R.id.user_input_ach_title_two);
        user_input_ach_desc_two = view.findViewById(R.id.user_input_ach_desc_two);
        fab_achievement = view.findViewById(R.id.fab_achievement);

        fab_achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_13_skills skills = new Frag_13_skills();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, skills);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}