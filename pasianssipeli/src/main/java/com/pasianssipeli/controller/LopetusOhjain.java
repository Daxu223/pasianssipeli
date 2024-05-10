package com.pasianssipeli.controller;

import com.pasianssipeli.Main;
import com.pasianssipeli.view.MainPanel;
import com.pasianssipeli.view.LopetusPaneeli;

import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;

public class LopetusOhjain {
    private MainPanel mainPanel;
    private LopetusPaneeli lopetusPaneeli;

    public LopetusOhjain(MainPanel mainPanel, LopetusPaneeli lopetusPaneeli){
        this.mainPanel = mainPanel;
        this.lopetusPaneeli = lopetusPaneeli;
        addControlLogic();
    }

    private void addControlLogic() {
        
        JButton uusiPeli = lopetusPaneeli.getButton1();
        uusiPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainPanel.vaihdaNakyma("peli");
            }
        });

        JButton valikkoon = lopetusPaneeli.getButton2();
        valikkoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainPanel.vaihdaNakyma("aloitus");
            }
        });

    }
}
