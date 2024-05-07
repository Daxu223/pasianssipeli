package com.pasianssipeli.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AloitusPaneeli extends JPanel {

    private JPanel otsikkopaneeli;
    private JPanel keskipaneeli;
    private JPanel alapaneeli;

    private JLabel nappi1;
    private JLabel nappi2;
    private JLabel nappi3;
    private JLabel nappi4;

    private Font tekstinKoko = new Font("Arial", Font.BOLD, 18);
    private Dimension nappienKoko = new Dimension(50, 30);

    public AloitusPaneeli(MainPanel mainPanel) {

        this.setLayout(new BorderLayout());
        this.keskipaneeli = teeKeskipaneeli();
        this.alapaneeli = teeAlapaneeli();
        this.otsikkopaneeli = teeOtsikkopaneeli();

        this.add(keskipaneeli, BorderLayout.CENTER);
        this.add(alapaneeli, BorderLayout.SOUTH);
        this.add(otsikkopaneeli, BorderLayout.NORTH);

    }  

    private JPanel teeOtsikkopaneeli() {

        JPanel otsikkopaneeli = new JPanel();
        otsikkopaneeli.setLayout(new BorderLayout());
        //otsikkopaneeli.setBackground(Color.green);
        otsikkopaneeli.setPreferredSize(new Dimension(MainFrame.getFrameX(), 400));

        JLabel otsikko = new JLabel("PASIANSSI", JLabel.CENTER);
        otsikko.setFont(new Font("Arial", Font.BOLD, 100));

        otsikkopaneeli.add(otsikko, BorderLayout.PAGE_END);

        return otsikkopaneeli;
    }

    private JPanel teeKeskipaneeli() {

        JPanel keskipaneeli = new JPanel();
        keskipaneeli.setLayout(new GridBagLayout());
        //keskipaneeli.setBackground(Color.red);
        keskipaneeli.setPreferredSize(new Dimension(MainFrame.getFrameX(), 200));
        keskipaneeli.setBorder(BorderFactory.createEmptyBorder(0,360,0,300));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0.2;

        this.nappi1 = new JLabel("ALOITA");
        nappi1.setFont(new Font("Arial", Font.BOLD, 15));

        this.nappi2 = new JLabel("ASETUKSET");
        nappi2.setFont(new Font("Arial", Font.BOLD, 15));

        this.nappi3 = new JLabel("OHJEET");
        nappi3.setFont(new Font("Arial", Font.BOLD, 15));

        this.nappi4 = new JLabel("LOPETA");
        nappi4.setFont(new Font("Arial", Font.BOLD, 15));

        keskipaneeli.add(nappi1, gbc);
        keskipaneeli.add(nappi2, gbc);
        keskipaneeli.add(nappi3, gbc);
        keskipaneeli.add(nappi4, gbc);

        return keskipaneeli;
    }

    private JPanel teeAlapaneeli() {
        
        JPanel alapaneeli = new JPanel();
        alapaneeli.setLayout(new BorderLayout());

        JLabel tekijat = new JLabel("© Samu Kollin & Jaakko Ollila", JLabel.CENTER);

        alapaneeli.add(tekijat, BorderLayout.WEST);

        return alapaneeli;
    }

    //Nappi getterit
    public JLabel getNappi1(){
        return this.nappi1;
    }
    public JLabel getNappi2(){
        return this.nappi2;
    }
    public JLabel getNappi3(){
        return this.nappi3;
    }
    public JLabel getNappi4(){
        return this.nappi4;
    }

    /*public void addButtonItemListener(int menuItemIndex, ActionListener listener) {
        JLabel item = getMenuItem(menuItemIndex);
        if (item != null) {
            item.addActionListener(listener);
        }
    }*/
}
