package com.m.nachomorati.gestionstockypedidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class InventariosActivity extends AppCompatActivity {
    ArrayList<Inventario> inventarios = new ArrayList<>();
    ListView lvInventarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventarios);

        //TODO llenar ArrayList con el JSON
        Material m1 = new Material("EAR001100", "RODAMIENTO 6600", 16);
        Material m2 = new Material("EAR000500", "ROTULA IZQ M12", 7);
        Material m3 = new Material("EAR001738", "FILTRO 40 MIC", 3);

        inventarios.add(new Inventario(m1, 15));
        inventarios.add(new Inventario(m2, 9));
        inventarios.add(new Inventario(m3, 3));

        lvInventarios = (ListView)findViewById(R.id.lvInventarios);
        AdapterInventarios adapterInventarios = new AdapterInventarios(this, inventarios);
        lvInventarios.setAdapter(adapterInventarios);
    }
}
