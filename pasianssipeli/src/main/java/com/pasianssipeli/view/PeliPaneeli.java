package com.pasianssipeli.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class PeliPaneeli extends JPanel {
    private static final int PINOJEN_MAARA = 2; // Yksi pakalle, josta nostetaan ja toinen toinen poistopakalle
    private static final int KOHDEPAKKOJEN_MAARA = 4; // Tähän laitetaan kortit, joita etsitään.
    private MainPanel mainPanel;

    public PeliPaneeli(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.setLayout(new BorderLayout());

        JPanel topPanel = makeTopPanel(); // Tee yläpaneeli käyttämällä FlowLayout:ia.
        this.add(topPanel, BorderLayout.NORTH); // Lisää yläpaneeli tähän komponenttiin (PeliPaneeliin)
        
    }

    // Yläpaneeli, pakka ja talletettavat kortit
    private JPanel makeTopPanel() {;
        JPanel topPanel = new JPanel(new GridLayout(1, PINOJEN_MAARA + KOHDEPAKKOJEN_MAARA, 10, 0)); // rows, cols, horizontal gap, vertical gap
        topPanel.setBackground(Color.GREEN);

        ImageIcon icon = new ImageIcon(getClass().getResource("../../../cards/back001.gif"));
        JLabel pakkaKuvaSijainti = new JLabel(icon);
        topPanel.add(pakkaKuvaSijainti);

        JLabel poistoPakanSijainti = new JLabel(icon);
        topPanel.add(poistoPakanSijainti);

        for (int i = 0; i < KOHDEPAKKOJEN_MAARA; i++) {
            JLabel kohdePakanSijainti = new JLabel();
            topPanel.add(kohdePakanSijainti);
        }
        return topPanel;

    }
}