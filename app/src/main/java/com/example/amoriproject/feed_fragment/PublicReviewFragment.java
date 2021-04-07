package com.example.amoriproject.feed_fragment;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.amoriproject.Adapter.RVAdapter;
import com.example.amoriproject.R;

import java.util.ArrayList;

public class PublicReviewFragment extends Fragment {

    //define variables
    RecyclerView RV_review;
    RVAdapter adapter;
    View myFrag;
    SwipeRefreshLayout swipeRefresh;

    ArrayList<String> product_name, review_detail, username, review_date, product_category;

    public PublicReviewFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        swipeRefresh = myFrag.findViewById(R.id.swipeRefresh_pr);
        //swipe refresh on click listener
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
             getFragmentManager().beginTransaction().detach(PublicReviewFragment.this).attach(PublicReviewFragment.this).commit();


                swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFrag = inflater.inflate(R.layout.fragment_public_review, container, false);

        // find components by id according to the defined variable
        RV_review = myFrag.findViewById(R.id.rv_review);


        //make array list for each content
        product_name = new ArrayList<>();
        review_detail = new ArrayList<>();
        username = new ArrayList<>();
        review_date = new ArrayList<>();
        product_category = new ArrayList<>();

        storeDataInArray();

        //set adapter
        adapter = new RVAdapter(getContext(),product_name, product_category, review_detail , review_date, username);
        RV_review.setAdapter(adapter);
        RV_review.setLayoutManager(new LinearLayoutManager(getContext()));

        return myFrag;
    }

    public void storeDataInArray(){
//        //get all review from database
//        Cursor cr = dbHelper.fetchAllReview();
//        if(cr.getCount() == 0){
//            //make toast for tell user there is no data
//            Toast.makeText(getContext(), "No data", Toast.LENGTH_SHORT).show();
//        }else{
//            while(cr.moveToNext()){
//                //add data to array list
//                product_name.add(cr.getString(1));
//                product_category.add(cr.getString(2));
//                review_detail.add(cr.getString(3));
//                username.add(cr.getString(4));
//                review_date.add(cr.getString(5));
//            }
//        }
        makeupSelected();
        skincareSelected();
        beautytoolSelected();
        bodycareSelected();
    }

    public void makeupSelected(){
        int x = 1;
        while(x<3){
            product_name.add("Maybelline Sensational Liquid Matte ");
            product_category.add("Make Up");
            review_detail.add("Ini ga transfer kalo pake masker dan ga gampang ilang juga cuma kalo buat makan agak ilang tapi masih oke laahh.");
            username.add("Username1");
            review_date.add("20 Feb 2021");

            x++;
        }
    }

    public void skincareSelected(){
        int x = 1;
        while(x<3){
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
        while(x<3){
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
        while(x<3){
            product_name.add("MAANGE Set Brush");
            product_category.add("Beauty Tools");
            review_detail.add("Harga segini dpt banyak ini worthit bgt dan kualitas bukan kaleng kaleng ini lumayan bgt buat makeup toolsnya");
            username.add("Username4");
            review_date.add("20 Feb 2021");

            x++;
        }
    }
}