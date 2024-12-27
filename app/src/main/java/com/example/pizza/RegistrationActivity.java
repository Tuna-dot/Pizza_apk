package com.example.pizza;

import static android.R.color.white;
import static com.example.pizza.R.drawable.btn_bacgrount;
import static com.example.pizza.R.drawable.gradient_background;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizza.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityRegistrationBinding binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;





        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            String editEmail = binding.editEmail.getText().toString();
            String editPassword = binding.editPassword.getText().toString();
            String editConfirmPassword = binding.editConfirmPassword.getText().toString();

            if (editEmail.isEmpty() && editPassword.isEmpty() && editConfirmPassword.isEmpty()) {
                binding.btnLog.setEnabled(false);
                binding.btnLog.setBackground(getResources().getDrawable(btn_bacgrount));
            } else {
                binding.btnLog.setEnabled(true);
                binding.btnLog.setBackground(getResources().getDrawable(gradient_background));
                binding.btnLog.setOnClickListener(v -> {
                    Intent intent = new Intent(RegistrationActivity.this, MenuScreenActivity.class);
                    startActivity(intent);
                });
            }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        binding.editEmail.addTextChangedListener(textWatcher);
        binding.editPassword.addTextChangedListener(textWatcher);
        binding.editConfirmPassword.addTextChangedListener(textWatcher);


    }
}