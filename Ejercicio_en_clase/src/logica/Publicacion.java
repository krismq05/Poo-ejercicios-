package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Publicacion {
    private static int consecutivo = 1;
    private int codigo;
    private String titulo;
    private String texto;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private ArrayList<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        codigo = consecutivo;
        consecutivo++;
        this.titulo = titulo;
        this.texto = texto;
        this.nombreCreador = nombreCreador;
        fechaPublicacion = LocalDateTime.now();
        comentarios = new ArrayList<Comentario>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void agregarComentario(String email, String ip, String texto) {
        Comentario c = new Comentario(email, ip, texto);
        comentarios.add(c);
    }

    public void borrarComentario(int posicion) throws Exception {
        if (posicion < 0 || posicion >= comentarios.size()) {
            throw new Exception("Comentario no valido.");
        }
        comentarios.remove(posicion);
    }

    public String toString() {
        String resultado = titulo + "\n\n";
        resultado += "Creado por: " + nombreCreador + "\n";
        resultado += fechaPublicacion.toString() + "\n\n";
        resultado += texto + "\n\n";
        resultado += "Comentarios:\n";

        if (comentarios.isEmpty()) {
            resultado += "No hay comentarios.";
        } else {
            for (Comentario c : comentarios) {
                resultado += c.toString() + "\n";
            }
        }

        return resultado;
    }
}