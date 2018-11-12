package com.m.nachomorati.gestionstockypedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btnPedidos, btnInventarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPedidos = (Button) findViewById(R.id.btnPedidosActivity);
        btnInventarios = (Button) findViewById(R.id.btnInventariosActivity);

        btnPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, PedidosActivity.class);
                startActivity(i);
            }
        });

        btnInventarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, InventariosActivity.class);
                startActivity(i);
            }
        });

    }
}
