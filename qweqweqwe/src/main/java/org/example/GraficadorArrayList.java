package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraficadorArrayList extends JPanel {
    private ArrayList<String> elementos;

    public GraficadorArrayList() {
        elementos = new ArrayList<>();
    }

    public void agregarElemento() {
        elementos.add("PEPSI");
        repaint();
    }

    public void borrarElemento() {
        if (!elementos.isEmpty()) {
            elementos.remove(elementos.size() - 1);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 50;

        for (String elemento : elementos) {
            g.setColor(Color.gray);
            g.fillRect(x, y, 50, 30);
            g.setColor(Color.WHITE);
            g.drawString(elemento.toString(), x + 5, y + 20);
            x += 60;
        }
    }

public JPanel getPrint(){
    JFrame frame = new JFrame("Graficador de ArrayList");
    GraficadorArrayList graficador = new GraficadorArrayList();
    frame.add(graficador);



    JButton agregarBoton = new JButton("Agregar Elemento");
    agregarBoton.addActionListener(e -> graficador.agregarElemento());

    JButton borrarBoton = new JButton("Borrar Elemento");
    borrarBoton.addActionListener(e -> graficador.borrarElemento());



    JPanel botonesPanel = new JPanel();
    botonesPanel.add(agregarBoton);
    botonesPanel.add(borrarBoton);
    frame.add(botonesPanel, BorderLayout.NORTH);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 200);
    frame.setVisible(true);
    return botonesPanel;
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        GraficadorArrayList g = new GraficadorArrayList();
        g.getPrint();
        });
    }
}
