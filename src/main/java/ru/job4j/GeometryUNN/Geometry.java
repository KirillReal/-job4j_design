package ru.job4j.GeometryUNN;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Geometry {
    private static void createAndShowGUI() {
        JFrame f = new JFrame("Проекция");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ProjectionPanel leftPanel = new ProjectionPanel(new Cube());
        f.getContentPane().add(leftPanel, BorderLayout.CENTER);

        ControlPanel rightPanel = new ControlPanel(leftPanel);
        f.getContentPane().add(rightPanel, BorderLayout.LINE_END);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
