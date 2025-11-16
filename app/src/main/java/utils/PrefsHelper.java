package utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Estudiantes;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefsHelper {

    private final SharedPreferences prefs;
    private final Gson gson;

    public PrefsHelper(Context context) {
        prefs = context.getSharedPreferences("estudiantes_prefs", Context.MODE_PRIVATE);
        gson = new Gson();
    }

    // Agrega
    public void addStudent(Estudiantes estudiante) {
        ArrayList<Estudiantes> lista = getStudents();
        lista.add(estudiante);
        saveStudents(lista);
    }

    // Guarda toda la lista
    public void saveStudents(ArrayList<Estudiantes> lista) {
        String json = gson.toJson(lista);
        prefs.edit().putString("students", json).apply();
    }

    // imprime la lista completa
    public ArrayList<Estudiantes> getStudents() {
        String json = prefs.getString("students", "");
        Type type = new TypeToken<ArrayList<Estudiantes>>() {}.getType();
        ArrayList<Estudiantes> lista = gson.fromJson(json, type);
        return lista != null ? lista : new ArrayList<>();
    }
}
