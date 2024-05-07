package com.pasianssipeli.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.pasianssipeli.controller.AloitusOhjain;
import com.pasianssipeli.controller.ValikkoOhjain;

// Creates the main window, which is the basis for all the windows.
public class MainPanel extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private JPanel aloitusRuutu;
    private JPanel peliRuutu;
    private JPanel asetusRuutu;

    public MainPanel() {
        setLayout(cardLayout);
        alustaIkkunat();
    }

    private void alustaIkkunat() {
        this.aloitusRuutu = luoAloitusPaneeli();
        add(aloitusRuutu, "aloitus");

        this.peliRuutu = luoPeliPaneeli();
        add(peliRuutu, "peli");

        this.asetusRuutu = luoAsetusPaneeli();
        add(asetusRuutu, "asetukset");

    }

    private AsetusPaneeli luoAsetusPaneeli() {
        AsetusPaneeli asetusPaneeli = new AsetusPaneeli(this);
        // TODO: Ohjaimet ja muut esim. napeille
        return asetusPaneeli;
    }

    private PeliPaneeli luoPeliPaneeli() {
        PeliPaneeli peliPaneeli = new PeliPaneeli(this); // Väliaikainen paneeli, joka palautetaan.
        new ValikkoOhjain(this, peliPaneeli); // Ohjaimet yhdistää elementtejä toisiinsa.
        return peliPaneeli;
    }

    private AloitusPaneeli luoAloitusPaneeli() {
        AloitusPaneeli aloitusPaneeli = new AloitusPaneeli(this); // Väliaikainen paneeli, joka palautetaan.
        new AloitusOhjain(this, aloitusPaneeli); // Ohjaimet yhdistää elementtejä toisiinsa.
        return aloitusPaneeli;
    }

    public void vaihdaNakyma(String naytonNimi) {
        cardLayout.show(this, naytonNimi);
    }

}
