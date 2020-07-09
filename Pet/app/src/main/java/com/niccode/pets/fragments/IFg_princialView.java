package com.niccode.pets.fragments;

import com.niccode.pets.adaptador.Mascotas_Adaptador;
import com.niccode.pets.constructor.Mascotas;

import java.util.ArrayList;

public interface IFg_princialView {

    public  void  generarLinearLayoutVertical();

    public Mascotas_Adaptador crearAdaptador (ArrayList<Mascotas> Mascotas);

    public void inicializarAdaptadorRV(Mascotas_Adaptador adaptador);

}
