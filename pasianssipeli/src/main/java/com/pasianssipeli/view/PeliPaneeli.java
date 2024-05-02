package com.pasianssipeli.view;

import java.awt.*;
import javax.swing.*;

public class PeliPaneeli extends JPanel {
    private static final int FOUNDATION_PAKKOJEN_MAARA = 4; // Tähän laitetaan kortit, joita etsitään.
    private final Dimension korttikoko = new Dimension(96, 128);

    public PeliPaneeli(MainPanel mainPanel) {
        this.setLayout(new BorderLayout());

        JPanel topPanel = makeTopPanel();
        JPanel bottomPanel = makeBottomPanel(); //

        this.add(topPanel, BorderLayout.NORTH); // Lisää yläpaneeli tähän PeliPaneeliin (atm pieni korttien koon takia)
        this.add(bottomPanel, BorderLayout.SOUTH); // Lisätään alapaneeli alas
        
    }

    private JPanel makeBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        bottomPanel.setPreferredSize(new Dimension(MainFrame.getFrameX(), 75));
        GridBagConstraints c = new GridBagConstraints();

        // Asetetaan oletusasetuksia GridBagConstraints-olioon
        c.fill = GridBagConstraints.BOTH; // Komponentin täyttösuunta: täytetään koko alue (size) molemmista suunnista.
        c.insets = new Insets(0, 0, 0, 0); // En ole varma kuinka paljon nämä vaikuttaa, mutta säätää marginaaleja.
        c.gridy = 1; // Napit ovat kaikki samalla rivillä.
        c.weighty = 0.99;

        // Lisää peru-nappi
        JButton peruna = new JButton("Peru");
        c.gridx = 0; // Lisätään vasemmalle soluun
        c.weightx = 0.15; // Noin kuudes osa palkin koosta'
        peruna.setBorder(null);
        bottomPanel.add(peruna, c);

        // Lisätään piste-alue
        JPanel pisteAlue = new JPanel();
        JLabel aika = new JLabel("Aika:");
        JLabel pisteet = new JLabel("Pisteet:");
        JLabel siirrot = new JLabel("Siirrot:");

        pisteAlue.add(aika);
        pisteAlue.add(pisteet);
        pisteAlue.add(siirrot);

        c.weightx = 0.4; // Noin kolmas osa alueesta
        c.gridx = 1; // Toinen elementti
        bottomPanel.add(pisteAlue, c);

        // Lisätään uusi peli painike
        JButton uusiPeli = new JButton("Uusi peli");
        c.weightx = 0.15; // Saman verran kuin peru-nappi
        c.gridx = 2; // Kolmas elementti
        c.weighty = 0.9;
        uusiPeli.setBorder(null);
        bottomPanel.add(uusiPeli, c);
        
        // Lisätään valikko
        JButton valikko = new JButton("* * *");
        c.weightx = 0.15;
        c.gridx = 3; // Neljäs elementti
        valikko.setBorder(null);
        bottomPanel.add(valikko, c);
        
        // Tee separator, niin yläpaneeli ja muut osiot voidaan erottaa
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.01;
        c.gridwidth = GridBagConstraints.REMAINDER; // Asettaa erottajan kattamaan kaikki sarakkeet
        c.weightx = 1; // Kaikki jäljellä oleva tila
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Säädä reunuksen etäisyyttä ylä- ja alapuolella
        separator.setOrientation(SwingConstants.HORIZONTAL);
        bottomPanel.add(separator, c);

        return bottomPanel;

    }

    // Yläpaneeli, pakka ja talletettavat kortit. Käytetään GridBagLayouttia pohjana
    private JPanel makeTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        topPanel.setPreferredSize(new Dimension(MainFrame.getFrameX(), 150));
        GridBagConstraints c = new GridBagConstraints();

        // Asetetaan oletusasetuksia GridBagConstraints-olioon
        c.fill = GridBagConstraints.HORIZONTAL; // Komponentin täyttö suunta
        c.insets = new Insets(0, 10, 0, 0);  // Välit jokaisen komponentin ympärillä
        c.gridy = 0; // Kaikki samalla rivillä
        c.weighty = 0.9;

        // Lisää nostopakka
        ImageIcon kortinTaka = new ImageIcon(getClass().getResource("../../../cards/back001.gif"));
        JLabel pakka = new JLabel(kortinTaka);
        c.gridx = 0; // Ensimmäinen sarake
        c.weightx = 0.1; // n. kymmenesosa yläpalkista
        topPanel.add(pakka, c);

        // Poisto pakka: eli kortit johon kortit nostetaan
        JLayeredPane poistopakka = new JLayeredPane();
        poistopakka.setPreferredSize(new Dimension(96 + 99, 128)); // Kortin korkeus + korttien sivuttaisliike

        // Luo ja aseta kortit poistopakkaan. Huomioidaan, että flowlayout käyttää gridbaglayouttia
        for (int i = 0; i < 3; i++) {
            JLabel kortti = new JLabel(kortinTaka);
            kortti.setBounds(33 * i, -1, korttikoko.width, korttikoko.height); // Kortit kerroksittain, sivuttaisliike
            c.gridx = 1 + i;
            c.weightx = 0.1;
            poistopakka.add(kortti, Integer.valueOf(i)); // Kerros määritetään Integer-arvolla
        }
  
        topPanel.add(poistopakka, c);

        // Asetataan "laatikko" peruspakkojen ja pinojen välille
        c.gridx = 5;
        c.weightx = 0.4; // Melkein puolet palkin tilasta
        topPanel.add(Box.createHorizontalStrut(300), c);


        for (int i = 1; i < FOUNDATION_PAKKOJEN_MAARA + 1; i++) {
            ImageIcon foundationIcon = new ImageIcon(getClass().getResource("../../../cards/fpBase0"+ i + ".gif"));
            JLabel perusta = new JLabel(foundationIcon);
            perusta.setPreferredSize(korttikoko);
            perusta.setBounds(i * 10, 0, korttikoko.width, korttikoko.height);
            c.gridx = 6 + i;
            c.weightx = 1;
            topPanel.add(perusta, c);
        }

        // Tee separator, niin yläpaneeli ja muut osiot voidaan erottaa
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = GridBagConstraints.REMAINDER; // Asettaa erottajan kattamaan kaikki sarakkeet
        c.weightx = 1; // Kaikki jäljellä oleva tila
        c.weighty = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setOrientation(SwingConstants.HORIZONTAL);
        topPanel.add(separator, c);

        return topPanel;

    }
}