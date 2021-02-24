package com.company;

public abstract class Elemento implements IElemento {
    protected String nombre;
    protected String descripcion;

    public Elemento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
