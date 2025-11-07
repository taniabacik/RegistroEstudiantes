package ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.registroestudiantes.R;

public class MainActivity extends AppCompatActivity {

    private Button btnComenzar;
    private ImageView logo;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logoInstituto);
        titulo = findViewById(R.id.tvTitulo);
        btnComenzar = findViewById(R.id.btnIngresar);

        btnComenzar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}

