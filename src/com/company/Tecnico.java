package com.company;

public class Tecnico extends Persona{
    public Tecnico(String nombre) {
        super(nombre);
    }

    @Override
    public void toStringDatos() {
        System.out.printf("%20s" , nombre);
    }
}
