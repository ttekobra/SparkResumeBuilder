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

public class Frag_11_projects_two extends Fragment {

    public static EditText user_input_pr_two_title, user_input_pr_two_links, user_input_pr_two_desc;

    public static String projecttwoTitle, projecttwoLinks, projecttwoDescription;

    public static void GetData() {
        projecttwoTitle = user_input_pr_two_title.getText().toString();
        projecttwoLinks = user_input_pr_two_links.getText().toString();
        projecttwoDescription = user_input_pr_two_desc.getText().toString();

        ProjectsDetails projectsDetails = new ProjectsDetails(projecttwoTitle, projecttwoLinks, projecttwoDescription);
        FirebaseDatabase.getInstance().getReference("Users").child(Frag_01_contact_details.MobileNumber).child("ProjectsDetailsTwo").setValue(projectsDetails);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resume_form_11_projects_two, container, false);

        user_input_pr_two_title = view.findViewById(R.id.user_input_pr_two_title);
        user_input_pr_two_links = view.findViewById(R.id.user_input_pr_two_links);
        user_input_pr_two_desc = view.findViewById(R.id.user_input_pr_two_desc);

        return view;
    }
}