package com.pasianssipeli.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Pasianssi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1080, 920)); // Or preferred size
        
        // Lisää mainPanel ikkunaan.
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);

    }
    
}
