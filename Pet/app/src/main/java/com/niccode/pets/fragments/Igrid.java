package com.niccode.pets.fragments;

import com.niccode.pets.adaptador.Mascotas_Adaptador;
import com.niccode.pets.adaptador.Perfil_Adapter;
import com.niccode.pets.constructor.Mascotas;

import java.util.ArrayList;

public interface Igrid {

    public  void  generarGridLayoutVertical();

    public Perfil_Adapter crearAdaptador (ArrayList<Mascotas> Mascotas);

    public void inicializarAdaptadorRV(Perfil_Adapter adaptador);
}
