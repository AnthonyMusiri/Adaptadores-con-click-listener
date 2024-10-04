package com.example.taller2;

public class Personaje {
    private String nombre;
    private String urlImagen;

    public Personaje(String nombre, String urlImagen) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }
}
