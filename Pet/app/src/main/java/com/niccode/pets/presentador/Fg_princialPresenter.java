package com.niccode.pets.presentador;

import android.app.Activity;
import android.content.Context;
import com.niccode.pets.constructor.ConstructorMascotas;
import com.niccode.pets.constructor.Mascotas;
import com.niccode.pets.fragments.IFg_princialView;

import java.util.ArrayList;

public class Fg_princialPresenter implements IFg_princialPresenter{

    private IFg_princialView iFg_princialView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public Fg_princialPresenter(IFg_princialView iFg_princialView, Context context) {
        this.iFg_princialView = iFg_princialView;
        this.context    = context;
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
        iFg_princialView.inicializarAdaptadorRV(iFg_princialView.crearAdaptador(mascotas));
        iFg_princialView.generarLinearLayoutVertical();
    }


}
