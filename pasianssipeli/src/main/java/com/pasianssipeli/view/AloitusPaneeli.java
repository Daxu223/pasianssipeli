package com.pasianssipeli.view;

import javax.swing.*;

public class AloitusPaneeli extends JPanel {
    private MainPanel mainPanel;

    public AloitusPaneeli(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        JButton aloitusNappi = new JButton("Pelaa peliä");
        aloitusNappi.addActionListener(e -> mainPanel.vaihdaNakyma("peli"));
        add(aloitusNappi);
        
    }
}
