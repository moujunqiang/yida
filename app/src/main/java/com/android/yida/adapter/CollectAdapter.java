package com.android.yida.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yida.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CollectAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collect, parent, false);
        return new CollectHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class CollectHolder extends RecyclerView.ViewHolder {
        private ImageView imageView, ivCollect;
        private TextView tvName, tvPrice;

        public CollectHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_collect);
            ivCollect = itemView.findViewById(R.id.iv_collect_collect);
            tvName = itemView.findViewById(R.id.tv_collect_name);
            tvPrice = itemView.findViewById(R.id.tv_collect_price);
        }
    }
}
