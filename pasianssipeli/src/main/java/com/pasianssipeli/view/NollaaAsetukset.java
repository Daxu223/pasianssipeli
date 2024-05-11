package com.pasianssipeli.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NollaaAsetukset extends JDialog {

    AsetusPaneeli asetukset;

    public NollaaAsetukset(JFrame parent, AsetusPaneeli asetusPaneeli) {
        super(parent, "Vahvista", true);
        this.asetukset = asetusPaneeli;

        JDialog dialog = new JDialog();
        dialog.setTitle("Vahvista");
        dialog.setModal(true); // Make it modal if needed

        // Create and add components to the dialog
        JLabel label = new JLabel("<html>Haluatko varmasti<br>nollata asetukset?</html>?", JLabel.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        JButton yesButton = new JButton("Kyllä");
        JButton noButton = new JButton("Ei");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setSize(300, 150);

        dialog.setLocationRelativeTo(null);

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                asetusPaneeli.resetAllButtons();
                dialog.dispose();
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
