package com.niccode.pets.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.niccode.pets.R;
import com.niccode.pets.constructor.Mascotas;

import java.util.ArrayList;

public class Perfil_Adapter  extends RecyclerView.Adapter<Perfil_Adapter.PerfilViewHolder>{

    ArrayList<com.niccode.pets.constructor.Mascotas> Mascotas;

    public Perfil_Adapter (ArrayList<Mascotas> Mascotas){
        this.Mascotas = Mascotas;
    }

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilViewHolder Perfilholder, int position) {
        final Mascotas mascotas = Mascotas.get(position);
        Perfilholder.imgFoto.setImageResource(mascotas.getFoto());
        Perfilholder.tvLikes.setText(String.valueOf(mascotas.getLikes()));


    }

    @Override
    public int getItemCount() {
        return Mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView       imgFoto;
        private TextView        tvLikes;
        private ImageView imgFotoperfil;
        private TextView tvNombrePerfil;




        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (ImageView)     itemView.findViewById(R.id.imgGatitoGrid);
            tvLikes         = (TextView)      itemView.findViewById(R.id.likesGrid);

            imgFotoperfil   = (ImageView)     itemView.findViewById(R.id.imgGatitoPerfil);
            tvNombrePerfil  = (TextView)      itemView.findViewById(R.id.nombre);

        }
    }
}
