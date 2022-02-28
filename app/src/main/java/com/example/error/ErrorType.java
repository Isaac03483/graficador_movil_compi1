package com.example.error;

import java.io.Serializable;

public enum ErrorType implements Serializable {

    LEXICO("Lexico"),
    SINTACTICO("Sintáctico");

    private String type;

    ErrorType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public static ErrorType obtenerTipo(String value){
        if(value.equals(LEXICO.getType())){
            return LEXICO;
        } else if(value.equals(SINTACTICO.getType())){
            return SINTACTICO;
        }

        return null;
    }
}
