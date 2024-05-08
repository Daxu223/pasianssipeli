package com.pasianssipeli.controller;

import com.pasianssipeli.view.MainPanel;
import com.pasianssipeli.view.PeliPaneeli;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

public class ValikkoOhjain {
    private MainPanel mainPanel;
    private PeliPaneeli peliPaneeli;

    public ValikkoOhjain(MainPanel mainPanel, PeliPaneeli peliPaneeli) {
        this.mainPanel = mainPanel;
        this.peliPaneeli = peliPaneeli;
        addControlLogic();
    }

    private void addControlLogic() {
        peliPaneeli.addMenuItemListener(0, e -> mainPanel.vaihdaNakyma("asetukset")); // Tässä voidaan vaihtaa näkymää niin kuin aloituksessa
        peliPaneeli.addMenuItemListener(1, e -> showHelp()); // Voidaan luoda pop-up
        peliPaneeli.addMenuItemListener(2, e -> mainPanel.vaihdaNakyma("aloitus"));

        JButton valikkoNappi = peliPaneeli.getValikkoNappi();
        // Muut napit voitaisiin saada esim. uusiPeliNappi = peliPaneeli.getUusiPeliNappi();

        valikkoNappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valikonKorkeus = laskeValikonKorkeus(peliPaneeli.getValikkoMenu());
        
                // Aseta valikko oikein valikon komponenttien mukaisesti
                int x = 0; // Asettaa valikon napin vasempaan reunaan
                int y = -valikonKorkeus; // Asettaa valikon valikko napin yläpuolelle.
        
                peliPaneeli.showMenuAt(x, y);
            }
        });

        // Tähän tulisi toinen uusi actionListener tarvittaessa. esim
        // uusiPeliNappi.addActionListener(new ActionListener() .....)

    }

    private int laskeValikonKorkeus(JPopupMenu valikko) {
        int totalHeight = 0;
        Component[] valikonKomponentit = valikko.getComponents();
        for (Component komponentti : valikonKomponentit) {
            if (komponentti instanceof JMenuItem) {
                totalHeight += komponentti.getPreferredSize().height;
            }
        }
        return totalHeight;
    }
    
    private void showHelp() {
        System.out.println("Ohjeet valittu");
    }
}