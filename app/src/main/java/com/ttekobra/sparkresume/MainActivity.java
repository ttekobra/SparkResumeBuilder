package com.ttekobra.sparkresume;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.google.firebase.FirebaseApp;
import com.ttekobra.sparkresume.Fragments.Frag_01_contact_details;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static ProgressBar frag_progress_bar;
    public static ConstraintLayout main_frag_container;
    Fragment fragment = null;
    public static Toolbar toolbar;

    public static JSONObject userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome");
        setSupportActionBar(toolbar);


        FirebaseApp.initializeApp(MainActivity.this);

        frag_progress_bar = findViewById(R.id.frag_progress_bar);
        main_frag_container = findViewById(R.id.main_frag_container);

        userDetails = new JSONObject();

        fragment = new Frag_01_contact_details();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frag_container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings_frag) {
           /* fragment = new FragmentSettings();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frag_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();*/
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
