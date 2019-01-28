package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_11_projects_three extends Fragment {

    EditText user_input_pr_three_title, user_input_pr_three_links, user_input_pr_three_desc;
    FloatingActionButton fab_pr_three;

    String projectthreeTitle;
    String projectthreeLinks;
    String projectthreeDescription;

    public void GetData() {
        projectthreeTitle = user_input_pr_three_title.getText().toString();
        projectthreeLinks = user_input_pr_three_links.getText().toString();
        projectthreeDescription = user_input_pr_three_desc.getText().toString();
        try {
            MainActivity.userDetails.put("projectthreeTitle", projectthreeTitle);
            MainActivity.userDetails.put("projectthreeLinks", projectthreeLinks);
            MainActivity.userDetails.put("projectthreeDescription", projectthreeDescription);
        } catch (Exception e) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_11_projects_three, container, false);
        MainActivity.toolbar.setTitle("Project Three");
        MainActivity.frag_progress_bar.setProgress(11);

        user_input_pr_three_title = view.findViewById(R.id.user_input_pr_three_title);
        user_input_pr_three_links = view.findViewById(R.id.user_input_pr_three_links);
        user_input_pr_three_desc = view.findViewById(R.id.user_input_pr_three_desc);
        fab_pr_three = view.findViewById(R.id.fab_pr_three);

        fab_pr_three.setOnClickListener(new View.OnClickListener() {
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

        return view;
    }
}