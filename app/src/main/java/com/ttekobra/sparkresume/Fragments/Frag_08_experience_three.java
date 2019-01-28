package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_08_experience_three extends Fragment {

    String jobThreeTitle;
    String companyThreeName;
    String jobThreeDuration;
    String jobThreeResponsibility;
    String jobThreeDescription;

    EditText user_input_xp_three_jobtitle, user_input_xp_three_company, user_input_xp_three_duration, user_input_xp_three_respons, user_input_xp_three_desc;

    FloatingActionButton fab_experience_three;

    public void GetData() {
        jobThreeTitle = user_input_xp_three_jobtitle.getText().toString();
        companyThreeName = user_input_xp_three_company.getText().toString();
        jobThreeDuration = user_input_xp_three_duration.getText().toString();
        jobThreeResponsibility = user_input_xp_three_respons.getText().toString();
        jobThreeDescription = user_input_xp_three_desc.getText().toString();
        try {
            MainActivity.userDetails.put("jobThreeTitle", jobThreeTitle);
            MainActivity.userDetails.put("companyThreeName", companyThreeName);
            MainActivity.userDetails.put("jobThreeDuration", jobThreeDuration);
            MainActivity.userDetails.put("jobThreeResponsibility", jobThreeResponsibility);
            MainActivity.userDetails.put("jobThreeDescription", jobThreeDescription);
        } catch (Exception e) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_08_experience_three, container, false);
        MainActivity.toolbar.setTitle("Experience Three");
        MainActivity.frag_progress_bar.setProgress(8);
        fab_experience_three = view.findViewById(R.id.fab_experience_three);
        user_input_xp_three_jobtitle = view.findViewById(R.id.user_input_xp_three_jobtitle);
        user_input_xp_three_company = view.findViewById(R.id.user_input_xp_three_company);
        user_input_xp_three_duration = view.findViewById(R.id.user_input_xp_three_duration);
        user_input_xp_three_respons = view.findViewById(R.id.user_input_xp_three_respons);
        user_input_xp_three_desc = view.findViewById(R.id.user_input_xp_three_desc);
        fab_experience_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_09_projects_one frag_09_projects_one = new Frag_09_projects_one();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_09_projects_one);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}