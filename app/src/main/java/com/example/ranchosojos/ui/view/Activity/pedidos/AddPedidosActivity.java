package com.example.ranchosojos.ui.view.Activity.pedidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ranchosojos.R;

public class AddPedidosActivity extends AppCompatActivity {

    private Button btAddHambuger, btAddPetiscos, btAddBebidas, btSalvarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pedidos);

        btAddHambuger = findViewById(R.id.buttonAddHamburger);
        btAddPetiscos = findViewById(R.id.buttonAddPetiscos);
        btAddBebidas = findViewById(R.id.buttonAddBebidas);
        btSalvarPedido = findViewById(R.id.buttonSalvarPedido);


        btAddHambuger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CadastroHamburgerActivity.class);
                startActivity(i);
            }
        });
        btAddPetiscos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CadastroPetiscosActivity.class);
                startActivity(i);
            }
        });

    }

}