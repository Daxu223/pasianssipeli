package com.pasianssipeli.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.pasianssipeli.controller.AloitusOhjain;
import com.pasianssipeli.controller.AsetusOhjain;
import com.pasianssipeli.controller.ValikkoOhjain;

// Creates the main window, which is the basis for all the windows.
public class MainPanel extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private MainFrame mainFrame;
    private JPanel aloitusRuutu;
    private JPanel peliRuutu;
    private JPanel asetusRuutu;

    private String edellinenRuutu;

    public MainPanel() {
        setLayout(cardLayout);
        alustaIkkunat();
    }

    private void alustaIkkunat() {
        this.edellinenRuutu = "aloitus"; // Ensimmäinen ruutu on aloitusruutu.

        this.aloitusRuutu = luoAloitusPaneeli();
        add(aloitusRuutu, "aloitus");

        this.peliRuutu = luoPeliPaneeli();
        add(peliRuutu, "peli");

        this.asetusRuutu = luoAsetusPaneeli();
        add(asetusRuutu, "asetukset");

    }

    private PeliPaneeli luoPeliPaneeli() {
        PeliPaneeli peliPaneeli = new PeliPaneeli(this); // Väliaikainen paneeli, joka palautetaan.
        new ValikkoOhjain(this, peliPaneeli); // Ohjaimet yhdistää elementtejä toisiinsa.
        return peliPaneeli;
    }

    private AloitusPaneeli luoAloitusPaneeli() {
        AloitusPaneeli aloitusPaneeli = new AloitusPaneeli(this); // Väliaikainen paneeli, joka palautetaan.
        new AloitusOhjain(this, mainFrame, aloitusPaneeli); // Ohjaimet yhdistää elementtejä toisiinsa.
        return aloitusPaneeli;
    }

    private AsetusPaneeli luoAsetusPaneeli() {
        AsetusPaneeli asetusPaneeli = new AsetusPaneeli(this); // Väliaikainen paneeli, joka palautetaan.
        new AsetusOhjain(this, mainFrame, asetusPaneeli); // Ohjaimet yhdistää elementtejä toisiinsa.
        return asetusPaneeli;
    }


    public void vaihdaNakyma(String naytonNimi) {
        cardLayout.show(this, naytonNimi);

        // Jos halutaan palata aikasempaan näyttöön, josta on juuri tultu, niin edellinen ruutu pitää muistaa.
        if (naytonNimi != "asetukset") {
            edellinenRuutu = naytonNimi;
        }
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public String getEdellinenRuutu() {
        return edellinenRuutu;
    }

}
