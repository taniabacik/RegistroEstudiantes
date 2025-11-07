package ui;

import com.example.registroestudiantes.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import adapter.EstudiantesAdapter;
import modelo.Estudiantes;
import java.util.*;

public class List extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnVolver;
    ArrayList<Estudiantes> listaEstudiantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        btnVolver = findViewById(R.id.btnVolver);

        cargarDatos();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EstudiantesAdapter(listaEstudiantes));

        btnVolver.setOnClickListener(v -> finish());
    }

    private void cargarDatos() {
        SharedPreferences prefs = getSharedPreferences("estudiantes", MODE_PRIVATE);
        String data = prefs.getString("ultimoEstudiante", null);
        if (data != null) {
            String[] partes = data.split(",");
            listaEstudiantes.add(new Estudiantes(partes[0], partes[1], partes[2], partes[3], partes[4], Integer.parseInt(partes[5])));
        }
    }
}
