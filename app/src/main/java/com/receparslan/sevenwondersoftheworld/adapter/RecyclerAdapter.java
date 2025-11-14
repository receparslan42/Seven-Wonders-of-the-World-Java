package com.receparslan.sevenwondersoftheworld.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.receparslan.sevenwondersoftheworld.databinding.RecyclerRowBinding;
import com.receparslan.sevenwondersoftheworld.model.Wonder;
import com.receparslan.sevenwondersoftheworld.views.DetailActivity;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final ArrayList<Wonder> wonderArrayList;

    public RecyclerAdapter(ArrayList<Wonder> wonderArrayList) {
        this.wonderArrayList = wonderArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.wonderIDTextView.setText(String.valueOf(position + 1));
        holder.binding.wonderNameTextView.setText(wonderArrayList.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
            Wonder wonder = wonderArrayList.get(position);
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("wonderImage", wonder.getImage());
            intent.putExtra("wonderName", wonder.getName());
            intent.putExtra("wonderCountry", wonder.getCountry());
            intent.putExtra("wonderInformation", wonder.getInformation());
            startActivity(holder.itemView.getContext(), intent, null);
        });
    }

    @Override
    public int getItemCount() {
        return wonderArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerRowBinding binding;

        public ViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
