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

public class Frag_academics_three extends Fragment {

    EditText user_input_ac_three_startyear, user_input_ac_three_endyear, user_input_ac_three_degree, user_input_ac_three_university, user_input_ac_three_percentage;

    FloatingActionButton fab_academics_three;

    String AcademicsOneStart;
    String AcademicsOneEnd;
    String AcademicsOneDegree;
    String AcademicsOneUniversity;
    String AcademicsOnePercentage;

    public void GetData() {
        AcademicsOneStart = user_input_ac_three_startyear.getText().toString();
        AcademicsOneEnd = user_input_ac_three_endyear.getText().toString();
        AcademicsOneDegree = user_input_ac_three_degree.getText().toString();
        AcademicsOneUniversity = user_input_ac_three_university.getText().toString();
        AcademicsOnePercentage = user_input_ac_three_percentage.getText().toString();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_academics_three, container, false);

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
