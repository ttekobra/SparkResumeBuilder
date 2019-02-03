package com.ttekobra.sparkresume;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeGridViewAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgid;

    public WelcomeGridViewAdapter(Activity context, String[] maintitle, Integer[] imgid) {
        super(context, R.layout.welcome_gridview, maintitle);
        this.context = context;
        this.maintitle = maintitle;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.welcome_gridview, null, true);
        TextView titleText = rowView.findViewById(R.id.welcome_grid_title);
        ImageView imageView = rowView.findViewById(R.id.welcome_grid_icon);
        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;
    }
}