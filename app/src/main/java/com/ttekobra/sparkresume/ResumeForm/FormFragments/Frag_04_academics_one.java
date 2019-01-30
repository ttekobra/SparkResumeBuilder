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
import com.ttekobra.sparkresume.PojoClasses.AcademicsDetails;
import com.ttekobra.sparkresume.R;

public class Frag_04_academics_one extends Fragment {

    public static EditText user_input_ac_one_duration, user_input_ac_one_degree, user_input_ac_one_university, user_input_ac_one_percentage;

    public static String AcademicsOneDuration, AcademicsOneDegree, AcademicsOneUniversity, AcademicsOnePercentage;

    public static void GetData() {
        AcademicsOneDuration = user_input_ac_one_duration.getText().toString();
        AcademicsOneDegree = user_input_ac_one_degree.getText().toString();
        AcademicsOneUniversity = user_input_ac_one_university.getText().toString();
        AcademicsOnePercentage = user_input_ac_one_percentage.getText().toString();

        AcademicsDetails academicsDetails = new AcademicsDetails(AcademicsOneDuration, AcademicsOneDegree, AcademicsOneUniversity, AcademicsOnePercentage);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("AcademicsDetailsOne").setValue(academicsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_04_academics_one, container, false);
        user_input_ac_one_duration = view.findViewById(R.id.user_input_ac_one_duration);
        user_input_ac_one_degree = view.findViewById(R.id.user_input_ac_one_degree);
        user_input_ac_one_university = view.findViewById(R.id.user_input_ac_one_university);
        user_input_ac_one_percentage = view.findViewById(R.id.user_input_ac_one_percentage);
        return view;
    }
}
