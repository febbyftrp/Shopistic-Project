package mmu.edu.my.shopistic.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mmu.edu.my.shopistic.ProductDetails;
import mmu.edu.my.shopistic.R;
import mmu.edu.my.shopistic.model.RecentlyViewed;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder> {

    Context context;
    List<RecentlyViewed> recentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false);
        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, int position) {

        holder.name.setText(recentlyViewedList.get(position).getName());
        holder.description.setText(recentlyViewedList.get(position).getDescription());
        holder.price.setText(recentlyViewedList.get(position).getPrice());
        holder.size.setText(recentlyViewedList.get(position).getSize());
        holder.colour.setText(recentlyViewedList.get(position).getColour());
        holder.bg.setBackgroundResource(recentlyViewedList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, ProductDetails.class);
                i.putExtra("name", recentlyViewedList.get(position).getName());
                i.putExtra("image",recentlyViewedList.get(position).getImageUrl());
                i.putExtra("price",recentlyViewedList.get(position).getPrice());
                i.putExtra("desc",recentlyViewedList.get(position).getDescription());
                i.putExtra("size",recentlyViewedList.get(position).getSize());
                i.putExtra("colour",recentlyViewedList.get(position).getColour());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder {

        TextView name, description, price, size, colour;
        ConstraintLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            size = itemView.findViewById(R.id.size);
            colour = itemView.findViewById(R.id.colour);
            bg = itemView.findViewById(R.id.recently_layout);
        }
    }
}