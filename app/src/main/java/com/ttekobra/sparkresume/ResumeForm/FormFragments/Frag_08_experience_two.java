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

public class Frag_08_experience_two extends Fragment {

    public static String jobTwoTitle, companyTwoName, jobTwoDuration, jobTwoResponsibility, jobTwoDescription;

    public static EditText user_input_xp_two_jobtitle, user_input_xp_two_company, user_input_xp_two_duration, user_input_xp_two_respons, user_input_xp_two_desc;

    public static void GetData() {
        jobTwoTitle = user_input_xp_two_jobtitle.getText().toString();
        companyTwoName = user_input_xp_two_company.getText().toString();
        jobTwoDuration = user_input_xp_two_duration.getText().toString();
        jobTwoResponsibility = user_input_xp_two_respons.getText().toString();
        jobTwoDescription = user_input_xp_two_desc.getText().toString();

        ExperienceDetails experienceDetails = new ExperienceDetails(jobTwoTitle, companyTwoName, jobTwoDuration, jobTwoResponsibility, jobTwoDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("ExperienceDetailsTwo").setValue(experienceDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_08_experience_two, container, false);
        user_input_xp_two_jobtitle = view.findViewById(R.id.user_input_xp_two_jobtitle);
        user_input_xp_two_company = view.findViewById(R.id.user_input_xp_two_company);
        user_input_xp_two_duration = view.findViewById(R.id.user_input_xp_two_duration);
        user_input_xp_two_respons = view.findViewById(R.id.user_input_xp_two_respons);
        user_input_xp_two_desc = view.findViewById(R.id.user_input_xp_two_desc);

        return view;
    }
}
