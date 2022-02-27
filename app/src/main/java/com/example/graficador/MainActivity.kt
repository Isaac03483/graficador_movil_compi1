package com.example.graficador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.jflex_cup.graficadorcup.EjecutarCup
import com.example.jflex_cup.graficadorcup.GraficadorCup
import com.example.jflex_cup.graficadorflex.EjecutarLexico
import com.example.jflex_cup.graficadorflex.GraficadorLexico
import com.example.models.Grafica
import java.io.StringReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEjecutar = findViewById<Button>(R.id.ejecutarBoton);

        buttonEjecutar.setOnClickListener {
            val ejecutarCup = EjecutarCup(EjecutarLexico(StringReader(findViewById<EditText>(R.id.ejecucionEntrada).text.toString())));

            try {
                ejecutarCup.parse();
                val ejecutarLista = ejecutarCup.graficasEjecutar;

                if(ejecutarLista.isNotEmpty()){
                    val graficadorLexico = GraficadorLexico(StringReader(findViewById<EditText>(R.id.codificacionEntrada).text.toString()));
                    val graficadorCup = GraficadorCup(graficadorLexico);


                    graficadorCup.parse();

                    if(graficadorLexico.listaErrores.isEmpty() && graficadorCup.listaErrores.isEmpty()){

                        graficadorCup.graficador.filtrarGraficas(ejecutarLista);
                        val intent = Intent(this, GraficasActivity::class.java);
                        intent.putExtra("valor", graficadorCup.graficador);
                        startActivity(intent);
                    } else{
                        System.err.println("*NO SE CREA NADA POR ERRORES.");
                        graficadorCup.listaErrores.forEach(System.out::println);
                    }

                } else {
                    System.err.println("*NO HACE NADA");
                }

            } catch (e: java.lang.Exception){
                System.err.println("ALGO SALIO MAL :C");
                System.err.println(e.message)
            }
        }
    }

}