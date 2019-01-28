package com.ttekobra.sparkresume.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttekobra.sparkresume.MainActivity;
import com.ttekobra.sparkresume.R;

public class Frag_14_extra_details extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag_14_extra_details, container, false);
        MainActivity.toolbar.setTitle("Additional Details");
        MainActivity.frag_progress_bar.setProgress(14);
        return view;
    }
}