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

public class Frag_10_projects_one extends Fragment {

    public static EditText user_input_pr_one_title, user_input_pr_one_links, user_input_pr_one_desc;

    public static String projectOneTitle, projectOneLinks, projectOneDescription;

    public static void GetData() {
        projectOneTitle = user_input_pr_one_title.getText().toString();
        projectOneLinks = user_input_pr_one_links.getText().toString();
        projectOneDescription = user_input_pr_one_desc.getText().toString();

        ProjectsDetails projectsDetails = new ProjectsDetails(projectOneTitle, projectOneLinks, projectOneDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("ProjectsDetailsOne").setValue(projectsDetails);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_10_projects_one, container, false);
        user_input_pr_one_title = view.findViewById(R.id.user_input_pr_one_title);
        user_input_pr_one_links = view.findViewById(R.id.user_input_pr_one_links);
        user_input_pr_one_desc = view.findViewById(R.id.user_input_pr_one_desc);

        return view;
    }
}