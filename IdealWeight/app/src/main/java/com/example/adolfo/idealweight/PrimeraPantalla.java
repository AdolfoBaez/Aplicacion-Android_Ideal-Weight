package com.example.adolfo.idealweight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrimeraPantalla extends AppCompatActivity {
    //Crear las variables de los objetos que vamos a utilizar
    Button boton;
    TextView textoE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);

        //Login datos
        final EditText etUser = (EditText) findViewById(R.id.usuario);
        final EditText etContra = (EditText) findViewById(R.id.Contraseña);

        //Referencia a los elementos
        boton = (Button) findViewById(R.id.boton1);
        textoE = (TextView) findViewById(R.id.TextRegister);

        //Agregar su listener(Escuchador)
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla1 = new Intent(PrimeraPantalla.this,ActionPantalla.class);
                startActivity(pantalla1);
                //finish();
            }
        });

        textoE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla1 = new Intent(PrimeraPantalla.this,registro.class);
                startActivity(pantalla1);
                //finish();
            }
        });
    }
}
