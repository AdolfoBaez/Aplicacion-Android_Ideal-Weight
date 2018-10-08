package com.example.adolfo.idealweight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;

public class AlimentosDesayunoN1 extends AppCompatActivity {

    //Crear las variables de los objetos que vamos a utilizar
    ListView dListV;

    String[] AlimentosDesayuno = {
            "Cereal con leche",
            "Yogurt natural",
            "Café con leche entera",
            "Huevos",
    };

    String[] description = new String[]{
            "Calorías: 180 kcal",
            "Calorías: 65 kcal",
            "Calorías: 110 cal",
            "Calorías: 78 cal (1 huevo)",
    };

    int[] imagenes = {
            R.drawable.d1n1,
            R.drawable.d2n1,
            R.drawable.d4n1,
            R.drawable.d13n1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alimentos_desayuno_n1);

        dListV = (ListView) findViewById(R.id.list_d1);
        AdapterDesayuno1 adapterDesayuno1 = new AdapterDesayuno1(AlimentosDesayunoN1.this, AlimentosDesayuno, description, imagenes);
        dListV.setAdapter(adapterDesayuno1);
        dListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent mIntent = new Intent(AlimentosDesayunoN1.this, ContenidoAlimentos.class);
                mIntent.putExtra("Nombre del Alimento", AlimentosDesayuno[i]);
                mIntent.putExtra("Descripción del Alimento", description[i]);
                mIntent.putExtra("Imagen del Alimento", imagenes[i]);
                startActivity(mIntent);
            }
        });
    }
}
