package com.pasianssipeli.controller;

import com.pasianssipeli.view.MainPanel;
import com.pasianssipeli.view.OhjeFrame;
import com.pasianssipeli.view.PeliPaneeli;
import com.pasianssipeli.Main;
import com.pasianssipeli.view.AloitusPaneeli;
import com.pasianssipeli.view.LopetusDialog;
import com.pasianssipeli.view.MainFrame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class AloitusOhjain {
    private MainPanel mainPanel;
    private MainFrame mainFrame;
    private AloitusPaneeli aloitusPaneeli;

    public AloitusOhjain(MainPanel mainPanel, MainFrame mainFrame, AloitusPaneeli aloitusPaneeli) {
        this.mainPanel = mainPanel;
        this.aloitusPaneeli = aloitusPaneeli;
        this.mainFrame = mainFrame; // Tuotu, koska dialogi halutaan liittää tähän.
        addControlLogic();
    }

    private void addControlLogic() {

        JLabel aloitaLabel = aloitusPaneeli.getNappi1();
        aloitaLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                aloitaLabel.setText("<html><u>ALOITA</u></html>");
            }
            public void mouseExited(MouseEvent e){
                aloitaLabel.setText("ALOITA");
            }
            public void mouseClicked(MouseEvent e){
                mainPanel.vaihdaNakyma("peli");
            }
        });

        JLabel asetuksetLabel = aloitusPaneeli.getNappi2();
        asetuksetLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                asetuksetLabel.setText("<html><u>ASETUKSET</u></html>");
            }
            public void mouseExited(MouseEvent e){
                asetuksetLabel.setText("ASETUKSET");
            }
            public void mouseClicked(MouseEvent e){
                mainPanel.vaihdaNakyma("asetukset");
            }
        });

        JLabel ohjeetLabel = aloitusPaneeli.getNappi3();
        ohjeetLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                ohjeetLabel.setText("<html><u>OHJEET</u></html>");
            }
            public void mouseExited(MouseEvent e){
                ohjeetLabel.setText("OHJEET");
            }
            public void mouseClicked(MouseEvent e){
                MainFrame mainFrame = mainPanel.getMainFrame();
                new OhjeFrame(mainFrame);
            }
        });

        JLabel lopetaLabel = aloitusPaneeli.getNappi4();
        lopetaLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                lopetaLabel.setText("<html><u>LOPETA</u></html>");
            }
            public void mouseExited(MouseEvent e){
                lopetaLabel.setText("LOPETA");
            }
            public void mouseClicked(MouseEvent e){
                MainFrame mainFrame = mainPanel.getMainFrame();
                new LopetusDialog(mainFrame);
            }
        });

    }
}
