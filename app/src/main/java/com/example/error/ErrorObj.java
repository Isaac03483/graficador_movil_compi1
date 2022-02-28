package com.example.error;

import java.io.Serializable;

public class ErrorObj implements Serializable {

    private ErrorType errorType;
    private String lexema;
    private String message;
    private Integer fila;
    private Integer columna;

    public ErrorObj(ErrorType errorType,String lexema ,String message, Integer fila, Integer columna) {
        this.errorType = errorType;
        this.message = message;
        this.lexema = lexema;
        this.fila =fila;
        this.columna = columna;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    @Override
    public String toString() {
        return "ErrorObj{" +
                "errorType=" + errorType +
                ", lexema='" + lexema + '\'' +
                ", message='" + message + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
