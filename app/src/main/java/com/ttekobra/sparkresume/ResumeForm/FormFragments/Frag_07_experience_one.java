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

public class Frag_07_experience_one extends Fragment {

    public static String jobOneTitle, companyOneName, jobOneDuration, jobOneResponsibility, jobOneDescription;

    public static EditText user_input_xp_one_jobtitle, user_input_xp_one_company, user_input_xp_one_duration, user_input_xp_one_respons, user_input_xp_one_desc;

    public static void GetData() {
        jobOneTitle = user_input_xp_one_jobtitle.getText().toString();
        companyOneName = user_input_xp_one_company.getText().toString();
        jobOneDuration = user_input_xp_one_duration.getText().toString();
        jobOneResponsibility = user_input_xp_one_respons.getText().toString();
        jobOneDescription = user_input_xp_one_desc.getText().toString();

        ExperienceDetails experienceDetails = new ExperienceDetails(jobOneTitle, companyOneName, jobOneDuration, jobOneResponsibility, jobOneDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("ExperienceDetailsOne").setValue(experienceDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_07_experience_one, container, false);
        user_input_xp_one_jobtitle = view.findViewById(R.id.user_input_xp_one_jobtitle);
        user_input_xp_one_company = view.findViewById(R.id.user_input_xp_one_company);
        user_input_xp_one_duration = view.findViewById(R.id.user_input_xp_one_duration);
        user_input_xp_one_respons = view.findViewById(R.id.user_input_xp_one_respons);
        user_input_xp_one_desc = view.findViewById(R.id.user_input_xp_one_desc);

        return view;
    }
}
