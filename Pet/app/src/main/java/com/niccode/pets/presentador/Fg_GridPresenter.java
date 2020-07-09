package com.niccode.pets.presentador;

import android.content.Context;

import com.niccode.pets.constructor.ConstructorMascotas;
import com.niccode.pets.constructor.Mascotas;
import com.niccode.pets.fragments.IFg_princialView;
import com.niccode.pets.fragments.Igrid;

import java.util.ArrayList;

public class Fg_GridPresenter implements IFg_princialPresenter {

    private Igrid igrid;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public Fg_GridPresenter(Igrid igrid, Context context) {
        this.igrid = igrid;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas =  new ConstructorMascotas(context);
        mascotas  = constructorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        igrid.inicializarAdaptadorRV(igrid.crearAdaptador(mascotas));
        igrid.generarGridLayoutVertical();
    }
}
