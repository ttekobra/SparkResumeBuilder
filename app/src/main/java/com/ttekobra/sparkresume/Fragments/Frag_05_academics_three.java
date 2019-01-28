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

public class Frag_05_academics_three extends Fragment {

    EditText user_input_ac_three_startyear, user_input_ac_three_endyear, user_input_ac_three_degree, user_input_ac_three_university, user_input_ac_three_percentage;

    FloatingActionButton fab_academics_three;

    String AcademicsThreeStart;
    String AcademicsThreeEnd;
    String AcademicsThreeDegree;
    String AcademicsThreeUniversity;
    String AcademicsThreePercentage;

    public void GetData() {
        AcademicsThreeStart = user_input_ac_three_startyear.getText().toString();
        AcademicsThreeEnd = user_input_ac_three_endyear.getText().toString();
        AcademicsThreeDegree = user_input_ac_three_degree.getText().toString();
        AcademicsThreeUniversity = user_input_ac_three_university.getText().toString();
        AcademicsThreePercentage = user_input_ac_three_percentage.getText().toString();
        try {
            MainActivity.userDetails.put("AcademicsThreeStart", AcademicsThreeStart);
            MainActivity.userDetails.put("AcademicsThreeEnd", AcademicsThreeEnd);
            MainActivity.userDetails.put("AcademicsThreeDegree", AcademicsThreeDegree);
            MainActivity.userDetails.put("AcademicsThreeUniversity", AcademicsThreeUniversity);
            MainActivity.userDetails.put("AcademicsThreePercentage", AcademicsThreePercentage);
        } catch (Exception e) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_05_academics_three, container, false);
        MainActivity.toolbar.setTitle("Academics Three");
        MainActivity.frag_progress_bar.setProgress(5);
        user_input_ac_three_startyear = view.findViewById(R.id.user_input_ac_three_startyear);
        user_input_ac_three_endyear = view.findViewById(R.id.user_input_ac_three_endyear);
        user_input_ac_three_degree = view.findViewById(R.id.user_input_ac_three_degree);
        user_input_ac_three_university = view.findViewById(R.id.user_input_ac_three_university);
        user_input_ac_three_percentage = view.findViewById(R.id.user_input_ac_three_percentage);
        fab_academics_three = view.findViewById(R.id.fab_academics_three);
        fab_academics_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_06_experience_one frag_experience_one = new Frag_06_experience_one();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_experience_one);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
