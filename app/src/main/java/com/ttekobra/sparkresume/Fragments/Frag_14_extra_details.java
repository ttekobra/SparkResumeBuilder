package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.ExtraDetails;
import com.ttekobra.sparkresume.R;

public class Frag_14_extra_details extends Fragment {

    TextInputEditText user_input_ex_known_languages, user_input_ex_int_title_one, user_input_ex_int_dec_one,
            user_input_ex_act_title_one, user_input_ex_act_desc_one;

    FloatingActionButton fab_sumbit;

    String knownLanguages;
    String interestTitle;
    String interestDescription;
    String extraActivityTitle;
    String extraActivityDescription;

    public void GetData() {
        knownLanguages = user_input_ex_known_languages.getText().toString();
        interestTitle = user_input_ex_int_title_one.getText().toString();
        interestDescription = user_input_ex_int_dec_one.getText().toString();
        extraActivityTitle = user_input_ex_act_title_one.getText().toString();
        extraActivityDescription = user_input_ex_act_desc_one.getText().toString();

        ExtraDetails extraDetails = new ExtraDetails(knownLanguages, interestTitle, interestDescription, extraActivityTitle, extraActivityDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName)
                .child("ExtraDetails").setValue(extraDetails)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getActivity(), "Yeah it's workin bro", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_14_extra_details, container, false);
        MainActivity.toolbar.setTitle("Additional Details");
        MainActivity.frag_progress_bar.setProgress(14);

        user_input_ex_known_languages = view.findViewById(R.id.user_input_ex_known_languages);
        user_input_ex_int_title_one = view.findViewById(R.id.user_input_ex_int_title_one);
        user_input_ex_int_dec_one = view.findViewById(R.id.user_input_ex_int_dec_one);
        user_input_ex_act_title_one = view.findViewById(R.id.user_input_ex_act_title_one);
        user_input_ex_act_desc_one = view.findViewById(R.id.user_input_ex_act_desc_one);
        fab_sumbit = view.findViewById(R.id.fab_sumbit);

        fab_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
            }
        });
        return view;
    }
}