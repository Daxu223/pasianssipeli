package com.pasianssipeli.view;

import javax.swing.*;

public class AloitusPaneeli extends JPanel {
    private MainPanel mainPanel;

    public AloitusPaneeli(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        JButton aloitusNappi = new JButton("Pelaa peliä");
        aloitusNappi.addActionListener(e -> mainPanel.vaihdaNakyma("peli"));
        
        JButton asetusNappi = new JButton("Asetukset");
        asetusNappi.addActionListener(e -> mainPanel.vaihdaNakyma("asetukset"));
        

        add(aloitusNappi);
        add(asetusNappi);

    }
}
