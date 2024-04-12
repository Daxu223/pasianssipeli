package com.pasianssipeli.model;

import java.util.LinkedList;
import java.util.Collections;

public class Pakka {
    
    private LinkedList<Kortti> pakka;

    //Konstruktori, jossa luodaan pakkaan kaikki 52 Kortti-objektia.
    public Pakka(){
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
