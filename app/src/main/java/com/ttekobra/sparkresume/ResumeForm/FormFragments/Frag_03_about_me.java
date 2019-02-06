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
import com.ttekobra.sparkresume.PojoClasses.AboutMe;
import com.ttekobra.sparkresume.R;

import static com.ttekobra.sparkresume.ResumeForm.FormFragments.Frag_01_contact_details.MobileNumber;

public class Frag_03_about_me extends Fragment {

    public static EditText user_input_about_me;
    public static String about_me;

    public static void GetData() {
        about_me = user_input_about_me.getText().toString();
        AboutMe about = new AboutMe(about_me);
        FirebaseDatabase.getInstance().getReference("Users")
                .child(MobileNumber)
                .child("AboutMe").setValue(about);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_03_about_me, container, false);
        user_input_about_me = view.findViewById(R.id.user_input_about_me);
        return view;
    }
}