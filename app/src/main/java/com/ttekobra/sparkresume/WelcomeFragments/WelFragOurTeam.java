package com.ttekobra.sparkresume.WelcomeFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ttekobra.sparkresume.R;

public class WelFragOurTeam extends Fragment {

    ListView wel_frag_our_team_listview;
    String[] mainTitle = {"Suprem Nandal", "Vikram Modh", "Bir Singh", "Sahil Khan", "Chirag", "Jeyavignesh", "Sourav"};
    String[] mainDesc = {"dhsjkdhjfhsjdfh","dhsjkdhjfhsjdfh","dhsjkdhjfhsjdfh","dhsjkdhjfhsjdfh","dhsjkdhjfhsjdfh","dhsjkdhjfhsjdfh","dhsjkdhjfhsjdfh"};
    Integer[] imgid = {R.drawable.team_suprem, R.drawable.team_vikram, R.drawable.team_bir, R.drawable.team_sahil, R.drawable.team_chirag, R.drawable.team_jv, R.drawable.team_sourav};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wel_frag_our_team, container, false);
        wel_frag_our_team_listview = view.findViewById(R.id.wel_frag_our_team_listview);

        WelcomeFragOurTeamAdapter adapter = new WelcomeFragOurTeamAdapter(getActivity(), mainTitle, imgid, mainDesc);
        wel_frag_our_team_listview.setAdapter(adapter);
        return view;
    }
}
