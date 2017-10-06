package com.jorgesoasti.miscontactos.db;

/**
 * Created by jorge.soasti on 06/10/2017.
 */

public final class ConstanteBaseDatos {

    public static final String DATA_BASE_NAME = "contactos";
    public static final int DATABASE_VESION = 1;

    public static final String TABLE_CONTACTS = "contacto";
    public static final String TABLE_CONTACTS_ID = "id";
    public static final String TABLE_CONTACTS_NOMBRE = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO = "telefono";
    public static final String TABLE_CONTACTS_EMAIL = "email";
    public static final String TABLE_CONTACTS_FOTO = "foto";

    public static final String TABLE_LIKE_CONTACT = "contacto_likes";
    public static final String TABLE_LIKE_CONTACT_ID = "id";
    public static final String TABLE_LIKE_CONTACT_ID_CONTACTO = "contacto";
    public static final String TABLE_LIKE_CONTACT_NO_LIKES = "numero_likes";
}
