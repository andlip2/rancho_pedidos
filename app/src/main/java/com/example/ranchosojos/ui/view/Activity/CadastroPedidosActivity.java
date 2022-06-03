package com.example.ranchosojos.ui.view.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ranchosojos.R;

public class CadastroPedidosActivity extends AppCompatActivity {

    private Spinner spMesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedidos);

        String [] mesas = getResources().getStringArray(R.array.mesas);

        spMesas = findViewById(R.id.spinnerMesas);

        spMesas.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, mesas));





    }
}