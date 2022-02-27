package com.example.graficador;

import android.os.Build;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.models.Barra;
import com.example.models.Grafica;
import com.example.models.Graficador;
import com.example.models.Tupla;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraficasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);

        Graficador graficador = (Graficador) getIntent().getSerializableExtra("valor");


        LinearLayout layout = findViewById(R.id.content);

        BarChart barChart = findViewById(R.id.barras);
        for(Grafica grafica: graficador.getGraficas()){

            if(grafica instanceof Barra){
                List<BarEntry> tuplas = new ArrayList<>();
                for(Tupla tupla: grafica.getListaTupla()){
                    tuplas.add(new BarEntry(((Barra) grafica).getEjeY().get(tupla.getValorR()).floatValue(),((Barra) grafica).getEjeY().get(tupla.getValorR()).floatValue()));
                }

                BarDataSet barDataSet = new BarDataSet(tuplas, grafica.getTitulo());
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

                barChart.setFitBars(true);
                barChart.setData(new BarData(barDataSet));
            } else {

            }
        }





    }
}