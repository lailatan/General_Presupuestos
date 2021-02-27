package com.company;

import java.util.*;

public class Negocio {
    private List<Elemento> elementos ;
    private Queue<Cliente> filaClientes ;
    private List<Presupuesto> presupuestos ;

    private Scanner sn;

    public Negocio() {
        inicializarElementos();
        filaClientes=new LinkedList<>();
        presupuestos =  new ArrayList<>();
        sn = new Scanner(System.in);
    }

    public void setFilaClientes(Queue<Cliente> filaClientes) {
        this.filaClientes.addAll(filaClientes);
    }

    public void agregarClienteALaFila(Cliente cliente){
        this.filaClientes.add(cliente);
    }

    public void iniciarAtencionCliente() {
        while (filaClientes.size()>0) {
            Presupuesto presupuesto=new Presupuesto(filaClientes.poll());
            iniciarMenuCliente(presupuesto);
            if (presupuesto.tieneItems())
                presupuestos.add(presupuesto);
        }
    }

    public void mostrarPresupuestosDelDia(){
        System.out.println("****************************************************************************************************************");
        System.out.println("Cierre del Dia. Total del Presupuestos: " + presupuestos.size() );
        System.out.println("****************************************************************************************************************");
        for (Presupuesto p:presupuestos){
            p.mostrarDatos();
        }
    }

    private void iniciarMenuCliente(Presupuesto  presupuesto) {
        Integer opcion = 1;
        //pedirdatosCliente();
        mostrarBienvenida(presupuesto);
        while (opcion != 0) {
            imprimirMenu();
            opcion = sn.nextInt();
            ejecutarOpcionMenu(opcion, presupuesto);
        }

    }

    private void mostrarBienvenida(Presupuesto presupuesto) {
        System.out.println("****************************************************************************************************************");
        System.out.println("Bienvenido a la tienda " + presupuesto.getCliente().getNombre() + "!!");
        System.out.println("Vamos a armar un presuesto a tu medida! Comencemos......");
    }

    private void mostrarDespedida(Presupuesto presupuesto) {
        System.out.println("****************************************************************************************************************");
        System.out.println(presupuesto.getCliente().getNombre() + ", te esperamos pronto!");
        System.out.println("Gracias por presupuestar con nosotros!! ");
        System.out.println("****************************************************************************************************************");
        System.out.println();
        System.out.println();
    }
/*
    private void pedirdatosCliente(){
        System.out.print("Ingrese su nombre: ");
        String nombre = sn.nextLine();
        cliente = new Cliente(nombre);
        presupuesto = new Presupuesto(cliente);
    }
*/

    private void ejecutarOpcionMenu(Integer opcion, Presupuesto presupuesto) {
        Item itemElegido;
        switch (opcion){
            case 1:
                Elemento elementoElegido=pedirElemento();
                if (elementoElegido!=null) {
                    Integer cantidad = pedirCantidad();
                    presupuesto.agregarItem(new Item(cantidad, elementoElegido));
                }
                break;
            case 2:
                if (presupuesto.tieneItems()){
                    itemElegido=pedirItemdelPresupuesto("Modificar", presupuesto);
                    if (itemElegido!=null) {
                        Integer cantidad = pedirCantidad();
                        presupuesto.modificarItem(itemElegido, cantidad);
                    }
                } else System.out.println("No hay items en el presupuesto todavía");
                break;
            case 3:
                if (presupuesto.tieneItems()){
                    itemElegido=pedirItemdelPresupuesto("Eliminar", presupuesto);
                    if (itemElegido!=null) {
                        presupuesto.eliminarItem(itemElegido);
                    }
                } else System.out.println("No hay items en el presupuesto todavía");
                break;
            case 4:
                presupuesto.mostrarDatos();
                break;
            case 0:
                mostrarDespedida(presupuesto);
        }
    }

    private Item pedirItemdelPresupuesto(String accion,Presupuesto  presupuesto) {
        Integer i ;
        Integer nroItem;
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        do {
            i=0;
            System.out.println("Seleccioná el Item a " + accion + ":");
            for (Item item : presupuesto.getItems()) {
                i++;
                System.out.print(i + ". ");
                item.mostrarDatos();
                ;
                System.out.println();
            }
            System.out.println("0.  - Ninguno.");
            System.out.print("Item --> ");
            nroItem = sn.nextInt();
        } while (nroItem<0 || nroItem>i);
        return (nroItem==0)?null:presupuesto.getItems().get(nroItem-1);
    }

    private Integer pedirCantidad() {
        Integer cantidad=0;
        while (cantidad<1) {
            System.out.print("Ingrese la cantidad: ");
            cantidad = sn.nextInt();
        }
        return cantidad;
    }

    private Elemento pedirElemento() {
        Integer i = 0;
        Integer nroElemento;
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        do {
            i=0;
            System.out.println("Seleccioná un Elemento:");
            for (Elemento e : elementos) {
                i++;
                System.out.print(i + ". ");
                e.mostrarDatos();
                System.out.println();
            }
            System.out.println("0.  - Ninguno.");
            System.out.print("Elemento --> ");
            nroElemento = sn.nextInt();
        } while (nroElemento<0 || nroElemento>i);
        return (nroElemento==0)?null:elementos.get(nroElemento-1);
    }

    private void imprimirMenu() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("Seleccioná la opcion que deseas:");
        System.out.println("1. Agregar elemento al Presupuesto.");
        System.out.println("2. Modificar elemento del Presupuesto.");
        System.out.println("3. Eliminar elemento del Presupuesto.");
        System.out.println("4. Cerrar Presupuesto.");
        System.out.println("0. Salir.");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.print("Opcion --> ");
    }

    private void inicializarElementos(){
        Tecnico tecnico1=new Tecnico("Adrián");
        Tecnico tecnico2=new Tecnico("Eduardo");

        elementos = new ArrayList<>();
        elementos.add(new Producto("BaseLed32","Base para TV Led 32' ",200.0 ));
        elementos.add(new Producto("BaseLed48","Base para TV Led 48' ",400.0 ));
        elementos.add(new Servicio("ColocacionLedPared","Colocación de TV Led en Pared",200.0,2,tecnico1));
        elementos.add(new Servicio("ColocacionLedTecho","Colocación de TV Led colgando del techo",300.0,2,tecnico2));
    }

}
