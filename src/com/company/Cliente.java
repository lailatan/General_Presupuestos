package com.company;

public class Cliente extends Persona{

    public Cliente(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre Cliente: " + nombre);
    }
}
