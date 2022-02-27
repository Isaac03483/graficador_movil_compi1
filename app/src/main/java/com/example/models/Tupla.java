package com.example.models;

import java.io.Serializable;

public class Tupla implements Serializable {

    private Integer valorL;
    private Integer valorR;

    public Tupla(Integer valorL, Integer valorR){
        this.valorL = valorL;
        this.valorR = valorR;
    }

    public Integer getValorL() {
        return valorL;
    }

    public void setValorL(Integer valorL) {
        this.valorL = valorL;
    }

    public Integer getValorR() {
        return valorR;
    }

    public void setValorR(Integer valorR) {
        this.valorR = valorR;
    }

    @Override
    public String toString() {
        return "Tupla{" +
                "valorL=" + valorL +
                ", valorR=" + valorR +
                '}';
    }
}
