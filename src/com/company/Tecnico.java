package com.company;

public class Tecnico extends Persona{
    public Tecnico(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Técnico: " + nombre);
    }
}
