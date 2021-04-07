package com.example.amoriproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amoriproject.Adapter.RVAdapter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ProductDetails extends Fragment {

    View myFragment;
    ImageView image_detail;
    TextView product_brand, product_names, product_size, product_price, sizeOrShade;
    Button category_btn, addRev_fromProduct;
    RecyclerView RV_review;
    RVAdapter adapter;

//    final Bitmap img;
//    final String brand, name, size_shade, category, price;

    SharedPreferences sp;
    String SP_NAME = "mypref";
    String KEY_NAME = "name";
    String KEY_CATEGORY = "category";

    ArrayList<String> product_name, review_detail, username, review_date, product_category;

    public ProductDetails() {
        // Required empty public constructor
    }

    public static ProductDetails getInstance() {
        return new ProductDetails();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_product_details, container, false);

        sp = getContext().getSharedPreferences(SP_NAME, MODE_PRIVATE);

        Bitmap img = getActivity().getIntent().getExtras().getParcelable("picture");
        String brand = getActivity().getIntent().getExtras().getString("brand");
        final String name = getActivity().getIntent().getExtras().getString("name");
        String size_shade = getActivity().getIntent().getExtras().getString("size_shade");
        final String category = getActivity().getIntent().getExtras().getString("category");
        String price = getActivity().getIntent().getExtras().getString("price");

        image_detail = myFragment.findViewById(R.id.image_detail);
        image_detail.setImageBitmap(img);

        product_brand = myFragment.findViewById(R.id.product_brand);
        product_brand.setText(brand);

        product_names = myFragment.findViewById(R.id.product_name);
        product_names.setText(name);

        category_btn = myFragment.findViewById(R.id.category_btn);
        category_btn.setText(category);

        addRev_fromProduct = myFragment.findViewById(R.id.addRev_fromProduct);
        addRev_fromProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(KEY_NAME, name );
                editor.putString(KEY_CATEGORY, category );
                editor.commit();

                Intent i = new Intent(getContext(), EditReview.class);
                startActivity(i);
            }
        });

        product_size = myFragment.findViewById(R.id.product_size);
        product_size.setText(size_shade);

        product_price = myFragment.findViewById(R.id.product_price);
        product_brand.setText(price);

        if (category.equals("Make Up")) {
            sizeOrShade = myFragment.findViewById(R.id.sizeOrshade);
            sizeOrShade.setText("Shade");
        }

        RV_review = myFragment.findViewById(R.id.rv_review);

        product_name = new ArrayList<>();
        review_detail = new ArrayList<>();
        username = new ArrayList<>();
        review_date = new ArrayList<>();
        product_category = new ArrayList<>();

        addReviewList(category);

        //add and set adapter for recycler view
        adapter = new RVAdapter(getContext(),product_name, product_category, review_detail , review_date, username);
        RV_review.setAdapter(adapter);
        RV_review.setLayoutManager(new LinearLayoutManager(getContext()));

        return myFragment;

    }



    public void addReviewList(String category){
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