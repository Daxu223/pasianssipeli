package com.pasianssipeli.view;

import java.awt.*;
import javax.swing.*;

public class PeliPaneeli extends JPanel {
    private static final int PINOJEN_MAARA = 2; // Yksi pakalle, josta nostetaan ja toinen toinen poistopakalle
    private static final int FOUNDATION_PAKKOJEN_MAARA = 4; // Tähän laitetaan kortit, joita etsitään.
    private final Dimension korttikoko = new Dimension(96, 128);
    
    // private MainPanel mainPanel;

    public PeliPaneeli(MainPanel mainPanel) {
        // this.mainPanel = mainPanel;
        this.setLayout(new BorderLayout());

        JPanel topPanel = makeTopPanel(); // Tee yläpaneeli käyttämällä FlowLayout:ia.
        
        // Tämä on tällä hetkellä todella pieni, mutta se johtuu korttien koosta.
        this.add(topPanel, BorderLayout.NORTH); // Lisää yläpaneeli tähän komponenttiin (PeliPaneeliin)
        
    }

    // Yläpaneeli, pakka ja talletettavat kortit
    private JPanel makeTopPanel() {
       
        JPanel topPanel = new JPanel(); // Create top columns
        topPanel.setOpaque(false);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 10, 5);
        flowLayout.setAlignOnBaseline(true);
        topPanel.setLayout(flowLayout);
        
        
        // Lisää nostopakka
        ImageIcon pakkaIcon = new ImageIcon(getClass().getResource("../../../cards/back001.gif"));
        JLabel pakka = new JLabel("Nosto pakka", pakkaIcon, JLabel.CENTER);
        pakka.setHorizontalTextPosition(JLabel.CENTER);
        pakka.setVerticalTextPosition(JLabel.BOTTOM);
        pakka.setPreferredSize(korttikoko);
        pakka.setBounds(100, 100, 100, 100);
        topPanel.add(pakka);

        // Poisto pakka: eli kortit johon kortit nostetaan
        JLayeredPane poistopakka = new JLayeredPane();
        poistopakka.setPreferredSize(new Dimension(120, 128)); // Adjusted for label

        for (int i = 0; i < 3; i++) {
            JLabel kortti = new JLabel(pakkaIcon); // Tähän tulisi kortteja randomilla
            int yOffset = korttikoko.height - 138; // Säädä layeredPane ja flowLayout samalle tasolle.
            kortti.setBounds(10 * i, yOffset, korttikoko.width, korttikoko.height);
            poistopakka.add(kortti);
        }

        topPanel.add(poistopakka);

        // Tällä säädetään pinojen ja foundation pinojen etäisyyttä
        topPanel.add(Box.createHorizontalStrut(350));

        for (int number = 1; number < FOUNDATION_PAKKOJEN_MAARA + 1; number++) {
            ImageIcon foundationIcon = new ImageIcon(getClass().getResource("../../../cards/fpBase0"+ number + ".gif"));
            JLabel kohdepakka = new JLabel("Foundation " + number, foundationIcon, JLabel.CENTER);
            kohdepakka.setPreferredSize(korttikoko); // Match dimensions
            kohdepakka.setHorizontalTextPosition(JLabel.CENTER);
            kohdepakka.setVerticalTextPosition(JLabel.BOTTOM);
            kohdepakka.setBounds(10 * number, 0, korttikoko.width - 10, korttikoko.height);
            topPanel.add(kohdepakka);
        }
        return topPanel;

    }
}