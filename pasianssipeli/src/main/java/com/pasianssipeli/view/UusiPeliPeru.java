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

        // Create a JScrollPane to add scrolling functionality to the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scroll bar
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Never show horizontal scroll bar

        // Add the scroll pane to the dialog
        dialog.add(scrollPane);

        // Set the size of the dialog
        dialog.setSize(500, 150);

        // Set the position of the dialog (centered on the screen)
        dialog.setLocationRelativeTo(null);

        // Make the dialog visible
        dialog.setVisible(true);
    }
}
