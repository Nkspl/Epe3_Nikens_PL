

package com.mycompany.epe3_nikens_pl;

import javax.swing.SwingUtilities;


public class Epe3_Nikens_PL {

    public static void main(String[] args) {
       // Crear la ventana principal en el hilo de despacho de eventos de Swing.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio_Home();
            }
        } ); 

                }
}
