package com.m.nachomorati.gestionstockypedidos;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        /*Pedido pedido;
        for (int i = 0; i < 3; i++) {
            pedido = new Pedido();
            pedido.setCodigoInterno("EAR000123");
            pedido.setUsuario("Martin Ochoa");
            pedido.setFechaPedido(LocalDate.of(2018,11,20 + i));
            pedido.setHoraPedido(LocalTime.of(10 + i,25 + i));
            pedidos.add(pedido);
        }*/

        new PedidosJson(PedidosActivity.this, pedidos).execute("https://script.googleusercontent.com/macros/echo?user_content_key=g8YO2HO0Bd_LQuhityhMBq7FXSNufoprBFrDr_QmuA1LkVpoBnhs0QvgwLAkPtaUBqznw2QJi9M8rq-Ls_IrICoUls8UrSmtm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnMUJ2_XRi2mhbqpZmZpbajH6Cr3ZtKzQxVP2y7Z-9gdSs1ZMiXd0rxbmAlIYynngdPKfVnhjI6Uu&lib=M5vtlxp4qhtSc6bdkZ95K_RFIKHsGsLk9");

        listView = (ListView)findViewById(R.id.lvPedidos);

        AdapterPedidos adapterPedidos = new AdapterPedidos(this, pedidos);

        listView.setAdapter(adapterPedidos);

    }
}
