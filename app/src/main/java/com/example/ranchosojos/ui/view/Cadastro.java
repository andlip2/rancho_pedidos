package com.example.ranchosojos.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ranchosojos.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private TextInputEditText editNome, editEmail, editSenha;
    private Button btCadastrar;
    private FirebaseAuth user = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNomeCadastro);
        editEmail = findViewById(R.id.editEmailCadastro);
        editSenha = findViewById(R.id.editSenhaCadastro);
        btCadastrar = findViewById(R.id.buttonCadastrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.createUserWithEmailAndPassword(editEmail.getText().toString(),editSenha.getText().toString())
                        .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Usuario criado com sucesso",Toast.LENGTH_LONG).show();
                                    finish();
                                    //abrir tela inicial
                                }else {
                                    Toast.makeText(getApplicationContext(),"Erro ao cadastrar",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });




    }
}