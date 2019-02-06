package com.ttekobra.sparkresume.WelcomeFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.ttekobra.sparkresume.R;

public class WelFragOurTeam extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wel_frag_our_team, container, false);
        WebView wel_frag_team_webview = view.findViewById(R.id.wel_frag_team_webview);
        wel_frag_team_webview.loadUrl("http://www.spark.ttekobra.com/android/team");
        return view;
    }
}
