package com.pasianssipeli;

import java.awt.Dimension;

import javax.swing.*;

import com.pasianssipeli.view.MainPanel;

public class Main extends JFrame {
    public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Pasianssipeli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT)); // Or preferred size
        frame.setLocationRelativeTo(null); // Center on screen
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
        });
    }
}