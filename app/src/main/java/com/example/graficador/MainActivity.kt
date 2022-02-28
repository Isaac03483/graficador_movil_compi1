package com.example.graficador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.models.Envoltura
import com.example.jflex_cup.graficadorcup.EjecutarCup
import com.example.jflex_cup.graficadorcup.GraficadorCup
import com.example.jflex_cup.graficadorflex.EjecutarLexico
import com.example.jflex_cup.graficadorflex.GraficadorLexico
import com.example.reportes.ReporteSigno
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
                        findViewById<Button>(R.id.graficasBoton).setOnClickListener {
                            val intent = Intent(this, GraficasActivity::class.java);
                            intent.putExtra("valor", graficadorCup.graficador);
                            startActivity(intent);
                        }

                        findViewById<Button>(R.id.operadorBoton).setOnClickListener {
                            val intent = Intent(this, OperadorActivity::class.java);
                            intent.putExtra("listaOperador", Envoltura(graficadorLexico.reporte));
                            startActivity(intent);
                        }

                        findViewById<TextView>(R.id.textoBarras).setText("NÚMERO DE GRÁFICAS DE BARRAS: "+graficadorCup.graficador.barrasContador);
                        findViewById<TextView>(R.id.textoPies).setText("NÚMERO DE GRÁFICAS DE PIE: "+graficadorCup.graficador.pieContador);

                        Toast.makeText(applicationContext, "Gráfica(s) generadas con éxito.", Toast.LENGTH_SHORT).show();
                    } else{

                        findViewById<Button>(R.id.errorBoton).setOnClickListener{
                            val intent = Intent(this, ErrorActivity::class.java);
                            intent.putExtra("errorSintactico",
                                Envoltura(graficadorCup.listaErrores)
                            );
                            intent.putExtra("errorLexico",
                                Envoltura(graficadorLexico.listaErrores)
                            );
                            startActivity(intent);
                        }

                        Toast.makeText(applicationContext, "Error al intentar compilar.", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(applicationContext, "Sintaxis invalida en el apartado de ejecución.", Toast.LENGTH_LONG).show();
                }

            } catch (e: java.lang.Exception){
                System.err.println("ALGO SALIO MAL :C");
                System.err.println(e.message)
            }
        }
    }

}