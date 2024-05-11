package com.pasianssipeli.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import com.pasianssipeli.view.AsetusPaneeli;
import com.pasianssipeli.view.MainFrame;
import com.pasianssipeli.view.MainPanel;
import com.pasianssipeli.view.NollaaAsetukset;


public class AsetusOhjain {
    MainPanel mainPanel;
    MainFrame mainFrame;
    AsetusPaneeli asetusPaneeli;

    JButton backButton;
    JButton closeButton;
    JButton nollaaButton;
    
    public AsetusOhjain(MainPanel mainPanel, MainFrame mainFrame, AsetusPaneeli asetusPaneeli) {
        this.mainPanel = mainPanel;
        this.asetusPaneeli = asetusPaneeli;
        this.mainFrame = mainFrame;
        assignButtons();
        addControlLogic();
    }

    void assignButtons() {
        this.backButton = asetusPaneeli.getBackButton();
        this.closeButton = asetusPaneeli.getCloseButton();
        this.nollaaButton = asetusPaneeli.getNollausNappi();
    }

      private void addControlLogic() {

        backButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                mainPanel.vaihdaNakyma(mainPanel.getEdellinenRuutu());
            }
        });

        closeButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainPanel.vaihdaNakyma(mainPanel.getEdellinenRuutu());
            }            
        });

        nollaaButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MainFrame mainFrame = mainPanel.getMainFrame();
                new NollaaAsetukset(mainFrame, asetusPaneeli);
            }            
        });
    }
}
