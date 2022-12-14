package modelo.test;

import modelo.controlador.FuncionController;

public class testAsientos {
    public static void main(String[] args) {
        FuncionController controller = FuncionController.getInstances();
        controller.obtenerAsientosDisponiblePorFuncion(123);
    }
}
