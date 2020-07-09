package com.niccode.pets.db;

import android.content.Context;

import com.niccode.pets.R;
import com.niccode.pets.constructor.Mascotas;

import java.util.ArrayList;

public final class Constantesdb {

    public static final String DATABASE_NAME = "mascotas";
    public static final int    DATABASE_VERSION = 1;

    public static final String TABLA_MASCOTAS               = "mascota" ;
    public static final String TABLA_MASCOTAS_ID            = "id";
    public static final String TABLA_MASCOTAS_NOMBRE        = "nombre";
    public static final String TABLA_MASCOTAS_FOTO          = "foto";


    public static final String TABLA_MASCOTAS_LIKES         = "mascotas_likes";
    public static final String TABLA_MASCOTAS_LIKES_ID      = "id";
    public static final String TABLA_MASCOTAS_LIKES_ID_MAS  = "id_mascotas";
    public static final String TABLA_MASCOTAS_NUMERO_LIKES  =  "numero_likes";

}
