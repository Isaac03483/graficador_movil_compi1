package com.example.error;

public enum ErrorType {

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
