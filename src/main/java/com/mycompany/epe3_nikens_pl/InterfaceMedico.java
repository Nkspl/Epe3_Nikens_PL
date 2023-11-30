
package com.mycompany.epe3_nikens_pl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class InterfaceMedico extends JFrame {
    private ArrayList<ReservasMedicass > reservaciones;
    private JComboBox<String>cbNombreMedico;
   // private JTextField txtNombreMedico;
    private JTextField txtNombrePaciente;
    private JComboBox<String> cbEspecialidad;
    private JComboBox<String> cbHorasDisponibles;
    private JTextField txtValorHora;

    public InterfaceMedico(ArrayList<ReservasMedicass > reservaciones) {
        this.reservaciones = reservaciones;

        setTitle("Carga de Datos Médico");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        // Creación de componentes
        //txtNombreMedico = new JTextField(20);
        cbNombreMedico = new JComboBox<>(new String[]{"Seleccione", "Juan Meza", "Pedro Pascal", "Juan Fernandez","Ricardo Araya"});
        txtNombrePaciente = new JTextField(15);
        cbEspecialidad = new JComboBox<>(new String[]{"Seleccione", "Cardiología", "Dermatología", "Neurología"});
        cbHorasDisponibles = new JComboBox<>(new String[]{"Seleccione", "08:00", "09:00", "10:00", "11:00"});
        txtValorHora = new JTextField(15);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Espaciado común para todos los componentes
        gbc.insets = new Insets(4, 4, 4, 4);  
        gbc.anchor = GridBagConstraints.WEST;
        
        // Etiqueta y campo de texto para el nombre del médico
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre del Médico:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        add(cbNombreMedico, gbc);

        // Restablecemos weightx y fill para los demás componentes
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        // Etiqueta y campo de texto para el nombre del paciente
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nombre del Paciente:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        add(txtNombrePaciente, gbc);

        // Etiqueta y combobox para la especialidad
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Especialidad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        add(cbEspecialidad, gbc);

        // Etiqueta y combobox para horas disponibles
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Horas Disponibles:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        add(cbHorasDisponibles, gbc);

        // Etiqueta y campo de texto para el valor hora
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Valor Hora :"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        add(txtValorHora, gbc);

        // Botones Aceptar y Cancelar
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; 
        gbc.fill = GridBagConstraints.CENTER;
        add(btnAceptar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2; 
        gbc.fill = GridBagConstraints.CENTER;
        add(btnCancelar, gbc);


        // Manejadores de eventos
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aceptar();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfaceMedico.this.dispose();
            }
        });

        setVisible(true);
    }

    private void aceptar() {
        // Validación de los datos
        if /*(txtNombreMedico.getText().isEmpty()*/ (cbNombreMedico.getSelectedIndex() == 0 || txtNombrePaciente.getText().isEmpty() ||
                cbEspecialidad.getSelectedIndex() == 0 || cbHorasDisponibles.getSelectedIndex() == 0 ||
                txtValorHora.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear la reserva médica y añadirla al arreglo
        ReservasMedicass  citas = new ReservasMedicass (
                (String)cbNombreMedico.getSelectedItem(),
                txtNombrePaciente.getText(),
                (String) cbEspecialidad.getSelectedItem(),
                (String) cbHorasDisponibles.getSelectedItem(),
                Double.parseDouble(txtValorHora.getText())
        );
        reservaciones.add(citas);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Reserva guardada con éxito:\n" + citas, "Reserva Guardada", JOptionPane.INFORMATION_MESSAGE);
    }
}


