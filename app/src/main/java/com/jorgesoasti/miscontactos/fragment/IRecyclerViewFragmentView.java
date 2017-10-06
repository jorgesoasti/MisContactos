package com.jorgesoasti.miscontactos.fragment;

import com.jorgesoasti.miscontactos.adapter.ContactoAdaptador;
import com.jorgesoasti.miscontactos.poyo.Contacto;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 06/10/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
