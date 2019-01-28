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

public class Frag_experience_two extends Fragment {

    String jobTitle;
    String companyName;
    String jobDuration;
    String jobResponsibility;
    String jobDescription;

    EditText user_input_xp_two_jobtitle, user_input_xp_two_company, user_input_xp_two_duration, user_input_xp_two_respons, user_input_xp_two_desc;

    CardView user_input_xp_two_addmore;

    FloatingActionButton fab_experience_two;

    public void GetData() {
        jobTitle = user_input_xp_two_jobtitle.getText().toString();
        companyName = user_input_xp_two_company.getText().toString();
        jobDuration = user_input_xp_two_duration.getText().toString();
        jobResponsibility = user_input_xp_two_respons.getText().toString();
        jobDescription = user_input_xp_two_desc.getText().toString();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_experience_two, container, false);

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
                MainActivity.frag_progress_bar.setProgress(8);
                Frag_experience_three frag_experience_three = new Frag_experience_three();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_experience_three);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
