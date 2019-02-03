package com.ttekobra.sparkresume.ResumeForm.FormFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.PojoClasses.ContactDetails;
import com.ttekobra.sparkresume.R;

public class Frag_01_contact_details extends Fragment {

    public static String FullName;
    public static String MobileNumber;
    public static EditText user_input_fullname, user_input_mobile, user_input_email, user_input_residential_address;
    static String Email;
    static String ResidentialAddress;
    static ContactDetails contactDetails;

    public static void GetData() {
        FullName = user_input_fullname.getText().toString();
        MobileNumber = user_input_mobile.getText().toString();
        Email = user_input_email.getText().toString();
        ResidentialAddress = user_input_residential_address.getText().toString();

        contactDetails = new ContactDetails(FullName, MobileNumber, Email, ResidentialAddress);
        FirebaseDatabase.getInstance().getReference("Users")
                .child(MobileNumber)
                .child("ContactDetails").setValue(contactDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_01_contact_details, container, false);
        user_input_fullname = view.findViewById(R.id.user_input_fullname);
        user_input_mobile = view.findViewById(R.id.user_input_mobile);
        user_input_email = view.findViewById(R.id.user_input_email);
        user_input_residential_address = view.findViewById(R.id.user_input_residential_address);
        return view;
    }
}
