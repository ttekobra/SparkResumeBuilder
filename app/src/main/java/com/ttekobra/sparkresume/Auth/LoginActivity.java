package com.ttekobra.sparkresume.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.accountkit.AccessToken;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.accountkit.ui.ThemeUIManager;
import com.facebook.accountkit.ui.UIManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.ttekobra.sparkresume.R;
import com.ttekobra.sparkresume.SelectTemp.SelectTempListActivity;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1;
    private static final int PHONE_SIGN_IN = 2;

    ImageView wheel_img_01, wheel_img_02, wheel_img_03, wheel_img_04, wheel_img_05, wheel_img_06, wheel_img_07, wheel_img_08;
    ConstraintLayout wheel_main_layout;
    CountDownTimer timer;
    ConstraintLayout login_container;

    ImageView google_login_button;
    ImageView redirect_phone_button;

    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;

    private FirebaseAuth mAuth;

    Long max = 5000000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(LoginActivity.this);
        google_login_button = findViewById(R.id.google_login_button);
        redirect_phone_button = findViewById(R.id.redirect_phone_button);
        login_container = findViewById(R.id.login_container);

        wheel_main_layout = findViewById(R.id.wheel_main_layout);
        wheel_img_01 = findViewById(R.id.wheel_img_01);
        wheel_img_02 = findViewById(R.id.wheel_img_02);
        wheel_img_03 = findViewById(R.id.wheel_img_03);
        wheel_img_04 = findViewById(R.id.wheel_img_04);
        wheel_img_05 = findViewById(R.id.wheel_img_05);
        wheel_img_06 = findViewById(R.id.wheel_img_06);
        wheel_img_07 = findViewById(R.id.wheel_img_07);
        wheel_img_08 = findViewById(R.id.wheel_img_08);

        int widthForContainer;
        widthForContainer = login_container.getMaxWidth() - 32;
        wheel_main_layout.setMinHeight(widthForContainer);
        wheel_main_layout.setMaxHeight(widthForContainer);
        wheel_main_layout.setMaxWidth(widthForContainer);
        wheel_main_layout.setMinWidth(widthForContainer);

        timer = new CountDownTimer(max, 24000) {
            @Override
            public void onTick(long millisUntilFinished) {
                StartAnim();
            }

            @Override
            public void onFinish() {
            }
        }.start();

        final AccessToken accessToken = AccountKit.getCurrentAccessToken();

        FirebaseApp.initializeApp(LoginActivity.this);
        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("363347623237-42dsphacv9i30os4md028tokr2ki23bi.apps.googleusercontent.com")
                .requestEmail()
                .build();

        final UIManager uiManager = new ThemeUIManager(R.style.LoginTheme);

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        redirect_phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                if (accessToken != null) {
                    //Toast.makeText(this, "Welcome back bro", Toast.LENGTH_SHORT).show();
                    //Handle Returning User
                } else {
                    final Intent intent = new Intent(LoginActivity.this, AccountKitActivity.class);
                    AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                            new AccountKitConfiguration.AccountKitConfigurationBuilder(
                                    LoginType.PHONE,
                                    AccountKitActivity.ResponseType.CODE); // or .ResponseType.TOKEN
                    // ... perform additional configuration ...
                    configurationBuilder.setReceiveSMS(true);
                    configurationBuilder.setReadPhoneStateEnabled(true);
                    configurationBuilder.setVoiceCallbackNotificationsEnabled(true);
                    configurationBuilder.setUIManager(uiManager);

                    intent.putExtra(
                            AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                            configurationBuilder.build());
                    startActivityForResult(intent, PHONE_SIGN_IN);
                }
            }
        });
        google_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                GoogleSignIn();
            }
        });
    }

    private void GoogleSignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
            }
        } else if (requestCode == PHONE_SIGN_IN) { // confirm that this response matches your request
            AccountKitLoginResult loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            String toastMessage;
            if (loginResult.getError() != null) {
                toastMessage = loginResult.getError().getErrorType().getMessage();
                //showErrorActivity(loginResult.getError());
            } else if (loginResult.wasCancelled()) {
                toastMessage = "Login Cancelled";
            } else {
                if (loginResult.getAccessToken() != null) {
                    toastMessage = "Success:" + loginResult.getAccessToken().getAccountId();
                } else {
                    toastMessage = String.format(
                            "Success:%s...",
                            loginResult.getAuthorizationCode().substring(0, 10));
                }

                // If you have an authorization code, retrieve it from
                // loginResult.getAuthorizationCode()
                // and pass it to your server and exchange it for an access token.
                Intent intent = new Intent(this, SelectTempListActivity.class);
                startActivity(intent);
                finish();
                // Success! Start your next activity...
                Toast.makeText(this, "Yeah it's working bro", Toast.LENGTH_SHORT).show();
            }

            // Surface the result to your user in an appropriate way.
            Toast.makeText(
                    this,
                    toastMessage,
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, SelectTempListActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void StartAnim() {
        Animation clockWise = AnimationUtils.loadAnimation(this, R.anim.clockwise);
        Animation anti_clockwise = AnimationUtils.loadAnimation(this, R.anim.anti_clockwise);
        wheel_main_layout.setAnimation(clockWise);
        wheel_img_01.setAnimation(anti_clockwise);
        wheel_img_02.setAnimation(anti_clockwise);
        wheel_img_03.setAnimation(anti_clockwise);
        wheel_img_04.setAnimation(anti_clockwise);
        wheel_img_05.setAnimation(anti_clockwise);
        wheel_img_06.setAnimation(anti_clockwise);
        wheel_img_07.setAnimation(anti_clockwise);
        wheel_img_08.setAnimation(anti_clockwise);
    }
}
