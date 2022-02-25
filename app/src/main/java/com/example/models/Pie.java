package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Pie extends Grafica{

    private List<String> etiquetas;
    private List<Double> valores;
    private Tipo tipo;
    private Double total;
    private String extra;

    protected Pie(String titulo) {
        super(titulo);
        etiquetas = new ArrayList<>();
        valores = new ArrayList<>();
    }

    @Override
    void agregarTupla(Integer valorS, Integer valorD) {
        this.listaTupla.add(new Tupla(etiquetas.get(valorS), valores.get(valorD)));
    }

    public void agregarEtiqueta(String etiqueta){
        etiquetas.add(etiqueta);
    }

    public void agregarValor(Double valor){
        valores.add(valor);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = Tipo.encontrarTipo(tipo);
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
}
