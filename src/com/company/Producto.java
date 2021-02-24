package com.company;

public class Producto extends Elemento{
            private Double precio;

    public Producto(String nombre, String descripcion,Double precio) {
        super(nombre, descripcion);
        this.precio=precio;
    }

    @Override
    public Double getPrecio() {
        return precio;
    }

    @Override
    public void mostrarDatos() {
        System.out.print(" Nombre: " + nombre);
        System.out.print(" Descripcion: " + descripcion);
        System.out.print(" Precio: " + precio);
    }
}
