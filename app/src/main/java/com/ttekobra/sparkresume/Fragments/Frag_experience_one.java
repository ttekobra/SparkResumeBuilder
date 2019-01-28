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

public class Frag_experience_one extends Fragment {

    String jobTitle;
    String companyName;
    String jobDuration;
    String jobResponsibility;
    String jobDescription;

    EditText user_input_xp_one_jobtitle, user_input_xp_one_company, user_input_xp_one_duration, user_input_xp_one_respons, user_input_xp_one_desc;

    CardView user_input_xp_one_addmore;

    FloatingActionButton fab_experience_one;

    public void GetData() {
        jobTitle = user_input_xp_one_jobtitle.getText().toString();
        companyName = user_input_xp_one_company.getText().toString();
        jobDuration = user_input_xp_one_duration.getText().toString();
        jobResponsibility = user_input_xp_one_respons.getText().toString();
        jobDescription = user_input_xp_one_desc.getText().toString();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_experience_one, container, false);
        user_input_xp_one_addmore = view.findViewById(R.id.user_input_xp_one_addmore);
        fab_experience_one = view.findViewById(R.id.fab_experience_one);
        user_input_xp_one_jobtitle = view.findViewById(R.id.user_input_xp_one_jobtitle);
        user_input_xp_one_company = view.findViewById(R.id.user_input_xp_one_company);
        user_input_xp_one_duration = view.findViewById(R.id.user_input_xp_one_duration);
        user_input_xp_one_respons = view.findViewById(R.id.user_input_xp_one_respons);
        user_input_xp_one_desc = view.findViewById(R.id.user_input_xp_one_desc);

        user_input_xp_one_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                MainActivity.frag_progress_bar.setProgress(7);
                Frag_experience_two frag_experience_two = new Frag_experience_two();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_experience_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        fab_experience_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
