package com.pasianssipeli;

import java.awt.Dimension;

import javax.swing.*;

import com.pasianssipeli.view.MainPanel;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Pasianssipeli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 600)); // Or preferred size
        frame.setLocationRelativeTo(null); // Center on screen
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
        });
    }
}