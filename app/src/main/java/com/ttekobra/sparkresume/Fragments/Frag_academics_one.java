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

public class Frag_academics_one extends Fragment {

    EditText user_input_ac_one_startyear, user_input_ac_one_endyear, user_input_ac_one_degree, user_input_ac_one_university, user_input_ac_one_percentage;
    CardView user_input_ac_one_addmore;
    FloatingActionButton fab_academics_one;

    String AcademicsOneStart;
    String AcademicsOneEnd;
    String AcademicsOneDegree;
    String AcademicsOneUniversity;
    String AcademicsOnePercentage;


    public void GetData() {
        AcademicsOneStart = user_input_ac_one_startyear.getText().toString();
        AcademicsOneEnd = user_input_ac_one_endyear.getText().toString();
        AcademicsOneDegree = user_input_ac_one_degree.getText().toString();
        AcademicsOneUniversity = user_input_ac_one_university.getText().toString();
        AcademicsOnePercentage = user_input_ac_one_percentage.getText().toString();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_academics_one, container, false);

        user_input_ac_one_startyear = view.findViewById(R.id.user_input_ac_one_startyear);
        user_input_ac_one_endyear = view.findViewById(R.id.user_input_ac_one_endyear);
        user_input_ac_one_degree = view.findViewById(R.id.user_input_ac_one_degree);
        user_input_ac_one_university = view.findViewById(R.id.user_input_ac_one_university);
        user_input_ac_one_percentage = view.findViewById(R.id.user_input_ac_one_percentage);
        user_input_ac_one_addmore = view.findViewById(R.id.user_input_ac_one_addmore);
        fab_academics_one = view.findViewById(R.id.fab_academics_one);

        user_input_ac_one_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                MainActivity.frag_progress_bar.setProgress(4);
                Frag_academics_two frag_academics_two = new Frag_academics_two();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_academics_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        fab_academics_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                MainActivity.frag_progress_bar.setProgress(6);
                Frag_experience_one frag_experience_one = new Frag_experience_one();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, frag_experience_one);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
