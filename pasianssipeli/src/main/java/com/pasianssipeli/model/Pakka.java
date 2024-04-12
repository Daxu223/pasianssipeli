package com.pasianssipeli.model;

import java.util.LinkedList;

public class Pakka {
    
    private LinkedList<Kortti> pakka;

    //Konstruktori, jossa luodaan pakkaan kaikki 52 Kortti-objektia.
    public Pakka(){
        String[] maat = {"h", "s", "d", "c"};

        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                pakka.add(new Kortti(j,maat[i]));
            }
        }
    }



}
