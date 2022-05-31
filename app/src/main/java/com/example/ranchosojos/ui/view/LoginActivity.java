package com.example.ranchosojos.ui.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ranchosojos.databinding.ActivityLoginBinding;
import com.example.ranchosojos.ui.view.Activity.Cadastro;
import com.example.ranchosojos.ui.view.helper.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    private com.example.ranchosojos.databinding.ActivityLoginBinding binding;
//    private Button btLogin;
    private FirebaseAuth autenticacao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        btLogin = findViewById(R.id.buttonEntrar);
        final EditText editEmail = binding.editEmail;
        final EditText editSenha = binding.editSenha;
        final Button btlogin = binding.buttonEntrar;
        final ProgressBar carregar = binding.progressCarregar;

        autenticacao = ConfiguracaoFirebase.getFirebaseAuth();


        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailRecuperado = editEmail.getText().toString();
                String senhaRecuperado = editSenha.getText().toString();
                if (emailRecuperado.equals("admLigia") && senhaRecuperado.equals("ligiaAdm")){
                    carregar.setVisibility(View.VISIBLE);
                    Intent i = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(i);}else {
                    Toast.makeText(getApplicationContext(), "Erro desconhecido", Toast.LENGTH_LONG).show();
                }
                 if (!emailRecuperado.isEmpty()){
                    if (!senhaRecuperado.isEmpty()){

                        autenticacao.signInWithEmailAndPassword(emailRecuperado, senhaRecuperado)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!emailRecuperado.isEmpty()){
                                            if (!senhaRecuperado.isEmpty()){

                                                if (task.isSuccessful()){

                                                    Intent i = new Intent(getApplicationContext(), Cadastro.class);
                                                    startActivity(i);

                                                }

                                            }else{
                                                Toast.makeText(getApplicationContext(), "Preencha a senha", Toast.LENGTH_LONG).show();
                                            }
                                        }else {
                                            Toast.makeText(getApplicationContext(), "Preencha o Email", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                    }else{
                        Toast.makeText(getApplicationContext(), "Preencha a senha", Toast.LENGTH_LONG).show();
                    }
                }else {
                     Toast.makeText(getApplicationContext(), "Preencha o Email", Toast.LENGTH_LONG).show();
                 }
            }
        });


//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadingProgressBar.setVisibility(View.VISIBLE);
//
//            }
//        });
        if (autenticacao.getCurrentUser() == null){

//            onDestroy();
        }else {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }

}