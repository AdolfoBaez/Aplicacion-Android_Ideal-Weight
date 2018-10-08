package com.example.adolfo.idealweight;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class ActionPantalla extends AppCompatActivity {
    //Crear las variables de los objetos que vamos a utilizar
    private ImageButton ib;



    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_pantalla);

        ib = (ImageButton) findViewById(R.id.imagenBtn);


        //Para el calendario
        TextView yLabel = (TextView) findViewById(R.id.yLabel);
        TextView mLabel = (TextView) findViewById(R.id.mLabel);
        TextView dLabel = (TextView) findViewById(R.id.dLabel);

        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int día = today.monthDay;
        int mes = today.month;
        int año = today.year;
        mes = mes+1;

        dLabel.setText(" " + día);
        mLabel.setText("Mes: " + mes);
        yLabel.setText(" " + año);

        //Agregar su listener(Escuchador)
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla1 = new Intent(ActionPantalla.this,NivelesActivity.class);
                startActivity(pantalla1);
                //finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.actCalculadora)
        {
            Toast.makeText(this, "La Calculadora fue seleccionada", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Calculadora.class));

        }

        else if(id==R.id.actCerrar)
        {
            //Toast.makeText(this, "Está cerrando sesión", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(this, Calculadora.class));
            final AlertDialog.Builder builder= new AlertDialog.Builder(ActionPantalla.this);
            builder.setMessage("¿Deseas Cerrar Sesión?");
            // builder.setTitle("Ideal Weight");
            builder.setCancelable(true);
            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }

        else if(id==R.id.actSalir)
        {
           /* Toast.makeText(this, "Está saliendo de la aplicación", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Calculadora.class)); */
            final AlertDialog.Builder builder= new AlertDialog.Builder(ActionPantalla.this);
            builder.setMessage("¿Desea salir de la Aplicación?");
            // builder.setTitle("Ideal Weight");
            builder.setCancelable(true);
            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        }

        return super.onOptionsItemSelected(item);
    }
}
