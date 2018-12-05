package com.m.nachomorati.gestionstockypedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Button btnPedidos, btnInventarios;
    ArrayList<Material> materiales = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPedidos = (Button) findViewById(R.id.btnPedidosActivity);
        btnInventarios = (Button) findViewById(R.id.btnInventariosActivity);

        //Llenar el ArrayList de materiales
        //Hasta que la tarea termine bloquea el thread
        //new MaterialesJson(HomeActivity.this, materiales).execute("https://script.googleusercontent.com/macros/echo?user_content_key=SACCwrGsYQ3OiuxtGwzwHVMs0SqzwqOtdVDy0GekxHu7Wv6dvAOVIV2BuWfw0E4IzU_qC2k3pN4wNsIFIW4r95dDY07-GzIHm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnMnDa250vkyu2cRW5aNcWxapwRDQVB6VanygLkCWmWY5kqCseEZbLQNfWyEb6XrMwMVlocvc-Sox&lib=MJQEriyVLkAJHDund87AKqBhC2SUPxw8X");

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
