package com.m.nachomorati.gestionstockypedidos;

import android.app.Activity;
import android.os.AsyncTask;
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
import java.util.ArrayList;

public class MaterialesJson extends AsyncTask<String, Void, String> {

    private Activity activity;
    private ArrayList<Material> materiales;

    public MaterialesJson (Activity activity, ArrayList<Material> materiales) {
        this.activity = activity;
        this.materiales = materiales;
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
        JSONArray array_materiales = null;

        try {
            array_materiales = new JSONArray(s.toString());
            for (int i = 0; i < array_materiales.length(); i++){
                JSONObject mat = (JSONObject) array_materiales.get(i);

                Material material = new Material();
                material.setPlant(mat.getString("Plant"));
                material.setBatch(mat.getString("Batch"));
                material.setDescription(mat.getString("Material Description"));
                material.setFf(mat.getString("Forcus factory"));
                material.setMaterial(mat.getString("Material"));
                material.setPallets(mat.getString("Pallets"));
                material.setStatus(mat.getString("Status"));
                material.setStock(mat.getInt("BUM Quantity"));
                material.setStorage_location(mat.getString("Storage Location"));
                material.setValue(mat.getString("Total value"));

                materiales.add(material);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("status: ", "terminado de paresear");

    }


}
