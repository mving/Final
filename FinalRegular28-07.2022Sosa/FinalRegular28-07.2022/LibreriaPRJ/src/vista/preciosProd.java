package vista;

import Controller.ClienteController;
import Controller.VentasController;
import DTO.ListaPrecioDTO;
import DTO.ProductoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class preciosProd extends JDialog {
    private JPanel pnlPreciosProd;
    private JTable tablaPreciosProd;
    private JButton buscarButton;
    private JComboBox comboProductos;
    private VentasController controllerVenta;
    private ClienteController controllerCliente;

    public preciosProd() {
        this.setContentPane(this.pnlPreciosProd);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        controllerVenta.getInstances();
        String[] data = convertDtoToData(controllerVenta.getAllProducto());
        comboProductos.setModel(new DefaultComboBoxModel<String>(data));


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerCliente.getInstances();
                ;
                // se buscan todas las apariciones del producto en las listas
                ArrayList<ProductoDTO> listaPre = null;
                try {
                    listaPre = controllerCliente.getAllListaP_producto(controllerVenta.idProdtoProd((Integer) comboProductos.getSelectedItem()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                Object[][] data2 = convertDtoToDataTabla(listaPre);
                DefaultTableModel model = new DefaultTableModel(data2, new String[]{"lista precio", "precio"});
                tablaPreciosProd.setModel(model);
            }
        });
    }

    public String[] convertDtoToData(List<ProductoDTO> list) {
        String[] data = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            data[i] = String.valueOf(list.get(i).getProductoID());
        }
        return data;
    }


    public Object[][] convertDtoToDataTabla(List<ProductoDTO> list) {
        Object[][] data = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getProductoID();
            data[i][1] = list.get(i).getPrecioUnitario();
        }
        return data;
    }
}