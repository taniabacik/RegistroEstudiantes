package ui;

import com.example.registroestudiantes.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import adapter.EstudiantesAdapter;
import modelo.Estudiantes;
import utils.PrefsHelper;

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

        cargarDatosCorrectamente();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EstudiantesAdapter(listaEstudiantes));

        btnVolver.setOnClickListener(v -> finish());
    }

    private void cargarDatosCorrectamente() {
        PrefsHelper prefsHelper = new PrefsHelper(this);
        listaEstudiantes = prefsHelper.getStudents();
    }
}
