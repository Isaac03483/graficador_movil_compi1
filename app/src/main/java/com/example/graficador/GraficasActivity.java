package com.example.graficador;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.models.*;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.List;

public class GraficasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);

        Graficador graficador = (Graficador) getIntent().getSerializableExtra("valor");

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        for(Grafica grafica: graficador.getGraficas()){

            if(grafica instanceof Barra){
                BarChart barChart = new BarChart(this);
                List<BarEntry> tuplas = new ArrayList<>();

                List<LegendEntry> legends = new ArrayList<>();
                for(int i = 0; i < grafica.getListaTupla().size(); i++){
                    tuplas.add(new BarEntry(Float.parseFloat(String.valueOf(i)),((Barra) grafica).getEjeY().get(grafica.getListaTupla().get(i).getValorR()).floatValue()));
                    LegendEntry temp = new LegendEntry();
                    temp.label = ((Barra) grafica).getEjeX().get(grafica.getListaTupla().get(i).getValorL());
                    legends.add(temp);
                }

                BarDataSet barDataSet = new BarDataSet(tuplas, "");
                barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

                Legend legend = barChart.getLegend();
                legend.setTextSize(20);
                legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
                legend.setCustom(legends);
                barChart.setFitBars(true);
                barChart.getDescription().setText(grafica.getTitulo());
                barChart.setData(new BarData(barDataSet));

                linearLayout.addView(barChart);
                barChart.getLayoutParams().height = 600;
                barChart.getLayoutParams().width = 800;
            } else {

                PieChart pieChart = new PieChart(this);
                List<PieEntry> tuplas = new ArrayList<>();

                for(int i = 0; i < grafica.getListaTupla().size(); i++){
                    tuplas.add(new PieEntry(((Pie) grafica).getValores().get(grafica.getListaTupla().get(i).getValorL()).floatValue(),((Pie) grafica).getEtiquetas().get(grafica.getListaTupla().get(i).getValorR())));
                }

                PieDataSet pieDataSet = new PieDataSet(tuplas, "");
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieChart.setData(new PieData(pieDataSet));
                pieChart.getDescription().setText(grafica.getTitulo());
                pieChart.animate();

                linearLayout.addView(pieChart);
                pieChart.getLayoutParams().height = 600;
                pieChart.getLayoutParams().width = 600;
            }
        }





    }
}