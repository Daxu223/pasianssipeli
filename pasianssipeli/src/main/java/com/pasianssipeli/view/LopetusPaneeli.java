package com.pasianssipeli.view;

import javax.swing.*;

import java.awt.*;

public class LopetusPaneeli extends JPanel {

    private JButton b1;
    private JButton b2;

    public LopetusPaneeli(MainPanel mainPanel) {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, 250));
        this.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));

        JLabel titleLabel = new JLabel("VOITIT PELIN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setForeground(Color.green);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // One row, three columns, 10px horizontal and vertical gaps
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding
        centerPanel.add(createPanel("Aika: #", "Pisteet: #", "Siirrot: #"));
        centerPanel.add(createLeaderboardPanel("1. Sija", "2. Sija", "3. Sija", "4. Sija", "5. Sija"));
        centerPanel.add(createButtonPanel());

        this.add(centerPanel, BorderLayout.CENTER);
    }

    private static JPanel createPanel(String labelText1, String labelText2, String labelText3) {
        JPanel panel = new JPanel(new GridLayout(3, 1)); // Three rows, one column
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(new JLabel(labelText1, JLabel.CENTER));
        panel.add(new JLabel(labelText2, JLabel.CENTER));
        panel.add(new JLabel(labelText3, JLabel.CENTER));
        return panel;
    }

    private static JPanel createLeaderboardPanel(String t1, String t2, String t3, String t4, String t5) {
        JPanel panel = new JPanel(new GridLayout(5, 1)); // Three rows, one column
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(new JLabel(t1, JLabel.CENTER));
        panel.add(new JLabel(t2, JLabel.CENTER));
        panel.add(new JLabel(t3, JLabel.CENTER));
        panel.add(new JLabel(t4, JLabel.CENTER));
        panel.add(new JLabel(t5, JLabel.CENTER));
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1)); // Three rows, one column
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.b1 = new JButton("Uusi Peli");
        this.b2 = new JButton("Valikko");

        b1.setBackground(Color.green);
        b2.setBackground(Color.cyan);

        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(this.b1);
        panel.add(this.b2);
        return panel;
    }

    public JButton getButton1(){
        return this.b1;
    }

    public JButton getButton2(){
        return this.b2;
    }

}
