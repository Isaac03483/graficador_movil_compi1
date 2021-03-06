/*Primera sección: código de usuario.*/
package com.example.jflex_cup.graficadorflex;

import java_cup.runtime.*;
import com.example.jflex_cup.graficadorcup.sym;
import com.example.error.*;
import java.util.ArrayList;
import java.util.List;
import com.example.reportes.ReporteSigno;

%%

/*Segunda sección: configuración.*/

%class GraficadorLexico
%unicode
%line
%column
%cup
%public

%state COMENTARIO_BLOQUE
%state CADENA_BLOQUE
%state ERROR_BLOQUE

BLANCO = [\r|\n|\r\n] | [ \t\f] | " "
SALTO_LINEA = \n
DEF = "Def"|"def"
BARRAS = "Barras"
PIE = "Pie"
COMA = ","
TITULO = "titulo"
EJEX = "ejex"
EJEY = "ejey"
ETIQUETAS = "etiquetas"
VALORES = "valores"
UNIR = "unir"
TIPO = "tipo"
CANTIDAD = "Cantidad"
PORCENTAJE = "Porcentaje"
TOTAL = "total"
EXTRA = "extra"
ENTERO = 0|[1-9][0-9]*
DECIMAL = ({ENTERO})"."[0-9]+
SUMA = "+"
RESTA = "-"
MULTIPLICACION = "*"
DIVISION = "/"
COMILLA = \"
INICIO_COMENTARIO = "#"
DOS_PUNTOS = ":"
PUNTO_COMA = ";"
PARENTESIS_A = "("
PARENTESIS_C = ")"
CORCHETE_A = "["
CORCHETE_C = "]"
LLAVE_A = "{"
LLAVE_C = "}"

%{
    String cadenaTemporal = "";
    int inicioColumna = 0;
    List<ReporteSigno> listaReporteSigno = new ArrayList<>();

    private void cambiarCadena(String yytext){
        cadenaTemporal+=yytext;
    }

    List<ErrorObj> listaErrores = new ArrayList<>();

    private Symbol symbol(int type) {
        Symbol symbol = new Symbol(type, yyline+1, yycolumn+1);
        if(type == sym.CADENA){
            cadenaTemporal = "";
        }
        return symbol;
    }

    private Symbol symbol(int type, Object value) {
        Symbol symbol = new Symbol(type, yyline+1, yycolumn+1, value);
        cadenaTemporal = "";

        return symbol;
    }

    private void guardarError(int token){

        if(token != sym.EOF || !cadenaTemporal.equals("")){
            listaErrores.add(new ErrorObj(ErrorType.LEXICO,cadenaTemporal,"simbolo no reconocido", yyline+1, inicioColumna));
            cadenaTemporal = "";
        }
    }

    public List<ErrorObj> getListaErrores(){
        return listaErrores;
    }


    private void agregarSigno(String cadena){
        listaReporteSigno.add(new ReporteSigno(cadena, yyline+1, yycolumn+1));
    }

    public List<ReporteSigno> getReporte(){
        return listaReporteSigno;
    }


    private void obtenerComienzoError(int valor){
        inicioColumna = valor;
    }

%}
%%

/*Tercera sección: reglas léxicas.*/

<YYINITIAL>{
    {BLANCO}                        {;}
    {INICIO_COMENTARIO}             {yybegin(COMENTARIO_BLOQUE);}
    {COMILLA}                       {yybegin(CADENA_BLOQUE);}
    {COMA}                          {return symbol(sym.COMA);}
    {DEF}                           {return symbol(sym.DEF);}
    {BARRAS}                        {return symbol(sym.BARRAS);}
    {PIE}                           {return symbol(sym.PIE);}
    {TITULO}                        {return symbol(sym.TITULO);}
    {EJEX}                          {return symbol(sym.EJEX);}
    {EJEY}                          {return symbol(sym.EJEY);}
    {ETIQUETAS}                     {return symbol(sym.ETIQUETAS);}
    {VALORES}                       {return symbol(sym.VALORES);}
    {UNIR}                          {return symbol(sym.UNIR);}
    {TIPO}                          {return symbol(sym.TIPO);}
    {CANTIDAD}                      {return symbol(sym.CANTIDAD);}
    {PORCENTAJE}                    {return symbol(sym.PORCENTAJE);}
    {TOTAL}                         {return symbol(sym.TOTAL);}
    {EXTRA}                         {return symbol(sym.EXTRA);}
    {ENTERO}                        {return symbol(sym.ENTERO, new Integer(yytext()));}
    {DECIMAL}                       {return symbol(sym.DECIMAL, new Double(yytext()));}
    {SUMA}                          {agregarSigno("+");return symbol(sym.SUMA);}
    {RESTA}                         {agregarSigno("-");return symbol(sym.RESTA);}
    {MULTIPLICACION}                {agregarSigno("*");return symbol(sym.MULTIPLICACION);}
    {DIVISION}                      {agregarSigno("/");return symbol(sym.DIVISION);}
    {DOS_PUNTOS}                    {return symbol(sym.DOS_PUNTOS);}
    {PUNTO_COMA}                    {return symbol(sym.PUNTO_COMA);}
    {PARENTESIS_A}                  {return symbol(sym.PARENTESIS_A);}
    {PARENTESIS_C}                  {return symbol(sym.PARENTESIS_C);}
    {CORCHETE_A}                    {return symbol(sym.CORCHETE_A);}
    {CORCHETE_C}                    {return symbol(sym.CORCHETE_C);}
    {LLAVE_A}                       {return symbol(sym.LLAVE_A);}
    {LLAVE_C}                       {return symbol(sym.LLAVE_C);}
    [^]                             {obtenerComienzoError(yycolumn+1);cambiarCadena(yytext());yybegin(ERROR_BLOQUE);}
}

<CADENA_BLOQUE>{
    {COMILLA}                       {yybegin(YYINITIAL);return symbol(sym.CADENA, cadenaTemporal);}
    [^]                             {cambiarCadena(yytext());}
}

<COMENTARIO_BLOQUE>{
    {SALTO_LINEA}                   {yybegin(YYINITIAL);}
    [^]                             {;}
}
<<EOF>>                             {System.out.println("final del texto"); return symbol(sym.EOF);}

<ERROR_BLOQUE>{
    {BLANCO}                        {cambiarCadena(yytext());guardarError(10);yybegin(YYINITIAL);}
    [^]                             {cambiarCadena(yytext());}
    <<EOF>>                         {guardarError(sym.EOF); return symbol(sym.EOF);}
}
