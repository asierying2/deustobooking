package es.deusto.deustobooking.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public final class EstiloVentanas {
    private EstiloVentanas() {
    }

    public static JPanel prepararVentana(JFrame ventana, String titulo) {
        ventana.setTitle("DeustoBooking - " + titulo);
        ventana.setSize(820, 540);
        ventana.setMinimumSize(new Dimension(760, 480));
        ventana.setLocationRelativeTo(null);

        JPanel principal = new JPanel(new BorderLayout(0, 12));
        principal.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        ventana.setContentPane(principal);

        JLabel cabecera = new JLabel(titulo);
        cabecera.setFont(cabecera.getFont().deriveFont(Font.BOLD, 20f));
        cabecera.setOpaque(true);
        cabecera.setBackground(new Color(35, 65, 90));
        cabecera.setForeground(Color.WHITE);
        cabecera.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
        principal.add(cabecera, BorderLayout.NORTH);

        JPanel contenido = new JPanel(new BorderLayout(0, 10));
        principal.add(contenido, BorderLayout.CENTER);
        return contenido;
    }

    public static JPanel crearBarraBotones() {
        return new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
    }

    public static void prepararTabla(JTable tabla) {
        tabla.setRowHeight(28);
        tabla.setFillsViewportHeight(true);
        tabla.getTableHeader().setFont(tabla.getTableHeader().getFont().deriveFont(Font.BOLD));
    }
}
