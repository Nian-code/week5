package com.niccode.pets.constructor;



public class Mascotas {
    private int foto;
    private String nombre;
    private int likes;
    private int ID;

    public Mascotas(int foto, String nombre, int likes) {
        this.foto     = foto;
        this.nombre   = nombre;
        this.likes    = likes;
    }

    public Mascotas() {

    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


}



