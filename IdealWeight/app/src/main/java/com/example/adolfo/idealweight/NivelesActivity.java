package com.example.adolfo.idealweight;

/**
 * Created by Adolfo on 22/09/2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;




public class NivelesActivity extends AppCompatActivity {

    //Crear las variables de los objetos que vamos a utilizar
    ListView mListV;

    String[] NamesNiveles = {
            "Fácil",
            "Moderado",
            "Desafiante",
            "Extremo",
    };

    String[] description = new String[]{
            "Consigue llegar a tu peso y calorías ideales de manera lenta",
            "Consigue llegar a tu peso y calorías ideales de manera fácil, segura y eficiente",
            "Muevete y Pierdelo! Este agresivo plan puede ayudarte a perder hasta 1.5 lbs por semana",
            "Consigue llegar a tu peso y calorías ideales rapidamente con este plan 100% efectivo",
    };

    int[] imagenes = {
            R.drawable.d7,
            R.drawable.d8,
            R.drawable.d9,
            R.drawable.d10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niveles_main);

        mListV = (ListView) findViewById(R.id.list_v);
        MyAdapter myAdapter = new MyAdapter(NivelesActivity.this, NamesNiveles, description, imagenes);
        mListV.setAdapter(myAdapter);
        mListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent mIntent = new Intent(NivelesActivity.this, ListContenido.class);
                startActivity(mIntent);
            }
        });
    }

}
