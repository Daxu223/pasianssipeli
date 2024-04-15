package com.pasianssipeli.view;

import javax.swing.*;

public class PeliPaneeli extends JPanel {
    private MainPanel mainPanel;

    public PeliPaneeli(MainPanel mainPanel) {
        setLayout(null);
        this.mainPanel = mainPanel;
        
        JButton aloitusPaluu = new JButton("Palaa");
        aloitusPaluu.addActionListener(e -> mainPanel.vaihdaNakyma("aloitus"));
        JLabel teksti = new JLabel("Nyt pelaat peliä, joka ei toimi XD");
        add(teksti);
        add(aloitusPaluu);
    }
}