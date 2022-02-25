/*Primera sección: código de usuario.*/
package com.example.jflex_cup.graficadorflex;

import java_cup.runtime.*;
import com.example.jflex_cup.graficadorcup.ejecutarsym;

%%

/*Segunda sección: configuración.*/

%class EjecutarLexico
%unicode
%line
%column
%cup
%public

%state CADENA_BLOQUE

BLANCO = [\r|\n|\r\n] | [ \t\f] | " "
COMILLA = \"
EJECUTAR = "ejecutar"
PUNTO_COMA = ";"
PARENTESIS_A = "("
PARENTESIS_C = ")"

%{

    String cadenaTemporal = "";

    private void cambiarCadena(String yytext){
        cadenaTemporal+=yytext;
    }


    private Symbol symbol(int type) {
        System.out.println("tipo: "+type);
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        System.out.println("tipo: "+type+" VALOR: "+value);
        Symbol symbol = new Symbol(type, yyline+1, yycolumn+1, value);
        if(type == ejecutarsym.CADENA){
            cadenaTemporal = "";
        }
        return symbol;
    }

    private void error(String message) {
        System.out.println("Error en linea: "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
    }
%}

%%

/*Tercera sección: reglas léxicas.*/

<YYINITIAL>{
    {BLANCO}                        {;}
    {EJECUTAR}                      {return symbol(ejecutarsym.EJECUTAR);}
    {COMILLA}                       {yybegin(CADENA_BLOQUE);}
    {PUNTO_COMA}                    {return symbol(ejecutarsym.PUNTO_COMA);}
    {PARENTESIS_A}                  {return symbol(ejecutarsym.PARENTESIS_A);}
    {PARENTESIS_C}                  {return symbol(ejecutarsym.PARENTESIS_C);}
}

<CADENA_BLOQUE>{
    {COMILLA}                       {yybegin(YYINITIAL);return symbol(ejecutarsym.CADENA, cadenaTemporal);}
    [^]                             {cambiarCadena(yytext());}
}

<<EOF>>                             {System.out.println("final del texto"); return symbol(ejecutarsym.EOF);}
[^]                                 {error("Simbolo invalido <"+ yytext()+">");}
