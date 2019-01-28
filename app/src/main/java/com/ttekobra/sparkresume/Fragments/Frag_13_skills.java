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
import android.widget.SeekBar;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_13_skills extends Fragment {

    EditText user_input_skill_title_one, user_input_skill_desc_one, user_input_skill_title_two, user_input_skill_desc_two,
            user_input_skill_title_three, user_input_skill_desc_three, user_input_skill_title_four, user_input_skill_desc_four;

    SeekBar user_input_skill_level_one, user_input_skill_level_two, user_input_skill_level_three, user_input_skill_level_four;

    CardView layout_skill_one, layout_skill_two, layout_skill_three, layout_skill_four, skill_addbutton;

    FloatingActionButton fab_skills_frag;

    String skillTitleOne;
    String skillTitleTwo;
    String skillTitleThree;
    String skillTitleFour;
    String skillDescOne;
    String skillDescTwo;
    String skillDescThree;
    String skillDescFour;
    String skillRatingOne;
    String skillRatingTwo;
    String skillRatingThree;
    String skillRatingFour;

    public void GetData() {
        skillTitleOne = user_input_skill_title_one.getText().toString();
        skillTitleTwo = user_input_skill_title_two.getText().toString();
        skillTitleThree = user_input_skill_title_three.getText().toString();
        skillTitleFour = user_input_skill_title_four.getText().toString();
        skillDescOne = user_input_skill_desc_one.getText().toString();
        skillDescTwo = user_input_skill_desc_two.getText().toString();
        skillDescThree = user_input_skill_desc_three.getText().toString();
        skillDescFour = user_input_skill_desc_four.getText().toString();


        try {
            MainActivity.userDetails.put("skillTitleOne", skillTitleOne);
            MainActivity.userDetails.put("skillTitleTwo", skillTitleTwo);
            MainActivity.userDetails.put("skillTitleThree", skillTitleThree);
            MainActivity.userDetails.put("skillTitleFour", skillTitleFour);
            MainActivity.userDetails.put("skillDescOne", skillDescOne);
            MainActivity.userDetails.put("skillDescTwo", skillDescTwo);
            MainActivity.userDetails.put("skillDescThree", skillDescThree);
            MainActivity.userDetails.put("skillDescFour", skillDescFour);
            MainActivity.userDetails.put("skillRatingOne", skillRatingOne);
            MainActivity.userDetails.put("skillRatingTwo", skillRatingTwo);
            MainActivity.userDetails.put("skillRatingThree", skillRatingThree);
            MainActivity.userDetails.put("skillRatingFour", skillRatingFour);
        } catch (Exception e) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_13_skills, container, false);
        MainActivity.toolbar.setTitle("Enter Skills");
        MainActivity.frag_progress_bar.setProgress(13);

        fab_skills_frag = view.findViewById(R.id.fab_skills_frag);
        skill_addbutton = view.findViewById(R.id.skill_addbutton);
        layout_skill_four = view.findViewById(R.id.layout_skill_four);
        layout_skill_three = view.findViewById(R.id.layout_skill_three);
        layout_skill_two = view.findViewById(R.id.layout_skill_two);
        layout_skill_one = view.findViewById(R.id.layout_skill_one);
        user_input_skill_title_one = view.findViewById(R.id.user_input_skill_title_one);
        user_input_skill_desc_one = view.findViewById(R.id.user_input_skill_desc_one);
        user_input_skill_title_two = view.findViewById(R.id.user_input_skill_title_two);
        user_input_skill_desc_two = view.findViewById(R.id.user_input_skill_desc_two);
        user_input_skill_title_three = view.findViewById(R.id.user_input_skill_title_three);
        user_input_skill_desc_three = view.findViewById(R.id.user_input_skill_desc_three);
        user_input_skill_title_four = view.findViewById(R.id.user_input_skill_title_four);
        user_input_skill_desc_four = view.findViewById(R.id.user_input_skill_desc_four);
        user_input_skill_level_one = view.findViewById(R.id.user_input_skill_level_one);
        user_input_skill_level_two = view.findViewById(R.id.user_input_skill_level_two);
        user_input_skill_level_three = view.findViewById(R.id.user_input_skill_level_three);
        user_input_skill_level_four = view.findViewById(R.id.user_input_skill_level_four);

        user_input_skill_level_one.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skillRatingOne = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        user_input_skill_level_two.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skillRatingTwo = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        user_input_skill_level_three.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skillRatingThree = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        user_input_skill_level_four.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skillRatingFour = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        skill_addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skill_addbutton.setVisibility(View.GONE);
                layout_skill_one.setVisibility(View.VISIBLE);
                layout_skill_two.setVisibility(View.VISIBLE);
                layout_skill_three.setVisibility(View.VISIBLE);
                layout_skill_four.setVisibility(View.VISIBLE);
            }
        });

        fab_skills_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Frag_14_extra_details extra_details = new Frag_14_extra_details();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frag_container, extra_details);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}