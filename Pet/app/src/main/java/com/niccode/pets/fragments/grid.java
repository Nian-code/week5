package com.niccode.pets.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niccode.pets.R;
import com.niccode.pets.adaptador.Mascotas_Adaptador;
import com.niccode.pets.adaptador.Perfil_Adapter;
import com.niccode.pets.constructor.ConstructorMascotas;
import com.niccode.pets.constructor.Mascotas;
import com.niccode.pets.presentador.Fg_GridPresenter;

import java.util.ArrayList;

public class grid extends Fragment implements Igrid {

    private Fg_GridPresenter presenter;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascotas> ArraylistMascotas = new ArrayList<Mascotas>();
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_grid, container, false);

        listaMascotas = v.findViewById(R.id.girdRv);
        presenter = new Fg_GridPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarGridLayoutVertical() {
        GridLayoutManager vista = new GridLayoutManager(getActivity(), 2);
        listaMascotas.setLayoutManager(vista);

    }

    @Override
    public  Perfil_Adapter crearAdaptador(ArrayList<Mascotas> Mascotas) {
        Perfil_Adapter adaptador = new Perfil_Adapter(Mascotas);
        return  adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Perfil_Adapter adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}

