package com.example.admin.application;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    Context context;
    private List<Shop> list;
    public ShopAdapter(Context context,List<Shop> list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.shopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Shop shop=list.get(position);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder viewHolder,int i){
        Shop shop=list.get(i);
        Glide.with(context).load(shop.getImageId()).into(viewHolder.shopImage);
        viewHolder.shopName.setText(shop.getName());
    }
    @Override
    public int getItemCount(){
        return list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout shopLayout;
        ImageView shopImage;
        TextView shopName;
        View shopView;
        public ViewHolder(View view){
            super(view);
            shopView=view;
            shopImage=shopView.findViewById(R.id.photo);
            shopName=shopView.findViewById(R.id.shop);
        }
    }
}
