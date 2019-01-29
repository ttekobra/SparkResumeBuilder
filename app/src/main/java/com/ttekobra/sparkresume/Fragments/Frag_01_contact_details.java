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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.Auth.PhoneAuth.CountryCodeList;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.ContactDetails;
import com.ttekobra.sparkresume.R;

public class Frag_01_contact_details extends Fragment {

    FloatingActionButton fab_contach_details;
    Spinner user_input_country_code;
    public static String FirstName;
    public static String LastName;
    public static String MobileNumber;
    TextInputEditText user_input_firstname, user_input_lastname, user_input_mobile, user_input_email, user_input_residential_address;
    String Email;
    String ResidentialAddress;
    ContactDetails contactDetails;

    public void GetData() {
        FirstName = user_input_firstname.getText().toString();
        LastName = user_input_lastname.getText().toString();
        MobileNumber = CountryCodeList.countryAreaCodes[user_input_country_code.getSelectedItemPosition()] + user_input_mobile.getText().toString();
        Email = user_input_email.getText().toString();
        ResidentialAddress = user_input_residential_address.getText().toString();

        contactDetails = new ContactDetails(FirstName, LastName, MobileNumber, Email, ResidentialAddress);

        FirebaseDatabase.getInstance().getReference("Users")
                .child(FirstName + MobileNumber + LastName)
                .child("ContactDetails").setValue(contactDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_01_contact_details, container, false);
        MainActivity.toolbar.setTitle("Contact Details");
        MainActivity.frag_progress_bar.setProgress(1);
        fab_contach_details = view.findViewById(R.id.fab_contach_details);
        user_input_country_code = view.findViewById(R.id.user_input_country_code);
        user_input_firstname = view.findViewById(R.id.user_input_firstname);
        user_input_lastname = view.findViewById(R.id.user_input_lastname);
        user_input_mobile = view.findViewById(R.id.user_input_mobile);
        user_input_email = view.findViewById(R.id.user_input_email);
        user_input_residential_address = view.findViewById(R.id.user_input_residential_address);

        user_input_country_code.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, CountryCodeList.countryNames));

        fab_contach_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_02_personal_details personal_details = new Frag_02_personal_details();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, personal_details);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
