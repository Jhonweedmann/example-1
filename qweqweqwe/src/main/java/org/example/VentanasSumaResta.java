package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanasSumaResta extends JFrame {
    private int numero = 0;
    private JLabel labelNumero;

    public VentanasSumaResta() {
        // Ventana 1: Ingresar un número
        String numeroIngresado = JOptionPane.showInputDialog("Ingrese un número:");
        try {
            numero = Integer.parseInt(numeroIngresado);
        } catch (NumberFormatException e) {
            numero = 0;
        }

        // Ventana 2: Mostrar el número y botones de suma y resta
        setTitle("Operaciones con Número");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelNumero = new JLabel("Número: " + numero);
        labelNumero.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelNumero, BorderLayout.CENTER);

        JButton sumaButton = new JButton("+1");
        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero++;
                labelNumero.setText("Número: " + numero);
            }
        });

        JButton restaButton = new JButton("-1");
        restaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero--;
                labelNumero.setText("Número: " + numero);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sumaButton);
        buttonPanel.add(restaButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanasSumaResta ventana = new VentanasSumaResta();
            ventana.setVisible(true);
        });
    }
}
