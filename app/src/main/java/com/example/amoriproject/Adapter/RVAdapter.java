package com.example.amoriproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amoriproject.EditReview;
import com.example.amoriproject.ProductDetails;
import com.example.amoriproject.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVviewHolder> {

    //define variables
    private Context context;
    private ArrayList product_name, product_category, review_detail, review_date, username;

    //constructor
    public RVAdapter(Context context, ArrayList product_name, ArrayList product_category,
                     ArrayList review_detail, ArrayList review_date, ArrayList username){
        this.context = context;
        this.product_name = product_name;
        this.product_category = product_category;
        this.review_date = review_date;
        this.review_detail = review_detail;
        this.username = username;
    }

    public class RVviewHolder extends RecyclerView.ViewHolder{

        //define variables
        TextView txt_productName, txt_productCategory,txt_reviewDet, txt_reviewDate, txt_username;
        String SP_NAME = "mypref";
        SharedPreferences sp;

        public RVviewHolder(@NonNull View itemView) {
            super(itemView);

            // find components by id according to the defined variable
            txt_productName = itemView.findViewById(R.id.text_productName);
            txt_productCategory = itemView.findViewById(R.id.text_productCategory);
            txt_reviewDet = itemView.findViewById(R.id.text_reviewDet);
            txt_reviewDate = itemView.findViewById(R.id.text_reviewDate);
            txt_username = itemView.findViewById(R.id.text_username);

        }
    }


    @NonNull
    @Override
    public RVviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // set layout for recycler view
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_review_item, parent, false);

        return new RVviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RVviewHolder holder, int position) {

        //set text
        holder.txt_productName.setText(String.valueOf(product_name.get(position)));
        holder.txt_productCategory.setText(String.valueOf(product_category.get(position)));
        holder.txt_reviewDet.setText(String.valueOf(review_detail.get(position)));
        holder.txt_reviewDate.setText(String.valueOf(review_date.get(position)));
        holder.txt_username.setText(String.valueOf(username.get(position)));

        holder.txt_productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat = (String) holder.txt_productCategory.getText();

                List<Object> value = valueToDetails(cat);
                Intent intent = new Intent(v.getContext(), ProductDetails.class);
                intent.putExtra("picture", (Parcelable) value.get(0));
                intent.putExtra("brand", (String) value.get(1));
                intent.putExtra("name", (String) value.get(2));
                intent.putExtra("size_shade", (String) value.get(3));
                intent.putExtra("price", (String) value.get(4));
                intent.putExtra("category", (String) value.get(5));

                SharedPreferences.Editor editor = holder.sp.edit();
                editor.putString("isDetail", "details");
                editor.commit();

                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return product_name.size();
    }


    public List<Object> valueToDetails(String category){
        List<Object> value = new ArrayList <Object>();
        Bitmap img_det = null;
        byte[] byteArray;

        if(category.equals("Make Up")){
            img_det = BitmapFactory.decodeResource(context.getResources(), R.drawable.powder_makeup);
            value.add(1,"MINERAL BOTANICA");
            value.add(2,"Original Loose Foundation ");
            value.add(3,"Beige");
            value.add(4,"IDR65900");
            value.add(5,"Make Up");


        }else if(category.equals("Skin Care")){

            img_det = BitmapFactory.decodeResource(context.getResources(), R.drawable.safi_skincare);
            value.add(1,"Safi");
            value.add(2,"Age Defy Foam Cleanser Deep Exfoliator");
            value.add(3,"75 gr");
            value.add(4,"IDR50000");
            value.add(5,"Skin Care");

        }else if(category.equals("Body Care")){

            img_det = BitmapFactory.decodeResource(context.getResources(), R.drawable.scarlett_bodycare);
            value.add(1,"SCARLETT");
            value.add(2,"Whitening Brightening Shower Scrub");
            value.add(3,"300 ml");
            value.add(4,"IDR82500");
            value.add(5,"Body Care");

        }else if(category.equals("Beauty Tools")){

            img_det = BitmapFactory.decodeResource(context.getResources(), R.drawable.brush_tools);
            value.add(1,"MAANGE");
            value.add(2,"Set Brush ");
            value.add(3,"-");
            value.add(4,"IDR108000");
            value.add(5,"Beauty Tools");

        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img_det.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        value.add(0,byteArray);

        return value;


    }


}
