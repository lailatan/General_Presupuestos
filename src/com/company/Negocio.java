package com.company;

/*
Crear un sistema que tenga una interfaz que permita al usuario indicar desde un menú lo siguiente:

1) Si quiere agregar elementos al presupuesto.
2) Si quiere modificar un elemento.
3) Si quiere eliminar un elemento.

Los elementos/ítems pueden ser productos o servicios.
Cada producto tiene una cantidad, un precio unitario, un nombre y una descripción.
Cada servicio tiene un costo por hora y una cantidad de horas. Además del nombre del servicio,
el nombre de la persona que lo ejecuta y una descripción.

Una vez que el presupuesto está listo (el usuario decide finalizar), mostrar el presupuesto total y
el detalle de todos los ítems agregados.
Items --> Producto
           Servicio
Persona --> Cliente
            Técnico
Presupuesto -- Lista de Items
                Cliente
 */

import java.util.*;

public class Negocio {

    public static void main(String[] args) {
        Integer opcion=1;
        List<Elemento> elementos = new ArrayList<>();
        Cliente cliente;
        Presupuesto presupuesto;

        inicializarElementos(elementos);

        Scanner sn = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre=sn.nextLine();
        cliente = new Cliente(nombre);
        presupuesto = new Presupuesto(cliente);


        while (opcion!=0){
            imprimirMenu();
            opcion = sn.nextInt();

            ejecutarOpcionMenu(opcion,elementos,presupuesto);
        }


    }

    private static void ejecutarOpcionMenu(Integer opcion, List<Elemento> elementos,Presupuesto presupuesto) {
        switch (opcion){
            case 1:
                Elemento elementoElegido=pedirElemento(elementos);
                if (elementoElegido!=null) {
                    Integer cantidad = pedirCantidad();
                    presupuesto.agregarItem(new Item(cantidad, elementoElegido));
                }
                break;
            case 4:
                presupuesto.mostrarDatos();
        }
    }

    private static Integer pedirCantidad() {
        Integer cantidad=0;
        while (cantidad<1) {
            System.out.print("Ingrese la cantidad:");
            Scanner sn = new Scanner(System.in);
            cantidad = sn.nextInt();
        }
        return cantidad;
    }

    private static Elemento pedirElemento(List<Elemento> elementos) {
        Integer i = 1;
        System.out.println("Seleccione un Elemento:");
        System.out.println("0. Ninguno.");
        for (Elemento e:elementos) {
            System.out.print(i + ". ");
            e.mostrarDatos();
            System.out.println();
            i++;
        }
        Scanner sn = new Scanner(System.in);
        Integer nroElemento=sn.nextInt();
        return (nroElemento==0)?null:elementos.get(nroElemento);
    }

    private static void imprimirMenu() {
        System.out.println("Seleccione la opcion deseada:");
        System.out.println("1. Agregar elemento al Presupuesto.");
        System.out.println("2. Modificar elemento del Presupuesto.");
        System.out.println("3. Eliminar elemento del Presupuesto.");
        System.out.println("4. Consultar Presupuesto.");
        System.out.println("5. Cerrar Presupuesto.");
        System.out.println("0. Salir.");
    }

    private static void inicializarElementos(List<Elemento> elementos){
        Tecnico tecnico1=new Tecnico("Adrián");
        Tecnico tecnico2=new Tecnico("Eduardo");

        elementos.add(new Producto("BaseLed32","Base para TV Led 32' ",200.0 ));
        elementos.add(new Producto("BaseLed48","Base para TV Led 48' ",400.0 ));
        elementos.add(new Servicio("ColocacionLedPared","Colocación de TV Led en Pared",200.0,2,tecnico1));
        elementos.add(new Servicio("ColocacionLedTecho","Colocación de TV Led colgando del techo",300.0,2,tecnico2));
    }

}

