package com.example.models;

import java.util.List;

public abstract class Grafica {

    protected String titulo;
    protected List<Tupla> listaTupla;

    public Grafica(String titulo, List<Tupla> listaTupla) {
        this.titulo = titulo;
        this.listaTupla = listaTupla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Tupla> getListaTupla() {
        return listaTupla;
    }

    public void setListaTupla(List<Tupla> listaTupla) {
        this.listaTupla = listaTupla;
    }
}
