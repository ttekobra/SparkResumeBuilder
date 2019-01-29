package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.AcademicsDetails;
import com.ttekobra.sparkresume.R;

public class Frag_03_academics_one extends Fragment {

    TextInputEditText user_input_ac_one_startyear, user_input_ac_one_endyear, user_input_ac_one_degree, user_input_ac_one_university, user_input_ac_one_percentage;
    TextView user_input_ac_one_addmore;
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

        AcademicsDetails academicsDetails = new AcademicsDetails(AcademicsOneStart, AcademicsOneEnd, AcademicsOneDegree, AcademicsOneUniversity, AcademicsOnePercentage);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName).child("AcademicsDetailsOne").setValue(academicsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_03_academics_one, container, false);
        MainActivity.toolbar.setTitle("Academics One");
        MainActivity.frag_progress_bar.setProgress(3);
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
                Frag_04_academics_two frag_academics_two = new Frag_04_academics_two();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, frag_academics_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        fab_academics_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_06_experience_one frag_experience_one = new Frag_06_experience_one();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, frag_experience_one);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
