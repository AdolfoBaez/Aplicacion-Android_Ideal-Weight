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

public class ListContenido extends AppCompatActivity {
    //ImageView mImageView;

    //Crear las variables de los objetos que vamos a utilizar
    ListView mListC;

    String[] TipoAlimento = {
            "Desayuno",
            "Almuerzo",
            "Comida",
            "Cena",
    };


    int[] imagenes = {
            R.drawable.desayuno3,
            R.drawable.almuerzo2,
            R.drawable.almuerzo,
            R.drawable.comida
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_contenido);

       /* mImageView = (ImageView)findViewById(R.id.imagenD);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mImageView.setImageResource(mBundle.getInt("Imagen del Nivel")); */

        mListC = (ListView) findViewById(R.id.list_c);
        ContenidoAdapter contenidoAdapter = new  ContenidoAdapter(ListContenido.this, TipoAlimento, imagenes);
        mListC.setAdapter(contenidoAdapter);
        mListC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent nIntent = new Intent(ListContenido.this, AlimentosDesayunoN1.class);
                startActivity(nIntent);
            }
        });

    }
}
