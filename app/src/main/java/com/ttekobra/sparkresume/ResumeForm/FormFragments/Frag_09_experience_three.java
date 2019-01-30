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
import com.ttekobra.sparkresume.PojoClasses.ExperienceDetails;
import com.ttekobra.sparkresume.R;

public class Frag_09_experience_three extends Fragment {

    public static String jobThreeTitle, companyThreeName, jobThreeDuration, jobThreeResponsibility, jobThreeDescription;

    public static EditText user_input_xp_three_jobtitle, user_input_xp_three_company, user_input_xp_three_duration, user_input_xp_three_respons, user_input_xp_three_desc;

    public static void GetData() {
        jobThreeTitle = user_input_xp_three_jobtitle.getText().toString();
        companyThreeName = user_input_xp_three_company.getText().toString();
        jobThreeDuration = user_input_xp_three_duration.getText().toString();
        jobThreeResponsibility = user_input_xp_three_respons.getText().toString();
        jobThreeDescription = user_input_xp_three_desc.getText().toString();

        ExperienceDetails experienceDetails = new ExperienceDetails(jobThreeTitle, companyThreeName, jobThreeDuration, jobThreeResponsibility, jobThreeDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("ExperienceDetailsThree").setValue(experienceDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_09_experience_three, container, false);
        user_input_xp_three_jobtitle = view.findViewById(R.id.user_input_xp_three_jobtitle);
        user_input_xp_three_company = view.findViewById(R.id.user_input_xp_three_company);
        user_input_xp_three_duration = view.findViewById(R.id.user_input_xp_three_duration);
        user_input_xp_three_respons = view.findViewById(R.id.user_input_xp_three_respons);
        user_input_xp_three_desc = view.findViewById(R.id.user_input_xp_three_desc);

        return view;
    }
}