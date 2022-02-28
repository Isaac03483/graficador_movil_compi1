package com.example.models;

import java.io.Serializable;
import java.util.List;

public class Envoltura<T> implements Serializable {

    private List<T> lista;

    public Envoltura(List<T> lista) {
        this.lista = lista;
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
}
