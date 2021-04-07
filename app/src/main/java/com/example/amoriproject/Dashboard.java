package com.example.amoriproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.amoriproject.nav_fragment.FeedFragment;
import com.example.amoriproject.nav_fragment.HomeFragment;
import com.example.amoriproject.nav_fragment.ProfileFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Dashboard extends AppCompatActivity {

    // define variables
    private ChipNavigationBar chipnav;
    private Fragment fragment = null;

    String SP_NAME = "mypref";
    SharedPreferences sp;

    ImageView addReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences(SP_NAME, MODE_PRIVATE);

        String isDetail = sp.getString("isDetail", null);

        // find components by id according to the defined variable
        addReview = findViewById(R.id.addRev);
        chipnav = findViewById(R.id.chipnav);

        if(isDetail.equals("details")){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new ProductDetails()).commit();
        }else{
            // set item selected in chipnav which is Home fragment
            chipnav.setItemSelected(R.id.nav_home, true);
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new HomeFragment()).commit();

        }


        //set on item selected in chipnav to change the page according to the user select
        chipnav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {

            @Override
            public void onItemSelected(int i) {

                //switch page on dashboard
                switch(i){
                    case R.id.nav_feed:
                        fragment = new FeedFragment();
                        break;
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        break;
                }

                //set fragment
                if (fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
            }
        });

        //set on click button for add review
        addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change page from dashboard to new review page
                Intent intent = new Intent(Dashboard.this, NewReview.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("landscape", "landscape");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("potrait", "potrait");
        }
    }
}