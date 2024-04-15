package com.pasianssipeli.view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

// Creates the main window, which is the basis for all the windows.
public class MainPanel extends JPanel {
    public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;
    private CardLayout cardLayout = new CardLayout();

    public MainPanel() {
        setLayout(cardLayout);
        alustaIkkunat();
    }

    // Use static, so multiple instances of window are not created.
    private void alustaIkkunat() {
        AloitusPaneeli aloitus = new AloitusPaneeli(this);
        add(aloitus, "aloitus");

        PeliPaneeli peli = new PeliPaneeli(this);
        add(peli, "peli");

    }

    public void vaihdaNakyma(String naytonNimi) {
        cardLayout.show(this, naytonNimi);
    }

}
