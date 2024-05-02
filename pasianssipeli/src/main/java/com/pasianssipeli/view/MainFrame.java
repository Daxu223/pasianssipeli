package com.pasianssipeli.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private static int FRAME_WIDTH = 1080;
    private static int FRAME_HEIGHT = 920; 

    public MainFrame() {
        setTitle("Pasianssi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setResizable(false);

        // Lisää mainPanel ikkunaan.
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Keskitä näyttö avattaessa
        setVisible(true);
    }

    public static int getFrameY() {
        return FRAME_HEIGHT;
    }

    public static int getFrameX() {
        return FRAME_WIDTH;
    }
    
}
