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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_personal_details extends Fragment {

    String[] dd = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] mm = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] yyyy = {"1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017"};
    String[] mStatus = {"Mariied", "Unmarried", "Don't wish to disclose"};

    EditText user_input_profession, user_input_nationality;
    Spinner user_input_dob_dd, user_input_dob_mm, user_input_dob_yyyy, user_input_marital_status;
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
        dateOfBirth = (dd[user_input_dob_dd.getSelectedItemPosition()] +
                mm[user_input_dob_mm.getSelectedItemPosition()] +
                yyyy[user_input_dob_yyyy.getSelectedItemPosition()]);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_personal_details, container, false);
        fab_personal_details = view.findViewById(R.id.fab_personal_details);
        user_input_profession = view.findViewById(R.id.user_input_profession);
        user_input_nationality = view.findViewById(R.id.user_input_nationality);
        user_input_dob_dd = view.findViewById(R.id.user_input_dob_dd);
        user_input_dob_mm = view.findViewById(R.id.user_input_dob_mm);
        user_input_dob_yyyy = view.findViewById(R.id.user_input_dob_yyyy);
        user_input_marital_status = view.findViewById(R.id.user_input_marital_status);
        user_input_gender = view.findViewById(R.id.user_input_gender);
        int selected_gender = user_input_gender.getCheckedRadioButtonId();
        radioGenderButton = view.findViewById(selected_gender);

        user_input_dob_dd.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, dd));
        user_input_dob_mm.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, months));
        user_input_dob_yyyy.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, yyyy));
        user_input_marital_status.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, mStatus));

        fab_personal_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                MainActivity.frag_progress_bar.setProgress(3);
                Frag_academics_one academics_one = new Frag_academics_one();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, academics_one);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
