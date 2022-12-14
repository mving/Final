package modelo.vista;

import modelo.DTO.FuncionDTO;
import modelo.controlador.FuncionController;
import modelo.modelo.TipoGenero;
import modelo.modelo.TipoProyeccion;
import modelo.controlador.PeliculasController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class vistaAdquirirPelicula extends JFrame{
    private JButton button1;
    private JPanel pnlPrincipal;
    private JComboBox genero;
    private JComboBox tipo;
    private JTable table1;
    private JComboBox duracion;
    private JComboBox director;
    private JComboBox actores;
    private JTextField textField1;
    private vistaAdquirirPelicula self;
    private PeliculasController pelisController;
    private FuncionController funcionController;

    public vistaAdquirirPelicula(String titulo) {
        super(titulo);
        this.setContentPane(this.pnlPrincipal);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        this.self = this;
        pelisController = PeliculasController.getInstances();
        funcionController = FuncionController.getInstances();

        genero.setModel(new DefaultComboBoxModel<TipoGenero>(TipoGenero.values()));
        tipo.setModel(new DefaultComboBoxModel<TipoProyeccion>(TipoProyeccion.values()));
        String[] duraciones = {"< 1 hora","< 2 horas","< 3 horas","< 4 horas"};
        duracion.setModel(new DefaultComboBoxModel<String>(duraciones));
        actores.setModel(new DefaultComboBoxModel<String>(pelisController.getActores().toArray(new String[0])));
        director.setModel(new DefaultComboBoxModel<String>(pelisController.getDirectores().toArray(new String[0])));


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dmax = 0;
                String d = duracion.getSelectedItem().toString();
                switch (d) {
                    case "< 1 hora":
                        dmax = 1;
                        break;
                    case "< 2 horas":
                        dmax = 2;
                        break;
                    case "< 3 horas":
                        dmax = 3;
                        break;
                    default:
                        dmax = 4;
                }
                TipoProyeccion tipoProy = (TipoProyeccion) tipo.getSelectedItem();
                TipoGenero tipoGen = (TipoGenero) genero.getSelectedItem();
                String actoresSel = actores.getSelectedItem().toString();
                String directorSel = director.getSelectedItem().toString();

                Object[][] data = convertDtoToData(funcionController.getFuncionesCondiciones(tipoGen,tipoProy,dmax));
                DefaultTableModel model = new DefaultTableModel(data, new String[]{"Pelicula","Horario","Asientos","ID sala"});
                table1.setModel(model);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int s = table1.getSelectedRow();
                // se guarda el codigo de la funcion seleccionada
                int eleccion = Integer.valueOf(table1.getValueAt(s,3).toString());
                vistaCompraEfectuada frame2 = new vistaCompraEfectuada(eleccion);
                frame2.setVisible(true);
            }
        });
    }

    public String[][] convertDtoToData(List<FuncionDTO> list) {
        String[][] data = new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getPelicula().getNombrePelicula();
            data[i][1] = list.get(i).getHorario();
            data[i][2] = Integer.toString(list.get(i).getCantidadAsientosDisponibles());
            data[i][3] = Integer.toString(list.get(i).getFuncionID());

        }
        return data;
    }

    public static void main(String[] args) {
        vistaAdquirirPelicula frame = new vistaAdquirirPelicula("");
        frame.setVisible(true);
    }

}
