package com.m.nachomorati.gestionstockypedidos;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class UsuariosJson extends AsyncTask<String, Void, String> {

    private Activity activity;
    private ArrayList<Usuario> usuarios;

    public UsuariosJson (Activity activity, ArrayList<Usuario> usuarios) {
        this.activity = activity;
        this.usuarios = usuarios;
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

    @Override
    protected void onPostExecute(String s) {
        //Log.i("s", s);
        JSONArray array_usuarios = null;

        try {
            array_usuarios = new JSONArray(s.toString());
            //Log.i("usuarios", usuarios.toString());

            for (int i = 0; i < array_usuarios.length(); i++) {
                JSONObject user = (JSONObject) array_usuarios.get(i);
                //Log.i("user", user.toString());

                //Log.i("password", md5(((JSONObject) array_usuarios.get(i)).getString("Password")));

                Usuario usuario = new Usuario();
                usuario.setId(user.getInt("Id"));
                usuario.setUsuario(user.getString("Usuario"));
                usuario.setPassword(user.getString("Password"));
                usuario.setPerfil(user.getInt("Perfil"));

                usuarios.add(usuario);
            }

            //Llenar el ArrayList usuarios de MainActivity



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
