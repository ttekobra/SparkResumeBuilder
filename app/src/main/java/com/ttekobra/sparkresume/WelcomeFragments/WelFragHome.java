package com.ttekobra.sparkresume.WelcomeFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.ttekobra.sparkresume.R;
import com.ttekobra.sparkresume.SelectTemp.SelectTempListActivity;
import com.ttekobra.sparkresume.WelcomeGridViewAdapter;

public class WelFragHome extends Fragment {

    TextView welcome_letscreate_btn;

    String[] gridTitles = {"BPO", "DOCTOR", "ENGINEER", "GRAPHIC DESIGNER", "PROGRAMMER", "OTHERS"};
    Integer[] gridIcons = {R.drawable.ic_welcome_bpo,R.drawable.ic_welcome_doctor,R.drawable.ic_welcome_engineer,
            R.drawable.ic_welcome_graphics_design, R.drawable.ic_welcome_programmer, R.drawable.ic_welcome_other};


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wel_frag_home, container, false);

        final GridView gridView = view.findViewById(R.id.welcome_gridview);
        welcome_letscreate_btn = view.findViewById(R.id.welcome_letscreate_btn);

        WelcomeGridViewAdapter adapter = new WelcomeGridViewAdapter(getActivity(), gridTitles, gridIcons);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected_item = gridView.getItemAtPosition(position).toString();
                Intent intent = new Intent(getActivity(), SelectTempListActivity.class);
                startActivity(intent);
            }
        });

        welcome_letscreate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SelectTempListActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
