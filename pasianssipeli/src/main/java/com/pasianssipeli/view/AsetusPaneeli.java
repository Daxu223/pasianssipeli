package com.pasianssipeli.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AsetusPaneeli extends JPanel {
    private JPanel ylamenu;
    private JPanel asetukset;


    public AsetusPaneeli(MainPanel mainPanel) {
        // Tykkäsin borderlayoutista, niin käytän sitä komponenttien sijoitteluun.
        this.setLayout(new BorderLayout());
        this.ylamenu = teeYlamenu();
        this.asetukset = teeAsetukset();
        this.add(ylamenu, BorderLayout.NORTH); // Menu ylös
        this.add(asetukset); // Ei erityistä paikkaa, vain yläpalkki ja tämä.
        
    }

    private JPanel teeYlamenu() {
        JPanel ylamenu = new JPanel();
        ylamenu.setLayout(new BorderLayout()); // Hyvin kustomoitava layoutti
        
        JButton backButton = new JButton("<");
        JButton closeButton = new JButton("X");

        ylamenu.add(backButton, BorderLayout.WEST);
        ylamenu.add(closeButton, BorderLayout.EAST);

        JLabel ylateksti = new JLabel("ASETUKSET", JLabel.CENTER);
        ylateksti.setFont(new Font("Arial", Font.BOLD, 26));

        ylamenu.add(ylateksti);
        ylamenu.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK)); // Tekee reunan vain alas

        return ylamenu;
    }

    private JPanel teeAsetukset() {
        JPanel asetukset = new JPanel();
        asetukset.setLayout(new GridBagLayout());

        GridBagConstraints asetustenPaikat = new GridBagConstraints();
        asetustenPaikat.anchor = GridBagConstraints.NORTHWEST; // Komponentit vasemmalle ylös
        asetustenPaikat.fill = GridBagConstraints.NONE;
        asetustenPaikat.insets = new Insets(20, 10, 0, 20); // Marginaalit: top, left,bottom, right 
        asetustenPaikat.weightx = asetustenPaikat.weighty = 0.1; // TODO: Säädä vastamaan muita weightejä

        GridBagConstraints nollausNapinPaikka = new GridBagConstraints();
        nollausNapinPaikka.gridwidth = 1; // Säätää komponentin leveyttä
        nollausNapinPaikka.gridheight = 1; // Säätää komponentin korkeutta
        nollausNapinPaikka.weightx = 0.2;
        nollausNapinPaikka.weighty = 0.2;
        nollausNapinPaikka.gridx = 0;
        nollausNapinPaikka.gridy = 4;
        nollausNapinPaikka.anchor = GridBagConstraints.SOUTHWEST;

        GridBagConstraints oikeanPaneelinPaikka = new GridBagConstraints();
        oikeanPaneelinPaikka.fill = GridBagConstraints.BOTH;
        oikeanPaneelinPaikka.weightx = 0.8;
        oikeanPaneelinPaikka.weighty = 0.2;
        oikeanPaneelinPaikka.gridx = 5;
        oikeanPaneelinPaikka.gridy = 0;
        oikeanPaneelinPaikka.gridheight = 3; // Säätää komponentin korkeutta

        GridBagConstraints alemmanPaneelinPaikka = new GridBagConstraints();
        alemmanPaneelinPaikka.fill = GridBagConstraints.NONE;
        alemmanPaneelinPaikka.weighty = 0.5; 
        alemmanPaneelinPaikka.gridx = 0;
        alemmanPaneelinPaikka.gridy = 3;
        alemmanPaneelinPaikka.gridwidth = 6; // Säätää komponentin leveyttä
 
        // Alustetaan napit
        JToggleButton ajastinNappi = new JToggleButton("Päällä");
        JToggleButton siirrotNappi = new JToggleButton("Päällä");
        JToggleButton aanetNappi = new JToggleButton("Päällä");
        JToggleButton musiikkiNappi = new JToggleButton("Päällä");

        // Alustetaan tekstit
        JLabel ajastinTeksti = new JLabel("<HTML>Näytä<BR>ajastin</HTML>"); // Näin voi tehdä
        JLabel siirrotTeksti = new JLabel("<HTML>Näytä<BR>siirrot</HTML>");
        JLabel aanetTeksti = new JLabel("Äänet");
        JLabel musiikkiTeksti = new JLabel("Musiikki");


        // Add labels and toggle buttons to the grid, alternating between label and button
        addComponent(asetukset, ajastinTeksti, asetustenPaikat,  0, 0); // Rivi 1
        addComponent(asetukset, ajastinNappi, asetustenPaikat, 1, 0); // Rivi 1
        addComponent(asetukset, siirrotTeksti, asetustenPaikat, 0, 1); // Rivi 2
        addComponent(asetukset, siirrotNappi, asetustenPaikat, 1, 1); // Rivi 2
        addComponent(asetukset, aanetTeksti, asetustenPaikat, 2, 0); // Rivi 1, toinen erä
        addComponent(asetukset, aanetNappi, asetustenPaikat, 3, 0); // Rivi 1, toinen erä
        addComponent(asetukset, musiikkiTeksti, asetustenPaikat, 2 , 1); // Rivi 2, toinen erä 
        addComponent(asetukset, musiikkiNappi, asetustenPaikat, 3, 1); // Rivi 2, toinen erä

        // TODO: Jos osaat tehdä paremmin, niin tee pliis :D
        // Näkymätön filleri oikealle
        JPanel rightFiller = new JPanel();
        // rightFiller.setBackground(Color.YELLOW);
        rightFiller.setOpaque(false);
        asetukset.add(rightFiller, oikeanPaneelinPaikka);

        // Näkymätön filleri alhaalle
        JPanel bottomFiller = new JPanel();
        // bottomFiller.setBackground(Color.YELLOW);
        bottomFiller.setOpaque(false);
        asetukset.add(bottomFiller, alemmanPaneelinPaikka);

        JButton nollausNappi = new JButton("Nollaa asetukset");
        asetukset.add(nollausNappi, nollausNapinPaikka);

        return asetukset;
        
    }

    // Apumetodi luettavuuden parantamiseksi
    private void addComponent(JPanel panel, Component comp, GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        panel.add(comp, c);
    }

}
