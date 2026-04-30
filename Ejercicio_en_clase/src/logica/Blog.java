package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List; // ✔ agregado

public class Blog {
    private static int consecutivo = 1;
    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    private List<Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
        codigo = consecutivo;
        consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        fechaCreacion = LocalDateTime.now();

        publicaciones = new ArrayList<>();
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

    public String agregarComentario(int codPublicacion, String email, String texto) {
        Publicacion p = buscarPublicacion(codPublicacion);

        if (p == null) {
            return "No existe la publicación.";
        }

        p.agregarComentario(email,"0.0.0.0", texto);
        return "Comentario agregado.";
    }

    public String borrarComentario(int codPublicacion, int posicion) {
        Publicacion p = buscarPublicacion(codPublicacion);

        if (p == null) {
            return "No existe la publicación.";
        }

        return p.borrarComentario(posicion);
    }

    public Map<Integer, String> obtenerTitulosPublicaciones() {
        Map<Integer, String> titulos = new HashMap<>();

        for (Publicacion p : publicaciones) {
            titulos.put(p.getCodigo(), p.getTitulo());
        }

        return titulos;
    }

    public String obtenerPublicacionEnString(int codigoPublicacion) {
        Publicacion p = buscarPublicacion(codigoPublicacion);

        if (p == null) {
            return "No existe la publicación.";
        }

        return p.toString();
    }

    @Override
    public String toString() {
        String res = "BLOG: " + nombre + "\n";
        res += descripcion + "\n";
        res += "Fecha: " + fechaCreacion + "\n\n";

        for (Publicacion p : publicaciones) {
            res += p.toString() + "\n\n";
        }

        return res;
    }
}