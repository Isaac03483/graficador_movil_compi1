package com.example.graficador;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.models.Envoltura;
import com.example.reportes.ReporteSigno;

import java.util.List;

public class OperadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operador);


        Envoltura envoltura = (Envoltura) getIntent().getSerializableExtra("listaOperador");

        TextView textoOperador = findViewById(R.id.textoOperador);
        TextView textoFila = findViewById(R.id.textoFila);
        TextView textoColumna = findViewById(R.id.textoColumna);

        for(Object signo: envoltura.getLista()){
            textoOperador.append(((ReporteSigno)signo).getOperador()+"\n");
            textoFila.append(((ReporteSigno)signo).getFila()+"\n");
            textoColumna.append(((ReporteSigno)signo).getColumna()+"\n");
        }
    }
}