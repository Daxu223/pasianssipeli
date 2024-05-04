package com.pasianssipeli.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.pasianssipeli.controller.ValikkoOhjain;

// Creates the main window, which is the basis for all the windows.
public class MainPanel extends JPanel {
    private CardLayout cardLayout = new CardLayout();

    public MainPanel() {
        setLayout(cardLayout);
        alustaIkkunat();
    }

    // Use static, so multiple instances of window are not created.
    private void alustaIkkunat() {
        AloitusPaneeli aloitus = new AloitusPaneeli(this);
        add(aloitus, "aloitus");

        PeliPaneeli peli = luoPeliPaneeli();
        add(peli, "peli");

    }

    private PeliPaneeli luoPeliPaneeli() {
        PeliPaneeli peliPaneeli = new PeliPaneeli(this);
        new ValikkoOhjain(this, peliPaneeli); // Ohjaimet yhdistää elementtejä toisiinsa.
        return peliPaneeli;
    }

    public void vaihdaNakyma(String naytonNimi) {
        cardLayout.show(this, naytonNimi);
    }

}
