package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Barras extends Grafica{

    private List<String> ejeX;
    private List<Double> ejeY;

    public Barras(String titulo, List<Tupla> listaTupla, List<String> ejeX, List<Double> ejeY) {
        super(titulo, listaTupla);
        this.ejeX = ejeX;
        this.ejeY= ejeY;
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
}
