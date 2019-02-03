package com.ttekobra.sparkresume.WelcomeFragments;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ttekobra.sparkresume.R;

public class WelcomeFragOurTeamAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgid;
    private final String[] maindesc;

    public WelcomeFragOurTeamAdapter(Activity context, String[] maintitle, Integer[] imgid, String[] maindesc) {
        super(context, R.layout.wel_frag_our_team_list, maintitle);
        this.context = context;
        this.maintitle = maintitle;
        this.imgid = imgid;
        this.maindesc = maindesc;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.wel_frag_our_team_list, null, true);
        TextView titleText = rowView.findViewById(R.id.team_text_title);
        TextView titleDesc = rowView.findViewById(R.id.team_text_desc);
        ImageView imageView = rowView.findViewById(R.id.team_image_icon);
        titleText.setText(maintitle[position]);
        titleDesc.setText(maindesc[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;
    }
}
