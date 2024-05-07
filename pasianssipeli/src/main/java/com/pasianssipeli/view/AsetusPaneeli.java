package com.pasianssipeli.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AsetusPaneeli extends JPanel {
    private JPanel ylamenu;
    private JPanel asetukset;

    private Font tekstinKoko = new Font("Arial", Font.BOLD, 18);
    private Dimension nappienKoko = new Dimension(140, 30);


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

        GridBagConstraints asetusNappienPaikat = new GridBagConstraints();
        asetusNappienPaikat.anchor = GridBagConstraints.NORTHWEST; // Komponentit vasemmalle ylös
        asetusNappienPaikat.fill = GridBagConstraints.HORIZONTAL;
        asetusNappienPaikat.insets = new Insets(20, 0, 20, 0); // Marginaalit: top, left,bottom, right 
        asetusNappienPaikat.weightx = asetusNappienPaikat.weighty = 0.1; // TODO: Säädä vastamaan muita weightejä

        // TODO: AAARRRRRRRGGHHH en ymmärrä mikä tossa on että on tommonen luikaus väli ensimmäisen rivin ja tokan rivin välillä
        GridBagConstraints asetustekstienPaikat = new GridBagConstraints();
        asetustekstienPaikat.anchor = GridBagConstraints.NORTHWEST; // Komponentit vasemmalle ylös
        asetustekstienPaikat.fill = GridBagConstraints.HORIZONTAL;
        asetustekstienPaikat.insets = new Insets(20, 20, 20, 0); // Marginaalit: top, left,bottom, right 
        asetustekstienPaikat.weightx = asetustekstienPaikat.weighty = 0.1;

        GridBagConstraints oikeanPaneelinPaikka = new GridBagConstraints();
        oikeanPaneelinPaikka.fill = GridBagConstraints.BOTH;
        oikeanPaneelinPaikka.weightx = 0.8;
        oikeanPaneelinPaikka.weighty = 0.1;
        oikeanPaneelinPaikka.gridx = 5;
        oikeanPaneelinPaikka.gridy = 0;
        oikeanPaneelinPaikka.gridheight = 3; // Säätää komponentin korkeutta

        GridBagConstraints nollausNapinPaikka = new GridBagConstraints();
        nollausNapinPaikka.insets = new Insets(20, 20, 20, 0);
        nollausNapinPaikka.weightx = 0.2;
        nollausNapinPaikka.weighty = 0.2;
        nollausNapinPaikka.gridx = 0;
        nollausNapinPaikka.gridy = 4;
        nollausNapinPaikka.anchor = GridBagConstraints.SOUTHWEST;

        GridBagConstraints alemmanPaneelinPaikka = new GridBagConstraints();
        alemmanPaneelinPaikka.fill = GridBagConstraints.NONE;
        alemmanPaneelinPaikka.weighty = 0.5; 
        alemmanPaneelinPaikka.gridx = 0;
        alemmanPaneelinPaikka.gridy = 3;
 
        // Alustetaan napit
        JToggleButton ajastinNappi = new JToggleButton("Päällä");
        JToggleButton siirrotNappi = new JToggleButton("Päällä");
        JToggleButton aanetNappi = new JToggleButton("Päällä");
        JToggleButton musiikkiNappi = new JToggleButton("Päällä");

        ajastinNappi.setPreferredSize(nappienKoko);
        siirrotNappi.setPreferredSize(nappienKoko);
        aanetNappi.setPreferredSize(nappienKoko);
        musiikkiNappi.setPreferredSize(nappienKoko);

        // TODO: Java ei tue pyöristettyjä nappeja = custom JToggleButton class
        ajastinNappi.setBorder(null);
        siirrotNappi.setBorder(null);
        aanetNappi.setBorder(null);
        musiikkiNappi.setBorder(null);

        // Alustetaan tekstit
        JLabel ajastinTeksti = new JLabel("Näytä ajastin"); // Näin voi tehdä
        JLabel siirrotTeksti = new JLabel("Näytä siirrot");
        JLabel aanetTeksti = new JLabel("Äänet");
        JLabel musiikkiTeksti = new JLabel("Musiikki");

        ajastinTeksti.setFont(tekstinKoko);
        siirrotTeksti.setFont(tekstinKoko);
        aanetTeksti.setFont(tekstinKoko);
        musiikkiTeksti.setFont(tekstinKoko);


        // Add labels and toggle buttons to the grid, alternating between label and button
        addComponent(asetukset, ajastinTeksti, asetustekstienPaikat,  0, 0); // Rivi 1
        addComponent(asetukset, ajastinNappi, asetusNappienPaikat, 1, 0); // Rivi 1
        addComponent(asetukset, siirrotTeksti, asetustekstienPaikat, 0, 1); // Rivi 2
        addComponent(asetukset, siirrotNappi, asetusNappienPaikat, 1, 1); // Rivi 2
        addComponent(asetukset, aanetTeksti, asetustekstienPaikat, 2, 0); // Rivi 1, toinen erä
        addComponent(asetukset, aanetNappi, asetusNappienPaikat, 3, 0); // Rivi 1, toinen erä
        addComponent(asetukset, musiikkiTeksti, asetustekstienPaikat, 2 , 1); // Rivi 2, toinen erä 
        addComponent(asetukset, musiikkiNappi, asetusNappienPaikat, 3, 1); // Rivi 2, toinen erä

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
        nollausNappi.setPreferredSize(new Dimension(250, 50));
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
