package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_07_experience_two extends Fragment {

    String jobTwoTitle;
    String companyTwoName;
    String jobTwoDuration;
    String jobTwoResponsibility;
    String jobTwoDescription;

    EditText user_input_xp_two_jobtitle, user_input_xp_two_company, user_input_xp_two_duration, user_input_xp_two_respons, user_input_xp_two_desc;

    CardView user_input_xp_two_addmore;

    FloatingActionButton fab_experience_two;

    public void GetData() {
        jobTwoTitle = user_input_xp_two_jobtitle.getText().toString();
        companyTwoName = user_input_xp_two_company.getText().toString();
        jobTwoDuration = user_input_xp_two_duration.getText().toString();
        jobTwoResponsibility = user_input_xp_two_respons.getText().toString();
        jobTwoDescription = user_input_xp_two_desc.getText().toString();
        try {
            MainActivity.userDetails.put("jobTwoTitle", jobTwoTitle);
            MainActivity.userDetails.put("companyTwoName", companyTwoName);
            MainActivity.userDetails.put("jobTwoDuration", jobTwoDuration);
            MainActivity.userDetails.put("jobTwoResponsibility", jobTwoResponsibility);
            MainActivity.userDetails.put("jobTwoDescription", jobTwoDescription);
        } catch (Exception e) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_07_experience_two, container, false);
        MainActivity.toolbar.setTitle("Experience Two");
        MainActivity.frag_progress_bar.setProgress(7);
        user_input_xp_two_addmore = view.findViewById(R.id.user_input_xp_two_addmore);
        fab_experience_two = view.findViewById(R.id.fab_experience_two);
        user_input_xp_two_jobtitle = view.findViewById(R.id.user_input_xp_two_jobtitle);
        user_input_xp_two_company = view.findViewById(R.id.user_input_xp_two_company);
        user_input_xp_two_duration = view.findViewById(R.id.user_input_xp_two_duration);
        user_input_xp_two_respons = view.findViewById(R.id.user_input_xp_two_respons);
        user_input_xp_two_desc = view.findViewById(R.id.user_input_xp_two_desc);
        user_input_xp_two_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_08_experience_three frag_experience_three = new Frag_08_experience_three();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_experience_three);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        fab_experience_two.setOnClickListener(new View.OnClickListener() {
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
