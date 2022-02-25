package com.example.graficador

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.jflex_cup.graficadorcup.GraficadorCup
import com.example.jflex_cup.graficadorflex.GraficadorLexico
import java.io.StringReader

class MainActivity : AppCompatActivity() {

    var boton: Button? = null;
    var codificacionEntrada: EditText? = null;
    var ejecucionEntrada: EditText? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }

    fun init(){

        iniciarEntradas();
        iniciarBoton();

    }

    fun iniciarBoton(){
        boton = findViewById(R.id.ejecutarBoton)
        boton?.setOnClickListener {

            var texto = codificacionEntrada?.text;
            var graficador = GraficadorCup(GraficadorLexico(StringReader(texto.toString())));



            try{
                graficador.parse();
            } catch (e: java.lang.Exception){
                error("un error");
            }
        }

    }

    fun iniciarEntradas(){

        codificacionEntrada = findViewById(R.id.codificacionEntrada);
        ejecucionEntrada = findViewById(R.id.ejecucionEntrada);

    }

}