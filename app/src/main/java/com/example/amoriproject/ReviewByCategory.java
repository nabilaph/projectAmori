package com.example.amoriproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.amoriproject.Adapter.RVAdapter;

import java.util.ArrayList;

public class ReviewByCategory extends AppCompatActivity {

    //define variables
    RecyclerView RV_reviewCat;
    RVAdapter adapter;
    TextView selectedCategory;
    ImageButton backBtn;

    ArrayList<String> product_name, review_detail, username, review_date, product_category;

    SharedPreferences sp;

    // define the name of shared preferences and key
    String SP_NAME = "mypref";
    String KEY_CATEGORY = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_by_category);

        //get shared preferences
        sp = getSharedPreferences(SP_NAME, MODE_PRIVATE);

        String categorySelected = sp.getString(KEY_CATEGORY, null);

        // find components by id according to the defined variable
        RV_reviewCat = findViewById(R.id.rv_reviewCat);
        selectedCategory = findViewById(R.id.selectedCategory);
        selectedCategory.setText(categorySelected);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //array list for display review
        product_name = new ArrayList<>();
        review_detail = new ArrayList<>();
        username = new ArrayList<>();
        review_date = new ArrayList<>();
        product_category = new ArrayList<>();

        //run method in line 75 to store data in array
        storeDataInArray(categorySelected);

        //add and set adapter for recycler view
        adapter = new RVAdapter(this,product_name, product_category, review_detail , review_date, username);
        RV_reviewCat.setAdapter(adapter);
        RV_reviewCat.setLayoutManager(new LinearLayoutManager(this));
    }

    public void storeDataInArray(String category){
//
//        //get review category from database
//        Cursor cr = dbHelper.getReview(category);
//        //if the data based on selected category = 0
//        if(cr.getCount() == 0){
//            //make toast for tell the user there is no data
//            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
//        }else{
//            while(cr.moveToNext()){
//                //get data to display review
//                product_name.add(cr.getString(1));
//                product_category.add(cr.getString(2));
//                review_detail.add(cr.getString(3));
//                username.add(cr.getString(4));
//                review_date.add(cr.getString(5));
//            }
//        }
        if(category.equals("Make Up")){
            makeupSelected();
        }else if(category.equals("Skin Care")){
            skincareSelected();
        }else if(category.equals("Body Care")){
            bodycareSelected();
        }else if(category.equals("Beauty Tools")){
            beautytoolSelected();
        }
    }

    public void makeupSelected(){
        int x = 1;
        while(x<6){
            product_name.add("MINERAL BOTANICA Original Loose Foundation");
            product_category.add("Make Up");
            review_detail.add("Akhirnya nemu loose powder yang cocok banget di kulit ku yang kering. enggak bikin breakout. coverage nya lumayan bisa menutupi bekas jerawat.");
            username.add("Username1");
            review_date.add("20 Feb 2021");

            x++;
        }
    }

    public void skincareSelected(){
        int x = 1;
        while(x<6){
            product_name.add("Safi Age Defy Foam Cleanser Deep Exfoliator");
            product_category.add("Skin Care");
            review_detail.add("After pake ini, menurut aku sih bikin muka jadi bersih banget walaupun bisa dibilang scrub dia itu tergolong lebih kasar dibanding exfoliator lain.");
            username.add("Username2");
            review_date.add("20 Feb 2021");

            x++;
        }
    }

    public void bodycareSelected(){
        int x = 1;
        while(x<6){
            product_name.add("SCARLETT Brightening Shower Scrub");
            product_category.add("Body Care");
            review_detail.add("Badan jadi bersih, wangi, dan segar. Shower scrub ini bertekstur gel dan ada butiran scrub kecilnya. \n");
            username.add("Username3");
            review_date.add("20 Feb 2021");

            x++;
        }
    }

    public void beautytoolSelected(){
        int x = 1;
        while(x<6){
            product_name.add("MAANGE Set Brush");
            product_category.add("Beauty Tools");
            review_detail.add("Harga segini dpt banyak ini worthit bgt dan kualitas bukan kaleng kaleng ini lumayan bgt buat makeup toolsnya");
            username.add("Username4");
            review_date.add("20 Feb 2021");

            x++;
        }
    }
}