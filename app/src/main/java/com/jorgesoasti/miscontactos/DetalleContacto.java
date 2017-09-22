package com.jorgesoasti.miscontactos;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
        String telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        String email = parametros.getString(getResources().getString(R.string.pEmail));

        TextView tvNombre = (TextView) findViewById(R.id.tvNombrePersona);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefonoPersona);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmailPersona);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }
}
