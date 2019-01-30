package com.ttekobra.sparkresume.ResumeForm.FormFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.PojoClasses.SkillsDetails;
import com.ttekobra.sparkresume.R;

public class Frag_14_skills extends Fragment {

    public static EditText user_input_skill_title_one, user_input_skill_title_two;

    public static SeekBar user_input_skill_level_one, user_input_skill_level_two;

    public static String skillTitleOne, skillRatingOne, skillTitleTwo, skillRatingTwo;

    public static void GetData() {
        skillTitleOne = user_input_skill_title_one.getText().toString();
        skillTitleTwo = user_input_skill_title_two.getText().toString();

        Frag_01_contact_details.GetData();
        Frag_02_personal_details.GetData();
        Frag_04_academics_one.GetData();
        Frag_05_academics_two.GetData();
        Frag_06_academics_three.GetData();
        Frag_07_experience_one.GetData();
        Frag_08_experience_two.GetData();
        Frag_09_experience_three.GetData();
        Frag_10_projects_one.GetData();
        Frag_11_projects_two.GetData();
        Frag_12_projects_three.GetData();
        Frag_13_achievements.GetData();

        SkillsDetails skillsDetailsOne = new SkillsDetails(skillTitleOne, skillRatingOne);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("SkillsDetailsOne").setValue(skillsDetailsOne);
        SkillsDetails skillsDetailsTwo = new SkillsDetails(skillTitleTwo, skillRatingTwo);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("SkillsDetailsTwo").setValue(skillsDetailsTwo)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.i("Hey there", "it's working");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("Hey", "it's not working");
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_14_skills, container, false);
        user_input_skill_title_one = view.findViewById(R.id.user_input_skill_title_one);
        user_input_skill_level_one = view.findViewById(R.id.user_input_skill_level_one);
        user_input_skill_level_two = view.findViewById(R.id.user_input_skill_level_two);
        user_input_skill_title_two = view.findViewById(R.id.user_input_skill_title_two);

        user_input_skill_level_one.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float level = progress / 10;
                skillRatingOne = String.valueOf(level);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        user_input_skill_level_two.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float level = progress / 10;
                skillRatingTwo = String.valueOf(level);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        return view;
    }
}