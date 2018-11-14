package com.m.nachomorati.gestionstockypedidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class InventariosActivity extends AppCompatActivity {
    ArrayList<Inventario> inventarios = new ArrayList<>();
    ListView lvInventarios;
    TextView fechaInventario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventarios);

        fechaInventario = (TextView)findViewById(R.id.tvFechaInventario);
        Date fecha = new Date();
        String simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy").format(fecha);

        fechaInventario.setText(simpleDateFormat);

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
