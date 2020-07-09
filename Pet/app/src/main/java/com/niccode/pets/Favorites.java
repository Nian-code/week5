package com.niccode.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.niccode.pets.adaptador.Mascotas_Adaptador;
import com.niccode.pets.constructor.Mascotas;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {

    private String likes;
    private RecyclerView listaMascotas;



    ArrayList<Mascotas> ArraylistMascotas = new ArrayList<Mascotas>();
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFv);
        LinearLayoutManager vista = new LinearLayoutManager(this);
        vista.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(vista);
        iniciarLista();
        iniciarAdaptador();

    }


    public void iniciarLista() {

        ArraylistMascotas.add(new Mascotas(R.drawable.gatito1, "Shasha", 1));
        ArraylistMascotas.add(new Mascotas(R.drawable.gatito2, "Nugget", 2));
        ArraylistMascotas.add(new Mascotas(R.drawable.gatito3, "Michin", 3));
        ArraylistMascotas.add(new Mascotas(R.drawable.gatito4, "Pelusa", 4));
        ArraylistMascotas.add(new Mascotas(R.drawable.gatito5, "Misifu", 5));

    }

    public void iniciarAdaptador(){
        Mascotas_Adaptador adaptador = new Mascotas_Adaptador(ArraylistMascotas, activity);
        listaMascotas.setAdapter(adaptador);

    }

}


