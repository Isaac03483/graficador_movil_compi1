package com.example.models;

import java.util.List;

public abstract class Grafica {

    protected String titulo;
    protected List<Tupla> listaTupla;

    protected Grafica(String titulo){
        this.titulo = titulo;
    }

    abstract void agregarTupla(Integer valorS, Integer valorD);
}
