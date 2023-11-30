
package com.mycompany.epe3_nikens_pl;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Inicio_Home extends JFrame {

    // Inicializamos el arreglo para almacenar las reservas médicas.
    private ArrayList<ReservasMedicass> reservaciones = new ArrayList<>();

    public Inicio_Home() {
        // Configuración básica de la ventana
        setTitle("Sistema de Reserva de Horas Médicas");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Utilizamos GridBagLayout para centrar los botones
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Creación de botones
        JButton btnMedico = new JButton("Médico");
        JButton btnReservas = new JButton("Reservas");
        JButton btnCerrar = new JButton("Cerrar");

        // Centramos los componentes horizontalmente y verticalmente
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0); // Margen exterior

        // Añadir componentes
        add(btnMedico, gbc);
        add(btnReservas, gbc);
        add(btnCerrar, gbc);

        // Manejador de eventos para el botón Médico
        btnMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceMedico interfacemedico = new InterfaceMedico(reservaciones);
                interfacemedico.setVisible(true);
            }
        });

        // Manejador de eventos para el botón Reservas
        btnReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interface_de_Reservas interfaceReservas = new Interface_de_Reservas(reservaciones);
                interfaceReservas.setVisible(true);
            }
        });

        // Manejador de eventos para el botón Cerrar
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Sañade los botones al panel de contenido
        JPanel panel = new JPanel();
        panel.add(btnMedico);
        panel.add(btnReservas);
        panel.add(btnCerrar);
        add(panel);

        // Hago que la ventana sea visible
        setVisible(true);
    }

    
}
