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

public class Frag_06_academics_three extends Fragment {

    public static EditText user_input_ac_three_duration, user_input_ac_three_degree, user_input_ac_three_university, user_input_ac_three_percentage;

    public static String AcademicsThreeDuration, AcademicsThreeDegree, AcademicsThreeUniversity, AcademicsThreePercentage;

    public static void GetData() {
        AcademicsThreeDuration = user_input_ac_three_duration.getText().toString();
        AcademicsThreeDegree = user_input_ac_three_degree.getText().toString();
        AcademicsThreeUniversity = user_input_ac_three_university.getText().toString();
        AcademicsThreePercentage = user_input_ac_three_percentage.getText().toString();

        AcademicsDetails academicsDetails = new AcademicsDetails(AcademicsThreeDuration, AcademicsThreeDegree, AcademicsThreeUniversity, AcademicsThreePercentage);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("AcademicsDetailsThree").setValue(academicsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_06_academics_three, container, false);
        user_input_ac_three_duration = view.findViewById(R.id.user_input_ac_three_duration);
        user_input_ac_three_degree = view.findViewById(R.id.user_input_ac_three_degree);
        user_input_ac_three_university = view.findViewById(R.id.user_input_ac_three_university);
        user_input_ac_three_percentage = view.findViewById(R.id.user_input_ac_three_percentage);

        return view;
    }
}
