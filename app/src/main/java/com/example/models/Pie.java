package com.example.models;

import java.util.List;

public class Pie extends Grafica{

    private List<String> etiquetas;
    private List<Double> valores;
    private Tipo tipo;
    private Double total;
    private String extra;

    public Pie(String titulo, List<Tupla> listaTupla, List<String> etiquetas, List<Double> valores, Tipo tipo, Double total, String extra) {
        super(titulo, listaTupla);
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.tipo = tipo;
        this.total = total;
        this.extra = extra;

    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Pie{" +
                "titulo='" + titulo + '\'' +
                ", listaTupla=" + listaTupla +
                ", etiquetas=" + etiquetas +
                ", valores=" + valores +
                ", tipo=" + tipo +
                ", total=" + total +
                ", extra='" + extra + '\'' +
                '}';
    }
}
