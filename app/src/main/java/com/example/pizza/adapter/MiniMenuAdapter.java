package com.example.pizza.adapter;

import static com.example.pizza.R.color.background_card;
import static com.example.pizza.R.color.red;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.MiniMenu;
import com.example.pizza.R;
import com.example.pizza.databinding.ItemMiniFoodMenuBinding;

import java.util.ArrayList;

public class MiniMenuAdapter extends RecyclerView.Adapter<MiniMenuAdapter.MiniMenuViewHolder> {

    private final ArrayList<MiniMenu> miniMenus;
    private int selectedPosition = -1; // Текущая выбранная позиция

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
        holder.bind(miniMenus.get(position), position);



            // Устанавливаем выбранный цвет для элемента
            if (position == selectedPosition) {
                holder.binding.ivPortredFood.setColorFilter(Color.RED); // Красный фон
                holder.binding.tvNameFood.setTextColor(Color.RED); // Красный текст
            } else {
                holder.binding.ivPortredFood.setColorFilter(Color.GRAY); // Обычный фон
                holder.binding.tvNameFood.setTextColor(Color.GRAY); // Обычный текст
            }

            // Обработка клика
            holder.itemView.setOnClickListener(v -> {
                moveItemToTop(position); // Перемещаем элемент в начало
            });


    }

    public void moveItemToTop(int position) {
        if (position != RecyclerView.NO_POSITION && position != 0) {
            MiniMenu selectedItem = miniMenus.remove(position);
            miniMenus.add(0, selectedItem); // Перемещаем выбранный элемент в начало
            selectedPosition = 0; // Обновляем позицию выделенного элемента
            notifyDataSetChanged(); // Обновляем RecyclerView
        }
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

        @SuppressLint("ResourceAsColor")
        public void bind(MiniMenu miniMenu, int position) {
            // Устанавливаем текст и изображение
            binding.tvNameFood.setText(miniMenu.getTextView());
            binding.ivPortredFood.setImageResource(miniMenu.getImageView());



        }
    }
}
