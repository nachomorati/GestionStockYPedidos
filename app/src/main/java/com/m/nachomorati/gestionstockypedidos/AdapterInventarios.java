package com.m.nachomorati.gestionstockypedidos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterInventarios extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Inventario> items;

    public AdapterInventarios(Activity activity, ArrayList<Inventario> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    public void clear () {
        items.clear();
    }

    public void addAll(ArrayList<Inventario> inventarios) {
        for(Inventario i:inventarios) {
            items.add(i);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_inventario, null);
        }

        Inventario dir = items.get(position);

        TextView codigoInterno = (TextView)v.findViewById(R.id.tvCodigoInterno);
        codigoInterno.setText(dir.getMaterial().getMaterial());

        TextView descripcion = (TextView)v.findViewById(R.id.tvDescripcion);
        descripcion.setText(dir.getMaterial().getDescription());

        TextView cantidad = (TextView)v.findViewById(R.id.tvCantidad);
        cantidad.setText(String.valueOf(dir.getCantidad()));


        return v;
    }
}
