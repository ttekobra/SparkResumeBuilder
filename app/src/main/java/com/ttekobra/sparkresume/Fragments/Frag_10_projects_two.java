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
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.PojoClasses.ProjectsDetails;
import com.ttekobra.sparkresume.R;

public class Frag_10_projects_two extends Fragment {

    TextInputEditText user_input_pr_two_title, user_input_pr_two_links, user_input_pr_two_desc;
    TextView user_input_pr_two_addmore;
    FloatingActionButton fab_pr_two;

    String projecttwoTitle;
    String projecttwoLinks;
    String projecttwoDescription;

    public void GetData() {
        projecttwoTitle = user_input_pr_two_title.getText().toString();
        projecttwoLinks = user_input_pr_two_links.getText().toString();
        projecttwoDescription = user_input_pr_two_desc.getText().toString();

        ProjectsDetails projectsDetails = new ProjectsDetails(projecttwoTitle, projecttwoLinks, projecttwoDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.FirstName + Frag_01_contact_details.MobileNumber + Frag_01_contact_details.LastName).child("ProjectsDetailsTwo").setValue(projectsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_10_projects_two, container, false);
        MainActivity.toolbar.setTitle("Project Two");
        MainActivity.frag_progress_bar.setProgress(10);

        user_input_pr_two_title = view.findViewById(R.id.user_input_pr_two_title);
        user_input_pr_two_links = view.findViewById(R.id.user_input_pr_two_links);
        user_input_pr_two_desc = view.findViewById(R.id.user_input_pr_two_desc);
        user_input_pr_two_addmore = view.findViewById(R.id.user_input_pr_two_addmore);
        fab_pr_two = view.findViewById(R.id.fab_pr_two);

        fab_pr_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_12_achievements achievements = new Frag_12_achievements();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, achievements);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        user_input_pr_two_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_11_projects_three projects_three = new Frag_11_projects_three();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.animation_in, R.anim.animation_out);
                fragmentTransaction.replace(R.id.main_frag_container, projects_three);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}