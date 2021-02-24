package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Presupuesto {
        private Cliente cliente;
        private List<Item> items;

    public Presupuesto(Cliente cliente) {
        this.cliente = cliente;
        items=new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public void sacarItem(Item item) {
        this.items.remove(item);
    }

    public void modificarItem(Item item) {
        //this.items.(item);
        System.out.println("HACER MODIFICAR");
    }

    public Double calcularTotal(){
        Double total=0.0;
        for (Item i:items) total += i.calcularTotal();
        return total;
    }

    public void mostrarDatos(){
        System.out.print("Items en el presupuesto de ");
        cliente.mostrarDatos();
        System.out.println();
        for (Item i:items) {
            i.mostrarDatos();
            System.out.println();
        }
        System.out.println("Costo Total del Presupuesto: " + calcularTotal());
    }
}
