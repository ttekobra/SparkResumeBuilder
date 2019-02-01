package com.ttekobra.sparkresume.Auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.accountkit.ui.ThemeUIManager;
import com.facebook.accountkit.ui.UIManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.ttekobra.sparkresume.R;
import com.ttekobra.sparkresume.WelcomeActivity;

import java.io.FileOutputStream;

public class LoginActivity extends AppCompatActivity {

    private static final int PHONE_SIGN_IN = 1;
    public static String user;
    FirebaseStorage storage;
    String DownloaedContent;
    StorageReference resume_one, resume_two, resume_three, resume_four, resume_five, resume_six;
    SharedPreferences prefs;

    ImageView wheel_img_01, wheel_img_02, wheel_img_03, wheel_img_04, wheel_img_05, wheel_img_06, wheel_img_07, wheel_img_08;
    ConstraintLayout wheel_main_layout;
    ConstraintLayout login_container;
    ImageView redirect_phone_button;
    Boolean toDownload = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        StartAnim();

        FirebaseApp.initializeApp(LoginActivity.this);
        storage = FirebaseStorage.getInstance();

        StorageReference storageRef = storage.getReference();

        resume_one = storageRef.child("resume_samples_png/resume_one.png");
        resume_two = storageRef.child("resume_samples_png/resume_two.png");
        resume_three = storageRef.child("resume_samples_png/resume_three.png");
        resume_four = storageRef.child("resume_samples_png/resume_four.png");
        resume_five = storageRef.child("resume_samples_png/resume_five.png");
        resume_six = storageRef.child("resume_samples_png/resume_six.png");

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        try {
            user = prefs.getString("userID", null);
            toDownload = prefs.getBoolean("downloaded", false);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        CountDownTimer timer = new CountDownTimer(6000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                final UIManager uiManager = new ThemeUIManager(R.style.LoginTheme);
                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    final Intent intent = new Intent(LoginActivity.this, AccountKitActivity.class);
                    AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                            new AccountKitConfiguration.AccountKitConfigurationBuilder(
                                    LoginType.PHONE,
                                    AccountKitActivity.ResponseType.CODE);
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
        }.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHONE_SIGN_IN) {
            AccountKitLoginResult loginResult = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            if (loginResult.wasCancelled()) {
                Toast.makeText(this, "Login Cancelled!", Toast.LENGTH_SHORT).show();
            } else {
                toDownload = prefs.getBoolean("downloaded", false);
                if (!toDownload) {
                    GetImages(resume_one, "imgOne");
                }
                user = loginResult.getAuthorizationCode();
                prefs.edit().putString("userID", user).apply();
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    public void GetImages(final StorageReference storageReference, final String filename) {
        long ONE_MEGABYTE = 1024 * 1024;
        storageReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                saveImage(getApplicationContext(), bitmap, filename);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(LoginActivity.this, "Content loading failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveImage(Context context, Bitmap b, String imageName) {
        FileOutputStream foStream;
        try {
            foStream = context.openFileOutput(imageName, Context.MODE_PRIVATE);
            b.compress(Bitmap.CompressFormat.PNG, 100, foStream);
            foStream.close();
            DownloaedContent = imageName;
            if (DownloaedContent.contentEquals("imgSix")) {
                prefs.edit().putBoolean("downloaded", true).apply();
            } else if (DownloaedContent.contentEquals("imgOne")) {
                GetImages(resume_two, "imgTwo");
            } else if (DownloaedContent.contentEquals("imgTwo")) {
                GetImages(resume_three, "imgThree");
            } else if (DownloaedContent.contentEquals("imgThree")) {
                GetImages(resume_four, "imgFour");
            } else if (DownloaedContent.contentEquals("imgFour")) {
                GetImages(resume_five, "imgFive");
            } else if (DownloaedContent.contentEquals("imgFive")) {
                GetImages(resume_six, "imgSix");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
