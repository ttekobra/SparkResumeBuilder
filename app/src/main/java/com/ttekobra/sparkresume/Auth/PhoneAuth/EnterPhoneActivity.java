package com.ttekobra.sparkresume.Auth.PhoneAuth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.ttekobra.sparkresume.R;

public class EnterPhoneActivity extends AppCompatActivity {

    EditText enter_phone_user_input_phone;
    Button enter_phone_process_button;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone);
        FirebaseApp.initializeApp(EnterPhoneActivity.this);

        spinner = findViewById(R.id.spinner);
        enter_phone_process_button = findViewById(R.id.enter_phone_process_button);
        enter_phone_user_input_phone = findViewById(R.id.enter_phone_user_input_phone);

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryCodeList.countryNames));

        enter_phone_process_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = CountryCodeList.countryAreaCodes[spinner.getSelectedItemPosition()] + enter_phone_user_input_phone.getText().toString();
                Intent intent = new Intent(EnterPhoneActivity.this, VerifyCodeActivity.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
            }
        });
    }
}
