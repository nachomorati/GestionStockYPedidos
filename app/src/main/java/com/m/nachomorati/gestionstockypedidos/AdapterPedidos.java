package com.m.nachomorati.gestionstockypedidos;

import android.app.Activity;
import android.content.Context;
import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterPedidos extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Pedido> items;

    public AdapterPedidos(Activity activity, ArrayList<Pedido> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Pedido> pedidos){
        for (int i = 0; i < pedidos.size(); i++) {
            items.add(pedidos.get(i));
        }
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
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
            v = inf.inflate(R.layout.item_pedido, null);
        }

        Pedido dir = items.get(position);

        TextView codigoInterno = (TextView)v.findViewById(R.id.tvCodigoInterno);
        codigoInterno.setText(dir.getCodigoInterno());

        TextView usuario = (TextView)v.findViewById(R.id.tvUsuario);
        //usuario.setText(dir.getUsuario());

        TextView fechaPedido = (TextView)v.findViewById(R.id.tvFechaPedido);
        fechaPedido.setText(dir.getFechaPedido().toString());

        TextView horaPedido = (TextView) v.findViewById(R.id.tvHoraPedido);
        //horaPedido.setText(dir.getHoraPedido().toString());

        return v;
    }
}
