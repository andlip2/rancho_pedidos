package com.example.ranchosojos.ui.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.ranchosojos.R;
import com.example.ranchosojos.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;
    private Button btLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btLogin = findViewById(R.id.buttonlogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Cadastro.class);
                startActivity(i);
            }
        });



//        final EditText usernameEditText = binding.username;
//        final EditText passwordEditText = binding.password;
//        final Button loginButton = binding.buttonlogin;
//        final ProgressBar loadingProgressBar = binding.loading;
//
//
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//
//            }
//        });
    }

}