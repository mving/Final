package test;

import Controller.ClienteController;
import Controller.PagosController;

public class testAgregarPagos {
    private static PagosController controllerPagos;

    public static void main(String[] args) {
        controllerPagos.getInstances();
        controllerPagos.datosPruebaPagos();
    }
}
