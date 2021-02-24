package com.company;

public class Servicio extends Elemento{
    private Double precioHora;
    private Integer cantidadHoras;
    private Tecnico tecnico;

    public Servicio(String nombre, String descripcion, Double precioHora, Integer cantidadHoras, Tecnico tecnico) {
        super(nombre, descripcion);
        this.precioHora = precioHora;
        this.cantidadHoras = cantidadHoras;
        this.tecnico = tecnico;
    }


    public Double getPrecioHora() {
        return precioHora;
    }

    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    @Override
    public Double getPrecio(){
        return cantidadHoras*precioHora;
    }

    @Override
    public void mostrarDatos() {
        System.out.print(" Nombre: " + nombre);
        System.out.print(" Descripcion: " + descripcion);
        System.out.print(" Precio Hora: " + precioHora);
        System.out.print(" Cantidad Hora: " + cantidadHoras);
        System.out.print(" Precio: " + getPrecio());

    }
}
