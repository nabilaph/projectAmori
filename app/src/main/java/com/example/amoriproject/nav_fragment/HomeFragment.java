package com.example.amoriproject.nav_fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.amoriproject.R;
import com.example.amoriproject.ReviewByCategory;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment {

    // define variables
    CardView Makeup, Skincare, bodyCare, beautyTools;

    View myFragment;

    SharedPreferences sp;

    // define the name of shared preferences and key
    String SP_NAME = "mypref";
    String KEY_CATEGORY = "category";

    public HomeFragment (){

    }

    public static HomeFragment getInstance(){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_home, container, false);

        // find components by id according to the defined variable
        Makeup = myFragment.findViewById(R.id.Makeup);
        Skincare = myFragment.findViewById(R.id.Skincare);
        bodyCare = myFragment.findViewById(R.id.bodyCare);
        beautyTools = myFragment.findViewById(R.id.beautyTools);

        //get shared preferences
        sp = getContext().getSharedPreferences(SP_NAME, MODE_PRIVATE);

        //set on click listener make up category button
        Makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                String Category = "Make Up";
                editor.putString(KEY_CATEGORY, Category );
                editor.commit();
                Intent i = new Intent(getContext(), ReviewByCategory.class);
                startActivity(i);

            }
        });

        //set on click listener skincare category button
        Skincare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                String Category = "Skin Care";
                editor.putString(KEY_CATEGORY, Category );
                editor.commit();
                Intent i = new Intent(getContext(), ReviewByCategory.class);
                startActivity(i);

            }
        });

        //set on click listener body care category button
        bodyCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                String Category = "Body Care";
                editor.putString(KEY_CATEGORY, Category );
                editor.commit();
                Intent i = new Intent(getContext(), ReviewByCategory.class);
                startActivity(i);

            }
        });

        //set on click listener beauty tools category button
        beautyTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                String Category = "Beauty Tools";
                editor.putString(KEY_CATEGORY, Category );
                editor.commit();
                Intent i = new Intent(getContext(), ReviewByCategory.class);
                startActivity(i);

            }
        });

        return myFragment;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .detach(this)
                    .attach(this)
                    .commit();
        }
    }



}