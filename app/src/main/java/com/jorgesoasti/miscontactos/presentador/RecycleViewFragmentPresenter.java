package com.jorgesoasti.miscontactos.presentador;

import android.content.Context;

import com.jorgesoasti.miscontactos.db.ConstructorContactos;
import com.jorgesoasti.miscontactos.fragment.IRecyclerViewFragmentView;
import com.jorgesoasti.miscontactos.poyo.Contacto;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 06/10/2017.
 */

public class RecycleViewFragmentPresenter implements IRecycleViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecycleViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
