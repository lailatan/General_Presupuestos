package com.company;

public class Item {
        private Integer cantidad;
        private Elemento elemento;

    public Item(Integer cantidad, Elemento elemento) {
        this.cantidad = cantidad;
        this.elemento = elemento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void agregarCantidad(Integer cantidad) {
        this.cantidad += cantidad;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Double calcularTotal(){
        return elemento.getPrecio()*cantidad;
    }

    public void mostrarDatos(){
        System.out.print("Cantidad: " + cantidad);
        elemento.mostrarDatos();
        System.out.print(" - Precio Subtotal:" + calcularTotal());
    }
}
