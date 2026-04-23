package logica;

public class Main {
    public static void main(String[] args) {
        Blog blog = new Blog("Mi Blog", "Ejemplo de blog");

        blog.agregarPublicacion("Primer post", "Hola mundo", "Dilan");
        blog.agregarPublicacion("Segundo post", "Otro contenido", "Kristel");

        Publicacion p = blog.buscarPublicacion(1);

        if (p != null) {
            p.agregarComentario("correo@test.com", "192.168.1.1", "Buen post");
            p.agregarComentario("otro@test.com", "192.168.1.2", "Me gusto");
        }

        System.out.println(blog.toString());
    }
}