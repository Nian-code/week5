package com.niccode.pets.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niccode.pets.R;
import com.niccode.pets.adaptador.Mascotas_Adaptador;
import com.niccode.pets.constructor.ConstructorMascotas;
import com.niccode.pets.constructor.Mascotas;
import com.niccode.pets.presentador.Fg_princialPresenter;
import com.niccode.pets.presentador.IFg_princialPresenter;

import java.util.ArrayList;


public class Fg_principal extends Fragment  implements IFg_princialView {


    private ArrayList<Mascotas> ArraylistMascotas;
    private RecyclerView recyclerView;
    private IFg_princialPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_principal, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recly);

        presenter = new Fg_princialPresenter(this, getContext());
        return v;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager vista = new LinearLayoutManager(getActivity());
        vista.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(vista);

    }

    @Override
    public Mascotas_Adaptador crearAdaptador(ArrayList<Mascotas> Mascotas) {
        Mascotas_Adaptador adaptador = new Mascotas_Adaptador(Mascotas, getActivity());
        return  adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Mascotas_Adaptador adaptador) {
        recyclerView.setAdapter(adaptador);
    }


}