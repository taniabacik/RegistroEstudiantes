package modelo;

public class Estudiantes {
    private String nombre;
    private String apellido;
    private String correo;
    private String codigo;
    private String carrera;
    private int avatarResId; // Imagen del avatar

    public Estudiantes(String nombre, String apellido, String correo, String codigo, String carrera, int avatarResId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.codigo = codigo;
        this.carrera = carrera;
        this.avatarResId = avatarResId;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getCodigo() { return codigo; }
    public String getCarrera() { return carrera; }
    public int getAvatarResId() { return avatarResId; }
}

