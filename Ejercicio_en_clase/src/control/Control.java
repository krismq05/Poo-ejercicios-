package control;

import java.util.HashMap;
import java.util.Map;
import logica.Blog;

public class Control {

    private Map<Integer, Blog> blogs;

    public Control() {
        blogs = new HashMap<>();
    }

    public void crearBlog(String nombre, String descripcion) {
        Blog blog = new Blog(nombre, descripcion);
        blogs.put(blog.getCodigo(), blog);
    }

    public String borrarBlog(int codigoBlog) {
        if (!blogs.containsKey(codigoBlog)) {
            return "No existe el blog.";
        }

        blogs.remove(codigoBlog);
        return "Blog eliminado.";
    }

    public Map<Integer, String> obtenerBlogs() {
        Map<Integer, String> resultado = new HashMap<>();

        for (Blog b : blogs.values()) {
            resultado.put(b.getCodigo(), b.getNombre());
        }

        return resultado;
    }

    public String crearPublicacion(int codigoBlog, String titulo, String texto, String nombreCreador) {
        Blog b = blogs.get(codigoBlog);

        if (b == null) {
            return "No existe el blog.";
        }

        b.agregarPublicacion(titulo, texto, nombreCreador);
        return "Publicación creada.";
    }

    public Map<Integer, String> obtenerPublicaciones(int codigoBlog) {
        Blog b = blogs.get(codigoBlog);

        if (b == null) {
            return new HashMap<>();
        }

        return b.obtenerTitulosPublicaciones();
    }

    public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) {
        Blog b = blogs.get(codigoBlog);

        if (b == null) {
            return "No existe el blog.";
        }

        return b.obtenerPublicacionEnString(codigoPublicacion);
    }

    public String agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) {
        Blog b = blogs.get(codigoBlog);

        if (b == null) {
            return "No existe el blog.";
        }

        return b.agregarComentario(codigoPublicacion, email, ip, texto);
    }

    public String borrarComentario(int codigoBlog, int codigoPublicacion, int posicion) {
        Blog b = blogs.get(codigoBlog);

        if (b == null) {
            return "No existe el blog.";
        }

        return b.borrarComentario(codigoPublicacion, posicion);
    }
}