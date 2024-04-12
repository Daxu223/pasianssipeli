package com.pasianssipeli.model;

public class Kortti {

    private Integer kortinArvo = null;
    private String kortinMaa = null;

    public Kortti(){}

    public Kortti(Integer arvo, String maa){
        this.kortinArvo = arvo;
        this.kortinMaa = maa;
    }

    //SETTERIT
    public void setKortinArvo(Integer arvo){
        if(arvo <= 13 && arvo >= 1){
            this.kortinArvo = arvo;
        }
    }

    public void setKortinMaa(String maa){
        if(maa == "Risti" || maa == "Pata" || maa == "Ruutu" || maa == "Hertta"){
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