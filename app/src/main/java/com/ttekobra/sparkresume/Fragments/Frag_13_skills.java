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
import android.widget.SeekBar;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.SkillsDetails;
import com.ttekobra.sparkresume.R;

public class Frag_13_skills extends Fragment {

    TextInputEditText user_input_skill_title_one, user_input_skill_desc_one;

    SeekBar user_input_skill_level_one;

    FloatingActionButton fab_skills_frag;

    String skillTitleOne;
    String skillDescOne;
    String skillRatingOne;

    public void GetData() {
        skillTitleOne = user_input_skill_title_one.getText().toString();
        skillDescOne = user_input_skill_desc_one.getText().toString();

        SkillsDetails skillsDetailsOne = new SkillsDetails(skillTitleOne, skillDescOne, skillRatingOne);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName).child("SkillsDetailsOne").setValue(skillsDetailsOne);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_13_skills, container, false);
        MainActivity.toolbar.setTitle("Enter Skills");
        MainActivity.frag_progress_bar.setProgress(13);

        fab_skills_frag = view.findViewById(R.id.fab_skills_frag);
        user_input_skill_title_one = view.findViewById(R.id.user_input_skill_title_one);
        user_input_skill_desc_one = view.findViewById(R.id.user_input_skill_desc_one);
        user_input_skill_level_one = view.findViewById(R.id.user_input_skill_level_one);

        user_input_skill_level_one.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skillRatingOne = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        fab_skills_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_14_extra_details extra_details = new Frag_14_extra_details();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, extra_details);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}