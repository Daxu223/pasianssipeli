package com.pasianssipeli.view;

import java.awt.Dimension;

import javax.swing.JFrame;

// Creates the main window, which is the basis for all the windows.
public class IkkunanVaihtaja {
    public static final int WINDOW_WIDTH = 1080, WINDOW_HEIGHT = 720;

    // Use static, so multiple instances of window are not created.
    public static void teeIkkuna() {
        JFrame frame = new JFrame("Pasianssi"); // Create and set up window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set size of main window
        frame.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        // Display the window
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}