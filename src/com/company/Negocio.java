package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Negocio {
    private List<Elemento> elementos = new ArrayList<>();
    private Cliente cliente;
    private Presupuesto presupuesto;

    public Negocio() {
        inicializarElementos();
    }

    public void iniciarMenuCliente() {
        Integer opcion = 1;
        Scanner sn = new Scanner(System.in);
        pedirdatosCliente();
        while (opcion != 0) {
            imprimirMenu();
            opcion = sn.nextInt();
            ejecutarOpcionMenu(opcion);
        }

    }

    private void pedirdatosCliente(){
        Scanner sn = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = sn.nextLine();
        cliente = new Cliente(nombre);
        presupuesto = new Presupuesto(cliente);
    }

    private void ejecutarOpcionMenu(Integer opcion) {
        switch (opcion){
            case 1:
                Elemento elementoElegido=pedirElemento();
                if (elementoElegido!=null) {
                    Integer cantidad = pedirCantidad();
                    presupuesto.agregarItem(new Item(cantidad, elementoElegido));
                }
                break;
            case 4:
                presupuesto.mostrarDatos();
                break;
        }
    }

    private Integer pedirCantidad() {
        Integer cantidad=0;
        while (cantidad<1) {
            System.out.print("Ingrese la cantidad:");
            Scanner sn = new Scanner(System.in);
            cantidad = sn.nextInt();
        }
        return cantidad;
    }

    private Elemento pedirElemento() {
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

    private void imprimirMenu() {
        System.out.println("Seleccione la opcion deseada:");
        System.out.println("1. Agregar elemento al Presupuesto.");
        System.out.println("2. Modificar elemento del Presupuesto.");
        System.out.println("3. Eliminar elemento del Presupuesto.");
        System.out.println("4. Consultar Presupuesto.");
        System.out.println("5. Cerrar Presupuesto.");
        System.out.println("0. Salir.");
    }

    private void inicializarElementos(){
        Tecnico tecnico1=new Tecnico("Adrián");
        Tecnico tecnico2=new Tecnico("Eduardo");

        elementos.add(new Producto("BaseLed32","Base para TV Led 32' ",200.0 ));
        elementos.add(new Producto("BaseLed48","Base para TV Led 48' ",400.0 ));
        elementos.add(new Servicio("ColocacionLedPared","Colocación de TV Led en Pared",200.0,2,tecnico1));
        elementos.add(new Servicio("ColocacionLedTecho","Colocación de TV Led colgando del techo",300.0,2,tecnico2));
    }
}
