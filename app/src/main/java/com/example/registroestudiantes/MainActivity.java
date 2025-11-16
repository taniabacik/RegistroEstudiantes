package com.example.registroestudiantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ui.List;
import ui.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar, btnVerLista;
    private ImageView logo;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias UI
        logo = findViewById(R.id.logoInstituto);
        titulo = findViewById(R.id.tvTitulo);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnVerLista = findViewById(R.id.btnVerLista);

        // Botón: Ir al registro de alumnos
        btnIngresar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Botón: Ver lista de alumnos inscriptos
        btnVerLista.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, List.class);
            startActivity(intent);
        });
    }
}
