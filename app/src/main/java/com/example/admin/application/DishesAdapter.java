package com.example.admin.application;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishesAdapter extends RecyclerView.Adapter<DishesAdapter.ViewHolder> {
    private List<Dishes> list;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView dishesImage;
        TextView dishesName;
        TextView dishesPrice;

        View dishesView;
        public ViewHolder(View view){
            super(view);
            dishesView=view;
            dishesImage=(ImageView)view.findViewById(R.id.dishes_photo);
            dishesName=(TextView)view.findViewById(R.id.dishes_name);
            dishesPrice=(TextView)view.findViewById(R.id.dishes_price);
        }
    }
    public DishesAdapter(List<Dishes> list){this.list=list;}
    @NonNull
    @Override
    public DishesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview,viewGroup,false);
        final DishesAdapter.ViewHolder holder=new DishesAdapter.ViewHolder(view);
        holder.dishesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Dishes dishes=list.get(position);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull DishesAdapter.ViewHolder viewHolder,int i){
        Dishes dishes=list.get(i);
        viewHolder.dishesImage.setImageResource(dishes.getImageId());
        viewHolder.dishesName.setText(dishes.getName());
    }
    @Override
    public int getItemCount(){return list.size();}
}
