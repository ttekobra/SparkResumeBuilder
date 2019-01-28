package com.ttekobra.sparkresume.Auth.PhoneAuth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

import java.util.concurrent.TimeUnit;

public class VerifyCodeActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    String codeSent;
    EditText enterVerificationCode;
    Button verifyButton;
    String phoneNumber;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            Toast.makeText(VerifyCodeActivity.this, "Working", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(VerifyCodeActivity.this, "Not Working", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        enterVerificationCode = findViewById(R.id.enterVerificationCode);
        verifyButton = findViewById(R.id.verify_button);

        FirebaseApp.initializeApp(VerifyCodeActivity.this);
        firebaseAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        phoneNumber = intent.getStringExtra("phoneNumber");

        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS, VerifyCodeActivity.this, mCallbacks);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_input = enterVerificationCode.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, user_input);
                signInWithPhoneAuthCredential(credential);
            }
        });
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = task.getResult().getUser();
                            Toast.makeText(VerifyCodeActivity.this, user.getPhoneNumber(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(VerifyCodeActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            }
                        }
                    }
                });
    }
}
