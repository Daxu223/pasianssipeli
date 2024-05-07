package com.pasianssipeli.controller;

import com.pasianssipeli.view.MainPanel;
import com.pasianssipeli.view.PeliPaneeli;
import com.pasianssipeli.view.AloitusPaneeli;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

public class AloitusOhjain {
    private MainPanel mainPanel;
    private AloitusPaneeli aloitusPaneeli;

    public AloitusOhjain(MainPanel mainPanel, AloitusPaneeli aloitusPaneeli) {
        this.mainPanel = mainPanel;
        this.aloitusPaneeli = aloitusPaneeli;
        addControlLogic();
    }

    private void addControlLogic() {

        JLabel aloitaLabel = aloitusPaneeli.getNappi1();
        aloitaLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                mainPanel.vaihdaNakyma("peli");
            }
        });

        JLabel asetuksetLabel = aloitusPaneeli.getNappi2();
        asetuksetLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                mainPanel.vaihdaNakyma("asetukset");
            }
        });

        JLabel ohjeetLabel = aloitusPaneeli.getNappi3();
        ohjeetLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                mainPanel.vaihdaNakyma("ohjeet");
            }
        });

        JLabel lopetaLabel = aloitusPaneeli.getNappi4();
        lopetaLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                //TÄHÄN HALUATKO VARMASTI LOPETTAA RUUTU
                mainPanel.vaihdaNakyma("lopeta");
            }
        });

    }
}
