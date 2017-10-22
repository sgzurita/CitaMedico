package com.android.curso.myapplication;

public class PruebaBuilder {
    private String mNombre;

    public PruebaBuilder setNombre(String nombre) {
        mNombre = nombre;
        return this;
    }

    public Prueba createPrueba() {
        return new Prueba(mNombre);
    }
}