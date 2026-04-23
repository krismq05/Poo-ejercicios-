package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Blog {
    private static int consecutivo = 1;
    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private ArrayList<Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
        codigo = consecutivo;
        consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        fechaCreacion = LocalDateTime.now();
        publicaciones = new ArrayList<Publicacion>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void agregarPublicacion(String titulo, String texto, String creador) {
        Publicacion p = new Publicacion(titulo, texto, creador);
        publicaciones.add(p);
    }

    public Publicacion buscarPublicacion(int codigo) {
        for (Publicacion p : publicaciones) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public String toString() {
        String res = "BLOG: " + nombre + "\n";
        res += descripcion + "\n\n";

        for (Publicacion p : publicaciones) {
            res += p.toString() + "\n\n";
        }

        return res;
    }
}
