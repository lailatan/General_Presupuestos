package com.company;

public abstract class Persona {
    protected String nombre;

    public Persona(String nombre) {
        nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarDatos();
}
