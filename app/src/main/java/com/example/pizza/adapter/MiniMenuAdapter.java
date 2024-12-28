package com.example.pizza.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.MiniMenu;
import com.example.pizza.databinding.ItemMiniFoodMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class MiniMenuAdapter extends RecyclerView.Adapter<MiniMenuAdapter.MiniMenuViewHolder> {


    private final ArrayList<MiniMenu> miniMenus;

    public MiniMenuAdapter(ArrayList<MiniMenu> miniMenus) {
        this.miniMenus = miniMenus;
    }

    @NonNull
    @Override
    public MiniMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMiniFoodMenuBinding binding = ItemMiniFoodMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MiniMenuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MiniMenuViewHolder holder, int position) {
        holder.bind(miniMenus.get(position));
    }

    @Override
    public int getItemCount() {
        return miniMenus.size();
    }

    class MiniMenuViewHolder extends RecyclerView.ViewHolder {

        ItemMiniFoodMenuBinding binding;

        public MiniMenuViewHolder(ItemMiniFoodMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(MiniMenu miniMenu) {
            binding.tvNameFood.setText(miniMenu.getTextView());
            binding.ivPortredFood.setImageResource(miniMenu.getImageView());

        }
    }
}
