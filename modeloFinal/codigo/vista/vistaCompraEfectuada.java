package modelo.vista;

import modelo.DTO.FuncionDTO;
import modelo.controlador.DescuentoController;
import modelo.controlador.FuncionController;
import modelo.modelo.Combo;
import modelo.modelo.Funcion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class vistaCompraEfectuada extends JDialog {
    private JPanel pnlCompraEfectuada;
    private JTable table1;
    private DescuentoController desc = DescuentoController.getInstancia();
    private FuncionController func = FuncionController.getInstances();

    public vistaCompraEfectuada(int eleccion) {
        this.setContentPane(this.pnlCompraEfectuada);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        Object[][] data = convertDtoToData(desc.getCombos());
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"id","precio","descripcion"});
        table1.setModel(model);
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                func.actualizarAsientoSala(eleccion);
                JOptionPane.showMessageDialog(JOptionPane.getDesktopPaneForComponent(null),"Compra efectuada. Muchas gracias.");
            }
        });
    }



    public String[][] convertDtoToData(List<Combo> list) {
        String[][] data = new String[list.size() + 1][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = Integer.toString(list.get(i).getComboID());
            data[i][1] = Float.toString(list.get(i).getPrecio());
            data[i][2] = list.get(i).getDescripcion();
        }
        data[list.size()][0] = "Sin combo";
        data[list.size()][1] = "0.0";
        return data;
    }
}