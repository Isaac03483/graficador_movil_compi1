package com.example.graficador;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.error.ErrorObj;
import com.example.models.Envoltura;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        TextView textoReporte = findViewById(R.id.errorInfo);
        Envoltura envoltura = (Envoltura) getIntent().getSerializableExtra("errorLexico");

        for(Object errorObj: envoltura.getLista()){
            textoReporte.append("\t\t"+((ErrorObj)errorObj).getLexema()+"\t\t\t\t\t"+((ErrorObj)errorObj).getFila()+"\t\t\t\t"+((ErrorObj)errorObj).getColumna()+"\t\t\t\t"
            +((ErrorObj)errorObj).getErrorType().getType()+"\t\t\t\t"+((ErrorObj)errorObj).getMessage()+"\n");
        }

        envoltura = (Envoltura) getIntent().getSerializableExtra("errorSintactico");
        for(Object errorObj: envoltura.getLista()){
            textoReporte.append("\t\t"+((ErrorObj)errorObj).getLexema()+"\t\t\t\t\t"+((ErrorObj)errorObj).getFila()+"\t\t\t\t"+((ErrorObj)errorObj).getColumna()+"\t\t\t\t"
            +((ErrorObj)errorObj).getErrorType().getType()+"\t\t\t\t"+((ErrorObj)errorObj).getMessage()+"\n");
        }
    }
}