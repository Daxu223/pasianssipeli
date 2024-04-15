package com.pasianssipeli.view;

import javax.swing.*;

public class PeliPaneeli extends JPanel {
    // public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;
    private MainPanel mainPanel;

    public PeliPaneeli(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        setLayout(null);

        JLabel teksti = new JLabel("Nyt pelaat peliä, joka ei toimi XD");
        add(teksti);
        teksti.setBounds(1080 / 2 - 100, 720 / 2 - 15, 200, 30); // TODO: joku laskenta mekaanikka keskittämiseen
        
        JButton aloitusPaluu = new JButton("Palaa");
        add(aloitusPaluu);
        aloitusPaluu.setBounds(1080 / 2 - 55, 600, 100, 30); // TODO: järkevämpi laskumekaniikka
        aloitusPaluu.addActionListener(e -> mainPanel.vaihdaNakyma("aloitus"));
    }
}