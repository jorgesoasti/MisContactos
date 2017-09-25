package com.jorgesoasti.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<>();

        contactos.add(new Contacto("Jorge Soasti", "0984998774", "jorge@gmail.com"));
        contactos.add(new Contacto("Karen Perez", "0984933374", "karen@gmail.com"));
        contactos.add(new Contacto("Marco Lopez", "0984922274", "marco@gmail.com"));
        contactos.add(new Contacto("María Jimenez", "0984991114", "maria@gmail.com"));
        contactos.add(new Contacto("Antonella Pesantez", "0984487774", "anto@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        
        ListView lstContactos = (ListView) findViewById(R.id.lstListaContactos);
        lstContactos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });
    }
}
