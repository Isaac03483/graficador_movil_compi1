package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Barra extends Grafica{

    private List<String> ejeX = new ArrayList<>();
    private List<Double> ejeY = new ArrayList<>();

    public Barra(String titulo, List<Tupla> listaTupla, List<String> ejeX, List<Double> ejeY) {
        super(titulo, listaTupla);
        this.ejeX.addAll(ejeX);
        this.ejeY.addAll(ejeY);
    }

    public List<String> getEjeX() {
        return ejeX;
    }

    public void setEjeX(List<String> ejeX) {
        this.ejeX = ejeX;
    }

    public List<Double> getEjeY() {
        return ejeY;
    }

    public void setEjeY(List<Double> ejeY) {
        this.ejeY = ejeY;
    }

    @Override
    public String toString() {
        return "Barras{" +
                "ejeX=" + ejeX +
                ", ejeY=" + ejeY +
                ", titulo='" + titulo + '\'' +
                ", listaTupla=" + listaTupla +
                '}';
    }
}
