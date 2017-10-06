package com.jorgesoasti.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.jorgesoasti.miscontactos.R;
import com.jorgesoasti.miscontactos.poyo.Contacto;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 06/10/2017.
 */

public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){

        /*
        ArrayList<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.contacto1,"Jorge Soasti", "0984998774", "jorge@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.contacto1,"Karen Perez", "0984933374", "karen@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.contacto1,"Marco Lopez", "0984922274", "marco@gmail.com", 11));
        contactos.add(new Contacto(R.drawable.contacto1,"María Jimenez", "0984991114", "maria@gmail.com", 7));
        contactos.add(new Contacto(R.drawable.contacto1,"Antonella Pesantez", "0984487774", "anto@gmail.com", 2));

        return contactos;
        */

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE, "Jorge Soasti");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "0984998774");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "jorge@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.contacto1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE, "Karen Perez");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "0984933374");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "karen@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.contacto1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NOMBRE, "Marco Lopez");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "0984922274");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "marco@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.contacto1);

        db.insertarContacto(contentValues);
    }
}
