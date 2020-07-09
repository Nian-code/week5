package com.niccode.pets.constructor;

import android.content.ContentValues;
import android.content.Context;

import com.niccode.pets.R;
import com.niccode.pets.db.BaseDatos;
import com.niccode.pets.db.Constantesdb;

import java.util.ArrayList;



public class ConstructorMascotas {


    private static final int LIKES = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;

    }

    public ArrayList<Mascotas> obtenerDatos() {

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();

    }

    public void insertarMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constantesdb.TABLA_MASCOTAS_NOMBRE, "Shasha");
        contentValues.put(Constantesdb.TABLA_MASCOTAS_FOTO, R.drawable.gatito1);

        db.insertarDatos(contentValues);

        contentValues.put(Constantesdb.TABLA_MASCOTAS_NOMBRE, "Nuget");
        contentValues.put(Constantesdb.TABLA_MASCOTAS_FOTO, R.drawable.gatito2);

        db.insertarDatos(contentValues);

        contentValues.put(Constantesdb.TABLA_MASCOTAS_NOMBRE, "Michin");
        contentValues.put(Constantesdb.TABLA_MASCOTAS_FOTO, R.drawable.gatito3);

        db.insertarDatos(contentValues);

        contentValues.put(Constantesdb.TABLA_MASCOTAS_NOMBRE, "Pepa");
        contentValues.put(Constantesdb.TABLA_MASCOTAS_FOTO, R.drawable.gatito4);
        db.insertarDatos(contentValues);


        contentValues.put(Constantesdb.TABLA_MASCOTAS_NOMBRE, "Misifu");
        contentValues.put(Constantesdb.TABLA_MASCOTAS_FOTO, R.drawable.gatito5);

        db.insertarDatos(contentValues);

        contentValues.put(Constantesdb.TABLA_MASCOTAS_NOMBRE, "Shasha");
        contentValues.put(Constantesdb.TABLA_MASCOTAS_FOTO, R.drawable.gatito1);

        db.insertarDatos(contentValues);

    }

    public void darlike(Mascotas mascotas) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantesdb.TABLA_MASCOTAS_LIKES_ID_MAS, mascotas.getID());
        contentValues.put(Constantesdb.TABLA_MASCOTAS_NUMERO_LIKES, LIKES);
        db.insertarLike(contentValues);
    }

    public int obtenerLikes(Mascotas mascotas) {
        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesMascotas(mascotas);

    }


}