package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaSaldoProducto extends JFrame {
    private GraficadorArrayList graficadorArrayList;
    private JTextField saldoTextField;

    public VentanaSaldoProducto() {
        graficadorArrayList = new GraficadorArrayList();
        setTitle("Gestión de Saldo y Producto");
        setSize(720, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Botones a la izquierda
        JPanel botonPanel = new JPanel();
        botonPanel.setLayout(new GridLayout(3, 2));

        for (int i = 1; i <= 6; i++) {
            JButton boton = new JButton("Botón " + i);
            botonPanel.add(boton);
        }

        // Línea de texto para ingresar el saldo a la derecha
        JPanel saldoPanel = new JPanel();
        JLabel saldoLabel = new JLabel("Saldo:");
        saldoTextField = new JTextField(10);
        saldoPanel.add(saldoLabel);
        saldoPanel.add(saldoTextField);
        //int saldo=0;
        //JLabel saldoguardadoLabel = new JLabel("Saldo es: "+ Integer.parseInt(saldoTextField.getText()));

        // Botón central para "Sacar Producto y Vuelto"
        JButton sacarProductoButton = new JButton("Sacar Producto y Vuelto");
        sacarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para manejar el saldo y el producto
                String saldoText = saldoTextField.getText();
                int saldo = Integer.parseInt(saldoText);

                // Ejemplo: Restar 10 al saldo
                saldo -= 10;

                // Actualizar el campo de saldo
                saldoTextField.setText(Integer.toString(saldo));

                // Puedes realizar más operaciones aquí según tus necesidades.
            }
        });

        // Agregar componentes a la ventana
        add(botonPanel, BorderLayout.WEST);
        add(saldoPanel, BorderLayout.EAST);
        add(sacarProductoButton, BorderLayout.SOUTH);
        add(graficadorArrayList.getPrint(), BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaSaldoProducto ventana = new VentanaSaldoProducto();
            ventana.setVisible(true);
        });
    }
}

