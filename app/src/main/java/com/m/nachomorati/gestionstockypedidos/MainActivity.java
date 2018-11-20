package com.m.nachomorati.gestionstockypedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText usuario, password;
    Button login;
    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.etUsuario);
        password = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);

        //llenar el ArrayList 'usuarios' con todos los usuarios de la base de datos
        new UsuariosJson(MainActivity.this, usuarios).execute("https://script.googleusercontent.com/macros/echo?user_content_key=QB6CnKbYj8b4h8m4DSKrBvPZs82alLB7UEx6PvCfhOEDM1qVOWl7U_i7Qyk40AuQ8rULsyK-c9kV9-iY1ZyJTIfro5aPH3D7m5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnOqqbSj5KAiEs6H-OK-Zktnwqx6LyK6J-nrFyNOX9Fi8k_0SDUg8tipsF_7s6NyvwnSVnJ8cm27y&lib=Mwc65VL_D_7lXmyU6K1anNRhC2SUPxw8X");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsuario = null;
                String txtPassword = null;
                Boolean encontrado = false;
                try {
                    txtUsuario = usuario.getText().toString();
                    txtPassword = md5(password.getText().toString());

                    for (int i = 0; i < usuarios.size(); i++) {
                        //Log.i("txtPassword",txtPassword);
                        //Log.i("usuario password:", usuarios.get(i).getPassword());

                        if(txtUsuario.equals(usuarios.get(i).getUsuario()) && txtPassword.equals(usuarios.get(i).getPassword())) {
                            encontrado = true;
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    }

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                if (!encontrado) {
                    Toast.makeText(MainActivity.this, "Usuario y/o contraseña no válidos.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public static String md5(String paramString) throws NoSuchAlgorithmException {
        Object localObject = paramString;
        if (paramString != null) {
            localObject = MessageDigest.getInstance("MD5");
            ((MessageDigest)localObject).update(paramString.getBytes());
            paramString = new BigInteger(1, ((MessageDigest)localObject).digest()).toString(16);
            localObject = paramString;
            if (paramString.length() % 2 != 0) {
                localObject = "0" + paramString;
            }
        }
        return (String)localObject;
    }
}
