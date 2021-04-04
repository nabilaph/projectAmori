package com.example.amoriproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.amoriproject.Adapter.RVAdapter;

import java.util.ArrayList;

public class ReviewByCategory extends AppCompatActivity {

    //define variables
    RecyclerView RV_reviewCat;
    RVAdapter adapter;
    TextView selectedCategory;

    ArrayList<String> product_name, review_detail, username, review_date, product_category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_by_category);


        // find components by id according to the defined variable
        RV_reviewCat = findViewById(R.id.rv_reviewCat);
        selectedCategory = findViewById(R.id.selectedCategory);

        //set text category
//        selectedCategory.setText(category);


        //array list for display review
        product_name = new ArrayList<>();
        review_detail = new ArrayList<>();
        username = new ArrayList<>();
        review_date = new ArrayList<>();
        product_category = new ArrayList<>();

        //run method in line 75 to store data in array
//        storeDataInArray(category);

        //add and set adapter for recycler view
        adapter = new RVAdapter(this,product_name, product_category, review_detail , review_date, username);
        RV_reviewCat.setAdapter(adapter);
        RV_reviewCat.setLayoutManager(new LinearLayoutManager(this));
    }

//    public void storeDataInArray(String category){
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
//    }
}