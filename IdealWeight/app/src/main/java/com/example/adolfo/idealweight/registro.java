package com.example.adolfo.idealweight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registro extends AppCompatActivity {
    Button boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText etName = (EditText) findViewById(R.id.Name);
        final EditText etUser = (EditText) findViewById(R.id.User);
        final EditText etContra = (EditText) findViewById(R.id.Contra);
        final EditText etAge = (EditText) findViewById(R.id.Age);
        final EditText etEstatura = (EditText) findViewById(R.id.Estatura);
        final EditText etPeso = (EditText) findViewById(R.id.Peso);

        boton2 = (Button)findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla1 = new Intent(registro.this,ActionPantalla.class);
                startActivity(pantalla1);
                //finish();
            }
        });
    }
}
