package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Barras extends Grafica{

    private List<String> ejeX;
    private List<Double> ejeY;

    protected Barras(String titulo) {
        super(titulo);
        ejeX = new ArrayList<>();
        ejeY= new ArrayList<>();
    }

    public void agregarEjeX(String cadena){
        ejeX.add(cadena);
    }

    public void agregarEjeY(Double valor){
        ejeY.add(valor);
    }

    @Override
    void agregarTupla(Integer valorS, Integer valorD) {
        this.listaTupla.add(new Tupla(ejeX.get(valorS), ejeY.get(valorD)));
    }


}
