package com.example.models;

import java.io.Serializable;

public enum Tipo implements Serializable {

    PORCENTAJE("Porcentaje"),
    CANTIDAD("Cantidad");

    private String tipo;

    Tipo(String tipo){
        this.tipo = tipo;
    }

    public static Tipo encontrarTipo(String tipo){
        if(tipo.equals(Tipo.PORCENTAJE.getTipo())){
            return Tipo.PORCENTAJE;
        } else if(tipo.equals(Tipo.CANTIDAD.getTipo())){
            return Tipo.CANTIDAD;
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }
}
