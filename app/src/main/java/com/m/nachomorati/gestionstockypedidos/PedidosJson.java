package com.m.nachomorati.gestionstockypedidos;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PedidosJson extends AsyncTask<String, Void, String> {
    private Activity activity;
    private ArrayList<Pedido> pedidos;

    public PedidosJson(Activity activity, ArrayList<Pedido> pedidos) {
        this.activity = activity;
        this.pedidos = pedidos;
    }



    @Override
    protected String doInBackground(String... strings) {
        String resultado = null;


        try {

            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();
            String inputString;

            while((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }

            resultado = builder.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }


    //TODO preguntar a Marcos por esto: RequiresApi???
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onPostExecute(String s) {

        JSONArray array_pedidos = null;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(activity, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        try {
            array_pedidos = new JSONArray(s.toString());
            //Log.i("array_pedidos", array_pedidos.toString());
            for (int i = 0; i < array_pedidos.length(); i++){
                JSONObject ped = (JSONObject) array_pedidos.get(i);

                Pedido pedido = new Pedido();
                pedido.setId(ped.getInt("0"));
                pedido.setFechaPedido(LocalDateTime.parse(ped.getString("Fecha")));

                Usuario usuario_retira = new Usuario();
                int id_usuario_retira = ped.getInt("Id_usuario_retira");
                usuario_retira.setId(id_usuario_retira);
                Cursor fila = bd.rawQuery("SELECT usuario, perfil FROM usuarios WHERE id=" + id_usuario_retira, null);
                if (fila.moveToFirst()) {
                    usuario_retira.setUsuario(fila.getString(0));
                    usuario_retira.setPerfil(fila.getInt(1));
                }
                pedido.setUsuario(usuario_retira);

                Usuario usuario_pedidor = new Usuario();
                int id_usuario_pedidor = ped.getInt("Id_realizo_pedido");
                usuario_pedidor.setId(id_usuario_pedidor);
                Cursor filaUsuarioPedidor = bd.rawQuery("SELECT usuario, perfil FROM usuarios WHERE id=" + id_usuario_pedidor, null);
                if (filaUsuarioPedidor.moveToFirst()){
                    usuario_pedidor.setUsuario(filaUsuarioPedidor.getString(0));
                    usuario_pedidor.setPerfil(filaUsuarioPedidor.getInt(1));
                }
                pedido.setSolicitante(usuario_pedidor);
                //TODO armar pedido -_-

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
