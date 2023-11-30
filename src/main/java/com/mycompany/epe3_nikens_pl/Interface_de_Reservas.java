
package com.mycompany.epe3_nikens_pl;

// Imporataciones
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Interface_de_Reservas extends JFrame {
    private ArrayList<ReservasMedicass > reservaciones;
    private JTable table;
    private DefaultTableModel tableModel;

    public Interface_de_Reservas(ArrayList<ReservasMedicass > reservaciones) {
        this.reservaciones = reservaciones;

        setTitle("Reservas Hechas");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Configuración de la tabla
        String[] columnNames = {"Médico", "Paciente", "Especialidad", "Hora", "Valor"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Botón cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Interface_de_Reservas.this.dispose();
            }
        });
        add(btnCerrar, BorderLayout.SOUTH);

        // Cargar datos en la tabla
        cargarDatosEnTabla();

        setVisible(true);
    }

    private void cargarDatosEnTabla() {
        for (ReservasMedicass citas : reservaciones) {
            tableModel.addRow(new Object[]{
                    citas.getNombreMedico(),
                    citas.getNombrePaciente(),
                    citas.getEspecialidad(),
                    citas.getHora(),
                    citas.getValorHora()
            });
        }
    }
}
