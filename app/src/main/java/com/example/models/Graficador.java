package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Graficador {

    private String titulo;
    private List<String> ejeX;
    private List<Double> ejeY;
    private List<String> etiqueta;
    private List<Double> valor;
    private List<Tupla> tuplas;
    private List<Grafica> graficas;
    private Tipo tipo;
    private Double total;
    private String extra;

    public Graficador() {

        titulo = null;
        graficas = new ArrayList<>();
        ejeX = new ArrayList<>();
        ejeY = new ArrayList<>();
        etiqueta = new ArrayList<>();
        valor = new ArrayList<>();
        tuplas = new ArrayList<>();
        tipo = null;
        total = null;
        extra = null;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEjeX(List<String> ejeX) {
        this.ejeX = ejeX;
    }

    public void setEtiqueta(List<String> etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo(){
        return this.tipo;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void agregarEjeY(Double expd){
        ejeY.add(expd);
    }

    public void agregarValor(Double expd){
        valor.add(expd);
    }

    public void agregarTupla(Integer e1, Integer e2){
        tuplas.add(new Tupla(e1, e2));
    }

    public void crearGraficaBarras(){
        graficas.add(new Barras(this.titulo, this.tuplas, this.ejeX, this.ejeY));
        this.titulo = null;
        this.tuplas.clear();
        this.ejeX.clear();
        this.ejeY.clear();
    }

    public void crearGraficaPie(){
        if(this.tipo == Tipo.PORCENTAJE){
            this.total = 360.0;
        }

        graficas.add(new Pie(this.titulo, this.tuplas, this.etiqueta, this.valor, this.tipo, this.total,this.extra));
        this.titulo = null;
        this.tuplas.clear();
        this.etiqueta.clear();
        this.valor.clear();
        this.tipo = null;
        this.total = null;
        this.extra = null;
    }
}
