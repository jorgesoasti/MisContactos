package com.jorgesoasti.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgesoasti.miscontactos.R;
import com.jorgesoasti.miscontactos.adapter.ContactoAdaptador;
import com.jorgesoasti.miscontactos.poyo.Contacto;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 02/10/2017.
 */

public class RecyclerViewFragment extends android.support.v4.app.Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    public ContactoAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = v.findViewById(R.id.rvContactos);

        //Contactos en Linear Layout Manager

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Contactos en Grid Layout Manager
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        //listaContactos.setLayoutManager(glm);
        listaContactos.setLayoutManager(llm);

        inicializarListaContactos();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.contacto1,"Jorge Soasti", "0984998774", "jorge@gmail.com"));
        contactos.add(new Contacto(R.drawable.contacto1,"Karen Perez", "0984933374", "karen@gmail.com"));
        contactos.add(new Contacto(R.drawable.contacto1,"Marco Lopez", "0984922274", "marco@gmail.com"));
        contactos.add(new Contacto(R.drawable.contacto1,"María Jimenez", "0984991114", "maria@gmail.com"));
        contactos.add(new Contacto(R.drawable.contacto1,"Antonella Pesantez", "0984487774", "anto@gmail.com"));
    }
}
