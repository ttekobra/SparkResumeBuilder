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

public class Frag_05_academics_two extends Fragment {

    public static EditText user_input_ac_two_duration, user_input_ac_two_degree, user_input_ac_two_university, user_input_ac_two_percentage;

    public static String AcademicsTwoDuration, AcademicsTwoDegree, AcademicsTwoUniversity, AcademicsTwoPercentage;

    public static void GetData() {
        AcademicsTwoDuration = user_input_ac_two_duration.getText().toString();
        AcademicsTwoDegree = user_input_ac_two_degree.getText().toString();
        AcademicsTwoUniversity = user_input_ac_two_university.getText().toString();
        AcademicsTwoPercentage = user_input_ac_two_percentage.getText().toString();

        AcademicsDetails academicsDetails = new AcademicsDetails(AcademicsTwoDuration, AcademicsTwoDegree, AcademicsTwoUniversity, AcademicsTwoPercentage);
        FirebaseDatabase.getInstance().getReference("Users")
                .child(Frag_01_contact_details.MobileNumber)
                .child("AcademicsDetailsTwo").setValue(academicsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_05_academics_two, container, false);
        user_input_ac_two_duration = view.findViewById(R.id.user_input_ac_two_duration);
        user_input_ac_two_degree = view.findViewById(R.id.user_input_ac_two_degree);
        user_input_ac_two_university = view.findViewById(R.id.user_input_ac_two_university);
        user_input_ac_two_percentage = view.findViewById(R.id.user_input_ac_two_percentage);

        return view;
    }
}
