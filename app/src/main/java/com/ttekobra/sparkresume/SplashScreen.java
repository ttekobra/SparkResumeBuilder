package com.ttekobra.sparkresume;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.ttekobra.sparkresume.Auth.LoginActivity;
import com.ttekobra.sparkresume.SelectTemp.SelectTempListActivity;

import java.io.FileOutputStream;

public class SplashScreen extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth firebaseAuth;
    String userUID;
    FirebaseStorage storage;
    String DownloaedContent;
    StorageReference resume_one, resume_two, resume_three, resume_four, resume_five, resume_six;
    SharedPreferences prefs;
    Boolean toDownload = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        FirebaseApp.initializeApp(SplashScreen.this);
        storage = FirebaseStorage.getInstance();

        StorageReference storageRef = storage.getReference();

        resume_one = storageRef.child("resume_samples_png/resume_one.png");
        resume_two = storageRef.child("resume_samples_png/resume_two.png");
        resume_three = storageRef.child("resume_samples_png/resume_three.png");
        resume_four = storageRef.child("resume_samples_png/resume_four.png");
        resume_five = storageRef.child("resume_samples_png/resume_five.png");
        resume_six = storageRef.child("resume_samples_png/resume_six.png");

        firebaseAuth = FirebaseAuth.getInstance();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        toDownload = prefs.getBoolean("downloaded", false);
        if (!toDownload) {
            GetImages(resume_one, "imgOne");
        } else {
            CountDownTimer timer = new CountDownTimer(1500, 500) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    GoIntentActivity();
                }
            }.start();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void GoIntentActivity() {
        try {
            user = firebaseAuth.getCurrentUser();
            userUID = user.getUid();
            if (!userUID.isEmpty()) {
                Intent intent = new Intent(SplashScreen.this, SelectTempListActivity.class);
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
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
                Toast.makeText(SplashScreen.this, "Content loading failed", Toast.LENGTH_SHORT).show();
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
                GoIntentActivity();
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
}
