package com.example.ranchosojos.ui.view.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ranchosojos.R;
import com.example.ranchosojos.ui.view.helper.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class Cadastro extends AppCompatActivity {

    private TextInputEditText editNome, editEmail, editSenha;
    private Button btCadastrar;
    private FirebaseAuth usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNomeCadastro);
        editEmail = findViewById(R.id.editEmailCadastro);
        editSenha = findViewById(R.id.editSenhaCadastro);
        btCadastrar = findViewById(R.id.buttonCadastrar);
        usuario = ConfiguracaoFirebase.getFirebaseAuth();


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.createUserWithEmailAndPassword(editEmail.getText().toString(),editSenha.getText().toString())
                        .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Usuario criado com sucesso",Toast.LENGTH_LONG).show();
                                    finish();
                                    //abrir tela inicial
                                }else {
                                    String erro;
                                    try {
                                        throw task.getException();
                                    }catch (FirebaseAuthWeakPasswordException e){
                                        erro = "Digite uma senha mais forte!";
                                    } catch (FirebaseAuthInvalidCredentialsException e){
                                        erro = "Email digitado não é valido!";
                                    }catch (FirebaseAuthUserCollisionException e){
                                        erro = "Usuario já cadastrado";
                                    }catch (Exception e) {
                                        erro = "Erro desconhecido";
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(getApplicationContext(), erro,Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });




    }
}