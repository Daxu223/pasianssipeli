package com.pasianssipeli;

import javax.swing.*;

import com.pasianssipeli.view.MainFrame;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}