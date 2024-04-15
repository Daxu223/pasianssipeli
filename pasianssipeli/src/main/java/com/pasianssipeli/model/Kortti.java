//Kortti-luokka sisältää kortin arvon ja maan.
package com.pasianssipeli.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Kortti {

    public static String cardBackFilename = "back001",
	cardOutlineFilename = "bottom01",
	fpBaseFilename = "fpBase0";

    public static String directory = "src/main/resources/cards", extension = ".gif"; // tähän korttikansion polku
    private Image im;
    private boolean faceUp;
    private Integer kortinArvo = null;
    private String kortinMaa = null;
    private Väri väri;

    public Kortti(){}

    public Kortti(Integer arvo, String maa){
        this.kortinArvo = arvo;
        this.kortinMaa = maa;

        switch (maa) {
            case "d":
                this.väri = Väri.Red;        
                break;
        
            case "h":
                this.väri = Väri.Red;
                break;

            case "s":
                this.väri = Väri.Black;
                break;

            case "c":
                this.väri = Väri.Black;
                break;

            default:
                this.väri = Väri.Neither;
                break;
        }

        faceUp = false;

        try {
			ImageIcon ii = new ImageIcon(getClass().getResource(directory + cardFile(kortinMaa, kortinArvo)));
			im = ii.getImage();
		}catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
    }

    private String cardFile(String maa, Integer arvo) {
		char ch;
		
		if (arvo < 1 || arvo > 13)
			throw new IllegalArgumentException("Kortin arvo ei ole välillä 1-13");
		
		if(maa.equals("c")) {
			ch = 'c';
		}else if(maa.equals("h")) {
			ch = 'h';
		}else if(maa.equals("s")) {
			ch = 's';
		}else if(maa.equals("d")) {
			ch = 'd';
		}
		else throw new IllegalArgumentException("Bad Card Suit");
		
		if(arvo < 10)
			return "/0" + arvo + ch + extension;
		else
			return "/" + arvo + ch + extension;
	}

    public Image getCardImage() {
		return im;
	}

    public boolean isFaceUp() {
		return faceUp;
	}

    public Väri getColour() {
		return väri;
	}

    //SETTERIT
    public void setKortinArvo(Integer arvo){
        if(arvo <= 13 && arvo >= 1){
            this.kortinArvo = arvo;
        }
    }

    public void setKortinMaa(String maa){
        // clubs, spades, diamonds, hearts
        if(maa == "c" || maa == "s" || maa == "d" || maa == "h"){
            this.kortinMaa = maa;
        }
    }

    //GETTERIT
    public Integer getKortinArvo(){
        return this.kortinArvo;
    }

    public String getKortinMaa(){
        return this.kortinMaa;
    }
}