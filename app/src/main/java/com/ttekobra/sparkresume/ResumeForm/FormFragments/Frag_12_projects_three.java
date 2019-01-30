package com.ttekobra.sparkresume.ResumeForm.FormFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;
import com.ttekobra.sparkresume.PojoClasses.ProjectsDetails;
import com.ttekobra.sparkresume.R;

public class Frag_12_projects_three extends Fragment {

    public static EditText user_input_pr_three_title, user_input_pr_three_links, user_input_pr_three_desc;

    public static String projectthreeTitle, projectthreeLinks, projectthreeDescription;

    public static void GetData() {
        projectthreeTitle = user_input_pr_three_title.getText().toString();
        projectthreeLinks = user_input_pr_three_links.getText().toString();
        projectthreeDescription = user_input_pr_three_desc.getText().toString();

        ProjectsDetails projectsDetails = new ProjectsDetails(projectthreeTitle, projectthreeLinks, projectthreeDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("ProjectsDetailsThree").setValue(projectsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_12_projects_three, container, false);

        user_input_pr_three_title = view.findViewById(R.id.user_input_pr_three_title);
        user_input_pr_three_links = view.findViewById(R.id.user_input_pr_three_links);
        user_input_pr_three_desc = view.findViewById(R.id.user_input_pr_three_desc);

        return view;
    }
}