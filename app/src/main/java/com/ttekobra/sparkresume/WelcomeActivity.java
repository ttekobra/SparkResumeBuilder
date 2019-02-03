package com.ttekobra.sparkresume;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.facebook.accountkit.AccountKit;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragAboutUs;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragContactUs;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragDonation;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragFAQs;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragHome;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragOurTeam;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragPastResume;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragPrivacyPolicy;
import com.ttekobra.sparkresume.WelcomeFragments.WelFragTermsConditions;

public class WelcomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment = null;
    Toolbar toolbar;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        toolbar = findViewById(R.id.terms_conditions_toolbar);
        setSupportActionBar(toolbar);

        fragment = new WelFragHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setMessage("Do you want to Exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user pressed "yes", then he is allowed to exit from application
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user select "No", just cancel this dialog and continue with app
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.privacy_policy){
            fragment = new WelFragPrivacyPolicy();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Privacy Policy");
        }
        else if (id == R.id.home_page){
            fragment = new WelFragHome();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Home");
        }
        else if (id == R.id.terms_conditions){
            fragment = new WelFragTermsConditions();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Terms of use");
        }
        else if (id == R.id.past_resume){
            fragment = new WelFragPastResume();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Previous build");
        }
        else if (id == R.id.faq){
            fragment = new WelFragFAQs();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("FAQs");
        }
        else if (id == R.id.aboutus){
            fragment = new WelFragAboutUs();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("About us");
        }
        else if (id == R.id.our_team){
            fragment = new WelFragOurTeam();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Our Team");
        }
        else if (id == R.id.donation){
            fragment = new WelFragDonation();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Donation");
        }
        else if (id == R.id.logout){
            AccountKit.logOut();
            prefs.edit().putString("userID", null).apply();
            finish();
        }
        else if (id == R.id.contact_us){
            fragment = new WelFragContactUs();
            getSupportFragmentManager().beginTransaction().replace(R.id.welcome_frag_container, fragment).commit();
            toolbar.setTitle("Contact us");
        }
        else if (id == R.id.share_app){

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
