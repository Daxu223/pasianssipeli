package com.pasianssipeli.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OhjeFrame extends JDialog {

    public OhjeFrame(JFrame parent) {
        super(parent, "Ohjeet", false);

        JDialog dialog = new JDialog();
        dialog.setTitle("Ohjeet");
        dialog.setModal(true); // Make it modal if needed

        String preWrittenText = "<html>Tavoite:<br>Järjestä kaikki kortit nousevaan järjestykseen maan mukaan neljään peruskasaan.<br><br>Asettelu:<br>Jaa 7 kortin pilaria.<br>Käännä jokaisen pilarin ylimmäinen kortti näkyväksi.<br>Aseta loput kortit piilokasaksi alaspäin.<br><br>Pelikuvaus:<br>Rakenna laskevia sarjoja vuorottelevilla väreillä pilarissa.<br>Siirrä kortteja pilarin välillä paljastaaksesi piilokortteja.<br>Käytä piilokasaa lisätäksesi kortteja pilariin.<br><br>Voittaminen:<br>Voita siirtämällä kaikki kortit onnistuneesti peruskasoihin nousevassa järjestyksessä maan mukaan.</html>";

        JLabel textArea = new JLabel(preWrittenText);

        // Create a JScrollPane to add scrolling functionality to the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scroll bar
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Never show horizontal scroll bar

        // Add the scroll pane to the dialog
        dialog.add(scrollPane);

        // Set the size of the dialog
        dialog.setSize(750, 350);

        // Set the position of the dialog (centered on the screen)
        dialog.setLocationRelativeTo(null);

        // Make the dialog visible
        dialog.setVisible(true);
    }
}