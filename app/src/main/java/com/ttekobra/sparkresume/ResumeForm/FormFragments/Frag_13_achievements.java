package com.ttekobra.sparkresume.ResumeForm.FormFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.PojoClasses.AchievementDetails;
import com.ttekobra.sparkresume.R;

public class Frag_13_achievements extends Fragment {

    public static EditText user_input_ach_title_one, user_input_ach_desc_one, user_input_ach_title_two, user_input_ach_desc_two;

    public static String achievementTitleOne, achievementDescOne, achievementTitleTwo, achievementDescTwo;

    public static void GetData() {
        achievementTitleOne = user_input_ach_title_one.getText().toString();
        achievementDescOne = user_input_ach_desc_one.getText().toString();
        achievementTitleTwo = user_input_ach_title_two.getText().toString();
        achievementDescTwo = user_input_ach_desc_two.getText().toString();

        AchievementDetails achievementDetailsOne = new AchievementDetails(achievementTitleOne, achievementDescOne);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("AchievementDetailsOne").setValue(achievementDetailsOne);

        AchievementDetails achievementDetailsTwo = new AchievementDetails(achievementTitleTwo, achievementDescTwo);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("AchievementDetailsTwo").setValue(achievementDetailsTwo);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_13_achievements, container, false);
        user_input_ach_title_one = view.findViewById(R.id.user_input_ach_title_one);
        user_input_ach_desc_one = view.findViewById(R.id.user_input_ach_desc_one);
        user_input_ach_title_two = view.findViewById(R.id.user_input_ach_title_two);
        user_input_ach_desc_two = view.findViewById(R.id.user_input_ach_desc_two);

        return view;
    }
}