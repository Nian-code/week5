package com.niccode.pets.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.niccode.pets.constructor.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, Constantesdb.DATABASE_NAME, null, Constantesdb.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascotas = "CREATE TABLE " + Constantesdb.TABLA_MASCOTAS + "(" +
                                    Constantesdb.TABLA_MASCOTAS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    Constantesdb.TABLA_MASCOTAS_NOMBRE + " TEXT, "    +
                                    Constantesdb.TABLA_MASCOTAS_FOTO   + " INTEGER"  +
                ")";

        String queryCrearTablaLikes    = "CREATE TABLE "     + Constantesdb.TABLA_MASCOTAS_LIKES + "(" +
                                         Constantesdb.TABLA_MASCOTAS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         Constantesdb.TABLA_MASCOTAS_LIKES_ID_MAS  + " INTEGER, " +
                                         Constantesdb.TABLA_MASCOTAS_NUMERO_LIKES  + " INTEGER, " +
                                         "FOREIGN KEY (" + Constantesdb.TABLA_MASCOTAS_LIKES_ID_MAS + ") " +
                                         "REFERENCES "   + Constantesdb.TABLA_MASCOTAS + "(" + Constantesdb.TABLA_MASCOTAS_ID + ")" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
        sqLiteDatabase.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "    + Constantesdb.TABLA_MASCOTAS );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "    + Constantesdb.TABLA_MASCOTAS_LIKES);
        onCreate(sqLiteDatabase);

    }
    public ArrayList<Mascotas> obtenerTodasLasMascotas() {

        ArrayList<Mascotas> ArraylistMascotas = new ArrayList<>();

        String query = "SELECT * FROM "  + Constantesdb.TABLA_MASCOTAS ;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registro  = sqLiteDatabase.rawQuery(query , null);

        while (registro.moveToNext()){

            Mascotas mascotas_actual = new Mascotas();

            mascotas_actual.setID(registro.getInt(0));
            mascotas_actual.setNombre(registro.getString(1));
            mascotas_actual.setFoto(registro.getInt(2));

            String queryLikes = "SELECT COUNT("+Constantesdb.TABLA_MASCOTAS_NUMERO_LIKES+") as likes " +
                    " FROM " +  Constantesdb.TABLA_MASCOTAS_LIKES +
                    " WHERE " + Constantesdb.TABLA_MASCOTAS_LIKES_ID_MAS + "=" + mascotas_actual.getID();



            Cursor registrosLikes = sqLiteDatabase.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotas_actual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotas_actual.setLikes(0);
            }

            ArraylistMascotas.add(mascotas_actual);
        }

        sqLiteDatabase.close();
        return ArraylistMascotas;


    }
        public void insertarDatos(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase  = this.getWritableDatabase();
        sqLiteDatabase.insert(Constantesdb.TABLA_MASCOTAS,null, contentValues);
        sqLiteDatabase.close();

    }

        public void insertarLike(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(Constantesdb.TABLA_MASCOTAS_LIKES, null, contentValues);
        sqLiteDatabase.close();
    }

        public int  obtenerLikesMascotas(Mascotas mascotas){
            int likes = 0;
            String query =  "SELECT COUNT("+ Constantesdb.TABLA_MASCOTAS_NUMERO_LIKES + ")" +
                            " FROM " + Constantesdb.TABLA_MASCOTAS_LIKES +
                            " WHERE " + Constantesdb.TABLA_MASCOTAS_LIKES_ID_MAS  + "=" + mascotas.getID();

            SQLiteDatabase  sqLiteDatabase = this.getWritableDatabase();
            Cursor registro = sqLiteDatabase.rawQuery(query, null);


            if(registro.moveToNext()){
                likes = registro.getInt(0);
            }
            sqLiteDatabase.close();
            return likes;
        }

}
