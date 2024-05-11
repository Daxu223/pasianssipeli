package com.pasianssipeli.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LopetusDialog extends JDialog {

    public LopetusDialog(JFrame parent) {
        super(parent, "Vahvista", true);

        JDialog dialog = new JDialog();
        dialog.setTitle("Vahvista");
        dialog.setModal(true);

        JLabel label = new JLabel("<html>Haluatko varmasti<br>lopettaa pelin?</html>?", JLabel.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        JButton yesButton = new JButton("Kyllä");
        JButton noButton = new JButton("Ei");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Set the size of the dialog
        dialog.setSize(300, 150);

        // Set the position of the dialog (centered on the screen)
        dialog.setLocationRelativeTo(null);

        // Add action listeners to buttons
        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Sulje dialogi
            }
        });

        dialog.setVisible(true);
    }
}
