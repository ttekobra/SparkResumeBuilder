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

public class Frag_09_projects_one extends Fragment {

    EditText user_input_pr_one_title, user_input_pr_one_links, user_input_pr_one_desc;
    CardView user_input_pr_one_addmore;
    FloatingActionButton fab_pr_one;

    String projectOneTitle;
    String projectOneLinks;
    String projectOneDescription;

    public void GetData() {
        projectOneTitle = user_input_pr_one_title.getText().toString();
        projectOneLinks = user_input_pr_one_links.getText().toString();
        projectOneDescription = user_input_pr_one_desc.getText().toString();
        try {
            MainActivity.userDetails.put("projectOneTitle", projectOneTitle);
            MainActivity.userDetails.put("projectOneLinks", projectOneLinks);
            MainActivity.userDetails.put("projectOneDescription", projectOneDescription);
        } catch (Exception e) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_09_projects_one, container, false);
        MainActivity.toolbar.setTitle("Project One");
        MainActivity.frag_progress_bar.setProgress(9);
        user_input_pr_one_title = view.findViewById(R.id.user_input_pr_one_title);
        user_input_pr_one_links = view.findViewById(R.id.user_input_pr_one_links);
        user_input_pr_one_desc = view.findViewById(R.id.user_input_pr_one_desc);
        user_input_pr_one_addmore = view.findViewById(R.id.user_input_pr_one_addmore);
        fab_pr_one = view.findViewById(R.id.fab_pr_one);

        fab_pr_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_12_achievements achievements = new Frag_12_achievements();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, achievements);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        user_input_pr_one_addmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_10_projects_two projects_two = new Frag_10_projects_two();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, projects_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}