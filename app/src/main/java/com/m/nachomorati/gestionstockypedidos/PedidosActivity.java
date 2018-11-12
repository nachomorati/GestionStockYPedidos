package com.m.nachomorati.gestionstockypedidos;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ListView listView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        //rellenar el arraylist de pedidos para mostrarlos
        //TODO reemplazar con el JSON
        Pedido pedido;
        for (int i = 0; i < 3; i++) {
            pedido = new Pedido();
            pedido.setCodigoInterno("EAR000123");
            pedido.setUsuario("Martin Ochoa");
            pedido.setFechaPedido(LocalDate.of(2018,11,20 + i));
            pedido.setHoraPedido(LocalTime.of(10 + i,25 + i));
            pedidos.add(pedido);
        }

        listView = (ListView)findViewById(R.id.lvPedidos);

        AdapterPedidos adapterPedidos = new AdapterPedidos(this, pedidos);

        listView.setAdapter(adapterPedidos);

    }
}
