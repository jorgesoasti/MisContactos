package com.jorgesoasti.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgesoasti.miscontactos.R;
import com.jorgesoasti.miscontactos.adapter.ContactoAdaptador;
import com.jorgesoasti.miscontactos.poyo.Contacto;
import com.jorgesoasti.miscontactos.presentador.IRecycleViewFragmentPresenter;
import com.jorgesoasti.miscontactos.presentador.RecycleViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by jorge.soasti on 02/10/2017.
 */

public class RecyclerViewFragment extends android.support.v4.app.Fragment implements IRecyclerViewFragmentView{

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecycleViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvContactos = v.findViewById(R.id.rvContactos);
        presenter = new RecycleViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
