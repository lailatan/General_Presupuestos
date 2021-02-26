package com.company;

public class Cliente extends Persona{

    public Cliente(String nombre) {
        super(nombre);
    }

    @Override
    public void toStringDatos() {
        System.out.printf("%20s" , nombre);
    }
}
