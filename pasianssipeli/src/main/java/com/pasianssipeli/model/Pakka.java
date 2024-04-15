//Pakka-luokka sisältää linkitetyn listan korttipakan korteista, ja metodilla sekoitaPakka() voi sekoittaa kortit.
package com.pasianssipeli.model;

import java.util.LinkedList;
import java.awt.*;
import java.util.Collections;

public class Pakka extends Pino{
    
    private LinkedList<Kortti> pakka;

    //Konstruktori, jossa luodaan pakkaan kaikki 52 Kortti-objektia.
    public Pakka(int x, int y){
        super(x, y);
        super.setSize(x, y); // TäHÄN TULEE KORTIN RESOLUUTIO!!!

        pakka = new LinkedList<Kortti>();
        String[] maat = {"h", "s", "d", "c"};

        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                pakka.add(new Kortti(j,maat[i]));
            }
        }
    }

    //Metodi korttipakan sekoittamiseen.
    public void sekoitaPakka(){
        Collections.shuffle(pakka);
    }

    //Getterit
    public LinkedList<Kortti> getPakka(){
        return this.pakka;
    }

    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.WHITE);
		g2d.drawRect(0, 0, 72, this.getHeight());

        // Pakka printtaantuu, jos pakka ei ole tyhjä. 15.4. ei toimi jonkin asian takia. Tutki asiaa.
		// if (!isEmpty()) {
			g.drawImage(Kortti.getCardBack(), 0, 0, 72, this.getHeight(), this);
		// }
	}

    //toString jolla testattiin sekoittamista.
    @Override
    public String toString(){
        StringBuilder palautus = new StringBuilder();

        for(Kortti kortti : pakka) {
            palautus.append(kortti.getKortinMaa() + kortti.getKortinArvo() + ", ");
        }

        return palautus.toString();

    }
}
