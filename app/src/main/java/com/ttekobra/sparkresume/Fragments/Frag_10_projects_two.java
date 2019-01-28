package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_10_projects_two extends Fragment {

    EditText user_input_pr_two_title, user_input_pr_two_links, user_input_pr_two_desc;
    CardView user_input_pr_two_addmore;
    FloatingActionButton fab_pr_two;

    String projecttwoTitle;
    String projecttwoLinks;
    String projecttwoDescription;

    public void GetData() {
        projecttwoTitle = user_input_pr_two_title.getText().toString();
        projecttwoLinks = user_input_pr_two_links.getText().toString();
        projecttwoDescription = user_input_pr_two_desc.getText().toString();
        try {
            MainActivity.userDetails.put("projecttwoTitle", projecttwoTitle);
            MainActivity.userDetails.put("projecttwoLinks", projecttwoLinks);
            MainActivity.userDetails.put("projecttwoDescription", projecttwoDescription);
        } catch (Exception e) {

        }
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
                Frag_12_achievements achievements = new Frag_12_achievements();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, achievements);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        user_input_pr_two_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frag_11_projects_three projects_three = new Frag_11_projects_three();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, projects_three);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}