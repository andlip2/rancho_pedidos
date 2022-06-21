package com.example.ranchosojos.ui.view.Activity.pedidos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ranchosojos.databinding.ActivityCadastroHamburgerBinding;

public class CadastroHamburgerActivity extends AppCompatActivity {


private  ActivityCadastroHamburgerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityCadastroHamburgerBinding.inflate(getLayoutInflater());
//                ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






    }
}