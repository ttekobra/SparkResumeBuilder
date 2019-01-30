package com.ttekobra.sparkresume.SelectTemp.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ttekobra.sparkresume.R;

import java.io.FileInputStream;

public class SelTempFragThree extends Fragment {

    public static ImageView sel_temp_img03;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sel_temp_frag_three, container, false);
        sel_temp_img03 = view.findViewById(R.id.sel_temp_img03);
        sel_temp_img03.setImageBitmap(loadImageBitmap(getContext(), "imgThree"));
        return view;
    }

    public Bitmap loadImageBitmap(Context context, String imageName) {
        Bitmap bitmap = null;
        FileInputStream fiStream;
        try {
            fiStream = context.openFileInput(imageName);
            bitmap = BitmapFactory.decodeStream(fiStream);
            fiStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}