package utils;

import android.content.Context;
import android.content.SharedPreferences;

import modelo.Estudiantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefsHelper {

    private SharedPreferences prefs;
    private Gson gson;

    public PrefsHelper(Context context) {
        prefs = context.getSharedPreferences("estudiantes_prefs", Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void addStudent(Estudiantes estudiante) {
        ArrayList<Estudiantes> lista = getStudents();
        lista.add(estudiante);
        saveStudents(lista);
    }

    public void saveStudents(ArrayList<Estudiantes> lista) {
        String json = gson.toJson(lista);
        prefs.edit().putString("students", json).apply();
    }

    public ArrayList<Estudiantes> getStudents() {
        String json = prefs.getString("students", "");
        Type type = new TypeToken<ArrayList<Estudiantes>>(){}.getType();
        ArrayList<Estudiantes> lista = gson.fromJson(json, type);
        return lista == null ? new ArrayList<>() : lista;
    }
}
