package adapter;

import com.example.registroestudiantes.R;
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import modelo.Estudiantes;
import java.util.List;

public class EstudiantesAdapter extends RecyclerView.Adapter<EstudiantesAdapter.ViewHolder> {
    private List<Estudiantes> lista;

    public EstudiantesAdapter(List<Estudiantes> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Estudiantes e = lista.get(position);
        holder.nombre.setText(e.getNombre() + " " + e.getApellido());
        holder.carrera.setText(e.getCarrera());
        holder.avatar.setImageResource(e.getAvatarResId());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView nombre, carrera;
        public ViewHolder(View v) {
            super(v);
            avatar = v.findViewById(R.id.ivAvatar);
            nombre = v.findViewById(R.id.tvNombre);
            carrera = v.findViewById(R.id.tvCarrera);
        }
    }
}

