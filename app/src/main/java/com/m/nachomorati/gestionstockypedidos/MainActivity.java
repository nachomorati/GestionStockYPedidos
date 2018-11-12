package com.m.nachomorati.gestionstockypedidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.etUsuario);
        password = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: implementar funcionalidad de login
                String txtUsuario = usuario.getText().toString();
                String txtPassword = password.getText().toString();
                if(txtUsuario.equals("usuario") && txtPassword.equals("123456")) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Usuario y/o contraseña no válidos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
