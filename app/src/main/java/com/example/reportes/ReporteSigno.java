package com.example.reportes;

import java.io.Serializable;

public class ReporteSigno implements Serializable {

    private String operador;
    private Integer fila;
    private Integer columna;


    public ReporteSigno(String operador, Integer fila, Integer columna) {
        this.operador = operador;
        this.fila = fila;
        this.columna = columna;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getColumna() {
        return columna;
    }

    public void setColumna(Integer columna) {
        this.columna = columna;
    }
}
