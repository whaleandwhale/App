package com.example.admin.application;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
    private List<Orders>list;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView shopName;
        TextView dishesName;
        TextView dishPrice;
        View listView;
        public ViewHolder(View view){
            super(view);
            listView=view;
            shopName=(TextView)view.findViewById(R.id.shop_name);
            dishesName=(TextView)view.findViewById(R.id.dishes_name);
            dishPrice=(TextView)view.findViewById(R.id.price);
        }
    }
    public OrdersAdapter(List<Orders>list){this.list=list;}
    @NonNull
    @Override
    public OrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i){
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_2,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    public void onBindViewHolder(@NonNull OrdersAdapter.ViewHolder viewHolder,int i){
        Orders orders = list.get(i);
        viewHolder.dishesName.setText(orders.getName());
        viewHolder.shopName.setText(orders.getName());
        viewHolder.dishPrice.setText(orders.getPrice());
    }
    @Override
    public int getItemCount(){return list.size();}
}
