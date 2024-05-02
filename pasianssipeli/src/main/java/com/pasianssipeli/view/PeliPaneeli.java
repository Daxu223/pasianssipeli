package com.pasianssipeli.view;

import java.awt.*;
import javax.swing.*;

public class PeliPaneeli extends JPanel {
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

    // Yläpaneeli, pakka ja talletettavat kortit. Käytetään GridBagLayouttia pohjana
    private JPanel makeTopPanel() {
       
        JPanel topPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout(); // 3 riviä, 2 saraketta, 10 pikselin väliä
        topPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Asetetaan oletusasetuksia GridBagConstraints-olioon
        c.fill = GridBagConstraints.HORIZONTAL; // Komponentin täyttö suunta
        c.insets = new Insets(10, 10, 10, 10);  // Välit jokaisen komponentin ympärillä
        c.gridy = 0; // kaikki samalla rivillä

        // Lisää nostopakka
        ImageIcon kortinTaka = new ImageIcon(getClass().getResource("../../../cards/back001.gif"));
        JLabel pakka = new JLabel(kortinTaka);
        c.gridx = 0; // Ensimmäinen sarake
        c.weightx = 0.25; // Kuinka paljon komponentti saa suhteessa muihin komponentteihin vaakasuunnassa
        topPanel.add(pakka, c);

        // Poisto pakka: eli kortit johon kortit nostetaan
        JLayeredPane poistopakka = new JLayeredPane();
        poistopakka.setPreferredSize(new Dimension(120, 128)); // Asetetaan sopiva koko

        // Luo ja aseta kortit poistopakkaan
        for (int i = 0; i < 3; i++) {
            JLabel kortti = new JLabel(kortinTaka);
            kortti.setBounds(10 * i, 0, korttikoko.width, korttikoko.height); // Kortit kerroksittain
            poistopakka.add(kortti, Integer.valueOf(i)); // Kerros määritetään Integer-arvolla
        }
  
        c.gridx = 1; // Sijoita poistopakka toiseen sarakkeeseen
        c.weightx = 0.25; // Jakaa lisätilan tämän solun ja muiden solujen välillä
        topPanel.add(poistopakka, c);

        // Tällä säädetään pinojen ja foundation pinojen etäisyyttä
        c.gridx = 2;
        c.weightx = 0.5; // antaa enemmän tilaa keskelle
        topPanel.add(Box.createHorizontalStrut(300), c);


        for (int i = 1; i < FOUNDATION_PAKKOJEN_MAARA + 1; i++) {
            ImageIcon foundationIcon = new ImageIcon(getClass().getResource("../../../cards/fpBase0"+ i + ".gif"));
            JLabel perusta = new JLabel(foundationIcon);
            perusta.setPreferredSize(korttikoko);
            perusta.setBounds(i * 10, 0, korttikoko.width, korttikoko.height);
            c.gridx = 2 + i;
            c.weightx = 1;
            topPanel.add(perusta, c);
        }

        // Tee separator, niin yläpaneeli ja muut osiot voidaan erottaa
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = GridBagConstraints.REMAINDER; // Asettaa erottajan kattamaan kaikki sarakkeet
        c.weightx = 1; // Kaikki jäljellä oleva tila
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setOrientation(SwingConstants.HORIZONTAL);
        topPanel.add(separator, c);

        return topPanel;

    }
}