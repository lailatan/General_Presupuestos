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
        Item itemExistente=buscarEnelpresupuesto(item);
        if (itemExistente!=null) itemExistente.agregarCantidad(item.getCantidad());
        else this.items.add(item);
    }

    private Item buscarEnelpresupuesto(Item item) {
        for (Item i:items){
            if (i.getElemento().equals(item.getElemento())) return i;
        }
        return null;
    }

    public void eliminarItem(Item item) {
        this.items.remove(item);
    }

    public void modificarItem(Item item,Integer cantidad) {
        item.setCantidad(cantidad);
    }

    public Double calcularTotal(){
        Double total=0.0;
        for (Item i:items) total += i.calcularTotal();
        return total;
    }

    public void mostrarDatos(){
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.print("Items en el presupuesto de ");
        cliente.toStringDatos();
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        for (Item i:items) {
            i.mostrarDatos();
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("Costo Total del Presupuesto: " + calcularTotal());
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    public boolean tieneItems() {
        return items.size()>0;
    }
}
