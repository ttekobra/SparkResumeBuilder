package com.ttekobra.sparkresume.Fragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.PersonalDetails;
import com.ttekobra.sparkresume.R;

import java.util.Calendar;

public class Frag_02_personal_details extends Fragment {

    String[] mStatus = {"Mariied", "Unmarried", "Don't wish to disclose"};
    DatePickerDialog.OnDateSetListener dateSetListener;

    TextInputEditText user_input_profession, user_input_nationality;
    Spinner user_input_marital_status;
    FloatingActionButton fab_personal_details;

    RadioGroup user_input_gender;
    RadioButton radioGenderButton;
    String profession;
    String nationality;
    String dateOfBirth;
    String sex;
    String maritalStatus;

    public void GetData() {
        sex = radioGenderButton.getText().toString();
        profession = user_input_profession.getText().toString();
        nationality = user_input_nationality.getText().toString();
        maritalStatus = mStatus[user_input_marital_status.getSelectedItemPosition()];

        PersonalDetails personalDetails = new PersonalDetails(profession, nationality, dateOfBirth, sex, maritalStatus);

        FirebaseDatabase.getInstance().getReference("Users")
                .child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName)
                .child("PersonalDetails").setValue(personalDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_02_personal_details, container, false);
        MainActivity.toolbar.setTitle("Personal Details");
        MainActivity.frag_progress_bar.setProgress(2);
        fab_personal_details = view.findViewById(R.id.fab_personal_details);
        user_input_profession = view.findViewById(R.id.user_input_profession);
        user_input_nationality = view.findViewById(R.id.user_input_nationality);
        user_input_marital_status = view.findViewById(R.id.user_input_marital_status);
        user_input_gender = view.findViewById(R.id.user_input_gender);
        final TextView date_view = view.findViewById(R.id.date_view);
        int selected_gender = user_input_gender.getCheckedRadioButtonId();
        radioGenderButton = view.findViewById(selected_gender);

        date_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String dd;
                String mm;
                String yyyy;
                if (dayOfMonth < 10) {
                    dd = ("0" + String.valueOf(dayOfMonth));
                } else dd = String.valueOf(dayOfMonth);
                if (month < 10) {
                    mm = "0" + String.valueOf(month);
                } else mm = String.valueOf(month);
                yyyy = String.valueOf(year);
                dateOfBirth = dd + mm + yyyy;
                date_view.setText(dd + "/" + mm + "/" + yyyy);
            }
        };

        user_input_marital_status.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, mStatus));

        fab_personal_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_03_academics_one academics_one = new Frag_03_academics_one();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, academics_one);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
