package com.pasianssipeli.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Pasianssi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1080, 920));
        setResizable(false);

        // Lisää mainPanel ikkunaan.
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Keskitä näyttö avattaessa
        setVisible(true);

    }
    
}
