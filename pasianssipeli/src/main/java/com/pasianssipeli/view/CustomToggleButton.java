package com.pasianssipeli.view;

import javax.swing.*;
import java.awt.*;

public class CustomToggleButton extends JToggleButton {
    private Color selectedColor = Color.RED;
    private Color unselectedColor = Color.GREEN;

    public CustomToggleButton(String text) {
        super(text);
        setContentAreaFilled(false); // Tämä kai poistaa napin reunat: Värin vaihto ei toimi ilman tätä
        setOpaque(true);
        setBackground(unselectedColor); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isSelected()) {
            setBackground(selectedColor);
            setText("Pois");
        } else {
            setBackground(unselectedColor);
            setText("Päällä");
        }
        super.paintComponent(g);
    }

    public void defaultSetting() {
        super.setSelected(false);
    }
}
