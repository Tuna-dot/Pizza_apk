package com.example.pizza;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;



import com.example.pizza.adapter.MiniMenuAdapter;
import com.example.pizza.databinding.ActivityMenuScreenBinding;

import java.util.ArrayList;

public class MenuScreenActivity extends AppCompatActivity {

    ActivityMenuScreenBinding binding;
    ArrayList<MiniMenu> miniMenus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        binding = ActivityMenuScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MiniMenu item1 = new MiniMenu("Burgers", R.drawable.ic_burger);
        MiniMenu item2 = new MiniMenu("Chicken", R.drawable.chiken_ic);
        MiniMenu item3 = new MiniMenu("Pizza", R.drawable.pizza_icon);
        MiniMenu item4 = new MiniMenu("Salads", R.drawable.ic_salads);
        MiniMenu item5 = new MiniMenu("Drinks", R.drawable.ic_drink);




        miniMenus.add(item1);
        miniMenus.add(item2);
        miniMenus.add(item3);
        miniMenus.add(item4);
        miniMenus.add(item5);

        MiniMenuAdapter miniMenuAdapter = new MiniMenuAdapter(miniMenus);

        binding.recyclerView.setAdapter(miniMenuAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, false));
    }
}