package com.ttekobra.sparkresume.ResumeForm.FormFragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.PojoClasses.PersonalDetails;
import com.ttekobra.sparkresume.R;

import java.util.Calendar;

public class Frag_02_personal_details extends Fragment {

    public static DatePickerDialog.OnDateSetListener dateSetListener;

    public static EditText user_input_profession, user_input_nationality, user_input_known_languages, user_input_hobbies;

    public static RadioGroup user_input_gender;
    public static RadioButton radioGenderButton;
    public static String profession, nationality, dateOfBirth = "01010001", sex, knownLanguages, hobbies;

    public static void GetData() {
        knownLanguages = user_input_known_languages.getText().toString();
        hobbies = user_input_hobbies.getText().toString();
        sex = radioGenderButton.getText().toString();
        profession = user_input_profession.getText().toString();
        nationality = user_input_nationality.getText().toString();

        PersonalDetails personalDetails = new PersonalDetails(profession, nationality, dateOfBirth, sex, hobbies, knownLanguages);

        FirebaseDatabase.getInstance().getReference("Users")
                .child(Frag_01_contact_details.MobileNumber)
                .child("PersonalDetails").setValue(personalDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_02_personal_details, container, false);
        user_input_profession = view.findViewById(R.id.user_input_profession);
        user_input_nationality = view.findViewById(R.id.user_input_nationality);
        user_input_gender = view.findViewById(R.id.user_input_gender);
        user_input_known_languages = view.findViewById(R.id.user_input_known_languages);
        user_input_hobbies = view.findViewById(R.id.user_input_hobbies);
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
                dialog.setCancelable(false);
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                year = year;

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

        return view;
    }
}
