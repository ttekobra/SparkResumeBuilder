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

public class Frag_04_academics_two extends Fragment {

    TextInputEditText user_input_ac_two_startyear, user_input_ac_two_endyear, user_input_ac_two_degree, user_input_ac_two_university, user_input_ac_two_percentage;
    TextView user_input_ac_two_addmore;
    FloatingActionButton fab_academics_two;

    String AcademicsTwoStart;
    String AcademicsTwoEnd;
    String AcademicsTwoDegree;
    String AcademicsTwoUniversity;
    String AcademicsTwoPercentage;

    public void GetData() {
        AcademicsTwoStart = user_input_ac_two_startyear.getText().toString();
        AcademicsTwoEnd = user_input_ac_two_endyear.getText().toString();
        AcademicsTwoDegree = user_input_ac_two_degree.getText().toString();
        AcademicsTwoUniversity = user_input_ac_two_university.getText().toString();
        AcademicsTwoPercentage = user_input_ac_two_percentage.getText().toString();

        AcademicsDetails academicsDetails = new AcademicsDetails(AcademicsTwoStart, AcademicsTwoEnd, AcademicsTwoDegree, AcademicsTwoUniversity, AcademicsTwoPercentage);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName).child("AcademicsDetailsTwo").setValue(academicsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_04_academics_two, container, false);
        MainActivity.toolbar.setTitle("Academics Two");
        MainActivity.frag_progress_bar.setProgress(4);
        user_input_ac_two_startyear = view.findViewById(R.id.user_input_ac_two_startyear);
        user_input_ac_two_endyear = view.findViewById(R.id.user_input_ac_two_endyear);
        user_input_ac_two_degree = view.findViewById(R.id.user_input_ac_two_degree);
        user_input_ac_two_university = view.findViewById(R.id.user_input_ac_two_university);
        user_input_ac_two_percentage = view.findViewById(R.id.user_input_ac_two_percentage);
        user_input_ac_two_addmore = view.findViewById(R.id.user_input_ac_two_addmore);
        fab_academics_two = view.findViewById(R.id.fab_academics_two);

        user_input_ac_two_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_05_academics_three frag_academics_three = new Frag_05_academics_three();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, frag_academics_three);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        fab_academics_two.setOnClickListener(new View.OnClickListener() {
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
