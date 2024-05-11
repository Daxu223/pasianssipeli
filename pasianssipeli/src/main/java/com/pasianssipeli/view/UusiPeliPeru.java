package com.pasianssipeli.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class UusiPeliPeru extends JDialog {

    public UusiPeliPeru(JFrame parent) {
        super(parent, "Huomio", false);

        JDialog dialog = new JDialog();
        dialog.setTitle("Huomio");
        dialog.setModal(true); // Make it modal if needed

        String preWrittenText = "<html>Pasianssi-pelistämme puuttuu toimintalogiikka.<br>\"Uusi Peli\" sekä \"Peru\" -toiminnot eivät ole käytössä.</html>";

        JLabel textArea = new JLabel(preWrittenText);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        dialog.add(scrollPane);

        dialog.setSize(500, 150);

        // Keskitä näyttö
        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }
}
