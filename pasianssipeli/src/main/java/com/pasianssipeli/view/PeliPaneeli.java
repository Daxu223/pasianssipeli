package com.pasianssipeli.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PeliPaneeli extends JPanel {
    private static final int FOUNDATION_PAKKOJEN_MAARA = 4; // Tähän laitetaan kortit, joita etsitään.
    private ImageIcon kortinTakakuva = new ImageIcon(getClass().getResource("../../../cards/back001.gif"));
    private Dimension korttikoko = new Dimension(100, 135);    
    
    private JPanel topPanel;
    private JPanel gamePanel;
    private JPanel bottomPanel;
    
    private JButton valikkoNappi;
    private JPopupMenu valikkoMenu;

    private JButton uusiPeliNappi;
    private JButton peruNappi;

    public PeliPaneeli(MainPanel mainPanel) {
        this.setLayout(new BorderLayout());
        kortinTakakuva = resizeIcon(kortinTakakuva, korttikoko);
        this.topPanel = makeTopPanel();
        this.bottomPanel = makeBottomPanel();
        this.gamePanel = makeGamePanel();

        this.add(topPanel, BorderLayout.NORTH); // Lisää yläpaneeli tähän PeliPaneeliin (atm pieni korttien koon takia)
        this.add(bottomPanel, BorderLayout.SOUTH); // Lisätään alapaneeli alas
        this.add(gamePanel, BorderLayout.CENTER); // Lisätään pelialue

    }

    // TODO: Näyttää ihan ok hyvältä, mutta tekstien pitäisi olla menuitemeiden yläosassa
    private JPopupMenu teeValikko() {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem asetukset = new JMenuItem("ASETUKSET", JMenuItem.NORTH);
        asetukset.setPreferredSize(new Dimension(180, 90));
        asetukset.setFont(new Font("Arial", Font.PLAIN, 25));
        JMenuItem ohjeet = new JMenuItem("OHJEET", JMenuItem.NORTH);
        ohjeet.setPreferredSize(new Dimension(180, 90));
        ohjeet.setFont(new Font("Arial", Font.PLAIN, 25));
        JMenuItem valikkoon = new JMenuItem("VALIKKO", JMenuItem.NORTH);
        valikkoon.setPreferredSize(new Dimension(180, 90));
        valikkoon.setFont(new Font("Arial", Font.PLAIN, 25));
        menu.add(asetukset);
        menu.add(ohjeet);
        menu.add(valikkoon);
        return menu;
    }

    private ImageIcon resizeIcon(ImageIcon icon, Dimension kortinkoko) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(kortinkoko.width, kortinkoko.height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private JPanel makeGamePanel() {
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout());
        gamePanel.setPreferredSize(new Dimension(MainFrame.getFrameX(), MainFrame.getFrameY() - 225)); // Otettu huomioon ala ja yläpaneelin koot
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));  // Top, left, bottom, right
        GridBagConstraints c = new GridBagConstraints();

        // Asetetaan oletusasetuksia GridBagConstraints-olioon
        c.fill = GridBagConstraints.BOTH; // Komponentin täyttösuunta: täytetään koko alue (size) molemmista suunnista.
        c.insets = new Insets(30,25, 0, 25); // En ole varma kuinka paljon nämä vaikuttaa, mutta säätää marginaaleja.
        c.weighty = 0.142; // Yksi jaettuna seitsemällä.
        c.weightx = 1;
        c.gridx = GridBagConstraints.RELATIVE; // Automaattisesti seuraava sijainti x-suunnassa
        c.gridy = 0;

        JLayeredPane pelipakka = new JLayeredPane();
        int kortitPakassa = 1; // Ensimmäisesssä pakassa on yksi kortti

        // Aseta kortit pinoihin ja tee seitsemän pinoa, joissa jokaisessa yksi kortti enemmän.
        for (int pakanNumero = 0; pakanNumero < 7; pakanNumero++) {
            for (int kortinNumero = 0; kortinNumero < kortitPakassa; kortinNumero++) {
                JLabel kortti = new JLabel(kortinTakakuva);
                kortti.setBounds(pakanNumero * 150, kortinNumero * 33, korttikoko.width, korttikoko.height); // Kortit kerroksittain, sivuttaisliike
                c.gridy = kortinNumero;
                pelipakka.add(kortti, Integer.valueOf(kortinNumero)); // Kerros määritetään Integer-arvolla
            }

            c.gridx = pakanNumero;
            kortitPakassa++; // Pakka lisätty: korttien määrä kasvaa
            gamePanel.add(pelipakka, c);

        }

        return gamePanel;
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
        this.peruNappi = new JButton("Peru");
        peruNappi.setFont(new Font("Arial", Font.PLAIN, 40));
        c.gridx = 0; // Lisätään vasemmalle soluun
        c.weightx = 0.15; // Noin kuudes osa palkin koosta
        peruNappi.setBorder(null);
        bottomPanel.add(peruNappi, c);

        // TODO: Paremmaksi, esim. kuvat ja tälläiset
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
        this.uusiPeliNappi = new JButton("Uusi peli");
        uusiPeliNappi.setFont(new Font("Arial", Font.PLAIN, 40));
        c.weightx = 0.15; // Saman verran kuin peru-nappi
        c.gridx = 2; // Kolmas elementti
        c.weighty = 0.9;
        uusiPeliNappi.setBorder(null);
        bottomPanel.add(uusiPeliNappi, c);
        
        // Lisätään valikko
        this.valikkoNappi = new JButton("* * *");
        valikkoNappi.setFont(new Font("Arial", Font.PLAIN, 40));
        c.weightx = 0.15;
        c.gridx = 3; // Neljäs elementti
        valikkoNappi.setBorder(null);
        valikkoMenu = teeValikko();
        valikkoNappi.setComponentPopupMenu(valikkoMenu);
        bottomPanel.add(valikkoNappi, c);
        
        // Tee separator, niin yläpaneeli ja muut osiot voidaan erottaa
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.01;
        c.gridwidth = GridBagConstraints.REMAINDER; // Asettaa erottajan kattamaan kaikki sarakkeet
        c.weightx = 1; // Kaikki jäljellä oleva tila
        c.fill = GridBagConstraints.HORIZONTAL;
        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(1, 1));
        separator.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Säädä reunuksen etäisyyttä ylä- ja alapuolella
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
        JLabel pakka = new JLabel(kortinTakakuva);
        c.gridx = 0; // Ensimmäinen sarake
        c.weightx = 0.1; // n. kymmenesosa yläpalkista
        topPanel.add(pakka, c);

        // Poisto pakka: eli kortit johon kortit nostetaan
        JLayeredPane poistopakka = new JLayeredPane();
        poistopakka.setPreferredSize(new Dimension(korttikoko.width + 99, korttikoko.height)); // Kortin korkeus + korttien sivuttaisliike
        poistopakka.setMinimumSize(new Dimension(korttikoko.width + 99, korttikoko.height));

        // Luo ja aseta kortit poistopakkaan. Huomioidaan, että flowlayout käyttää gridbaglayouttia
        for (int i = 0; i < 3; i++) {
            JLabel kortti = new JLabel(kortinTakakuva);
            kortti.setBounds(33 * i, 0, korttikoko.width, korttikoko.height); // Kortit kerroksittain, sivuttaisliike
            c.gridx = 1 + i;
            c.weightx = 0.1;
            poistopakka.add(kortti, Integer.valueOf(i)); // Kerros määritetään Integer-arvolla
        }
  
        topPanel.add(poistopakka, c);

        // Asetataan "laatikko" peruspakkojen ja pinojen välille
        c.gridx = 5;
        c.weightx = 0.4; // Melkein puolet palkin tilasta
        topPanel.add(Box.createHorizontalStrut(korttikoko.width * 2), c);

    

        for (int i = 1; i < FOUNDATION_PAKKOJEN_MAARA + 1; i++) {
            ImageIcon foundationIcon = new ImageIcon(getClass().getResource("../../../cards/fpBase0" + i + ".gif"));
            foundationIcon = resizeIcon(foundationIcon, korttikoko);
            JLabel perusta = new JLabel(foundationIcon);
            perusta.setPreferredSize(new Dimension(korttikoko.width, korttikoko.height)); // Kortin korkeus + korttien sivuttaisliike
            perusta.setMinimumSize(new Dimension(korttikoko.width, korttikoko.height));
            perusta.setBounds(i, 0, korttikoko.width, korttikoko.height);
            c.gridx = 6 + i;
            c.weightx = 0.10;
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

    // TODO: Ehkä koko valikko kannattaa refaktoroida omaan luokkaansa.
    public JButton getValikkoNappi() {
        return valikkoNappi;
    }

    public JPopupMenu getValikkoMenu() {
        return valikkoMenu;
    }

    public void showMenuAt(int x, int y) {
        valikkoMenu.show(valikkoNappi, x, y);
    }

    public void addMenuItemListener(int menuItemIndex, ActionListener listener) {
        JMenuItem item = getMenuItem(menuItemIndex);
        if (item != null) {
            item.addActionListener(listener);
        }
    }

    public JMenuItem getMenuItem(int index) {
        return (JMenuItem) valikkoMenu.getComponent(index);
    }

}