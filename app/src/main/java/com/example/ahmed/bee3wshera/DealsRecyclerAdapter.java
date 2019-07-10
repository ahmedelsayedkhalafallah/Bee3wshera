package com.example.ahmed.bee3wshera;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DealsRecyclerAdapter extends RecyclerView.Adapter<DealsRecyclerAdapter.ViewHolder>{


    private List<String> dealsList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    DealsRecyclerAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.dealsList = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.deals_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String category = dealsList.get(position);
        holder.dealItemName.setText(category);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return dealsList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dealItemName;

        ViewHolder(View itemView) {
            super(itemView);
            dealItemName = itemView.findViewById(R.id.dealItemName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return dealsList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
