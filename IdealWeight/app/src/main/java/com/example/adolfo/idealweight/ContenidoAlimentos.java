package com.example.adolfo.idealweight;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class ContenidoAlimentos extends AppCompatActivity {

    ImageView mImageView;
    TextView mTextView;
    TextView dTextView;
    Button cButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_alimentos);

        mImageView = (ImageView) findViewById(R.id.ImgAlimento);
        mTextView = (TextView) findViewById(R.id.NameDesayuno1);
        dTextView = (TextView) findViewById(R.id.DescDesayuno1);
        cButton = (Button) findViewById(R.id.Bconsumir);

        //Agregar su listener(Escuchador)
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla1 = new Intent(ContenidoAlimentos.this,ActionPantalla.class);
                startActivity(pantalla1);
                //finish();
            }
        });

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mImageView.setImageResource(mBundle.getInt("Imagen del Alimento"));
            mTextView.setText(mBundle.getString("Nombre del Alimento"));
            dTextView.setText(mBundle.getString("Descripción del Alimento"));
        }

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
            final AlertDialog.Builder builder= new AlertDialog.Builder(ContenidoAlimentos.this);
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
            final AlertDialog.Builder builder= new AlertDialog.Builder(ContenidoAlimentos.this);
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
