package ui;

import com.example.registroestudiantes.R;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import modelo.Estudiantes;
import utils.PrefsHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etCorreo, etCodigo;
    Spinner spCarrera, spAvatar;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCorreo = findViewById(R.id.etCorreo);
        etCodigo = findViewById(R.id.etCodigo);
        spCarrera = findViewById(R.id.spCarrera);
        spAvatar = findViewById(R.id.spAvatar);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Opciones de carreras
        String[] carreras = {
                "Desarrollador de Software",
                "Administrador de Empresas",
                "Técnico Ambientalista",
                "Economista Social",
                "Administrativo Municipal"
        };
        spCarrera.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, carreras));

        // Opciones de avatares
        String[] avatares = {
                "Desarrollador",
                "Administrador",
                "Ambientalista",
                "Economista",
                "Municipal"
        };
        spAvatar.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, avatares));

        btnGuardar.setOnClickListener(v -> {

            String nombre = etNombre.getText().toString();
            String apellido = etApellido.getText().toString();
            String correo = etCorreo.getText().toString();
            String codigo = etCodigo.getText().toString();
            String carrera = spCarrera.getSelectedItem().toString();
            int avatarRes = obtenerAvatar(spAvatar.getSelectedItem().toString());

            Estudiantes estudiante =
                    new Estudiantes(nombre, apellido, correo, codigo, carrera, avatarRes);


            PrefsHelper prefsHelper = new PrefsHelper(this);
            prefsHelper.addStudent(estudiante);


            Intent intent = new Intent(RegisterActivity.this, List.class);
            startActivity(intent);
        });
    }

    private int obtenerAvatar(String tipo) {
        switch (tipo) {
            case "Administrador": return R.drawable.avatar_administrador;
            case "Ambientalista": return R.drawable.avatar_ambientalista;
            case "Economista": return R.drawable.avatar_economista;
            case "Municipal": return R.drawable.avatar_municipal;
            default: return R.drawable.avatar_desarrollador;
        }
    }
}
