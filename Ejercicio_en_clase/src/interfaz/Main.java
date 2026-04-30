package interfaz;


import java.util.Map;
import java.util.Scanner;
import control.Control;

public class Main {

    public static void main(String[] args) {

        Control control = new Control();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
        	System.out.println("\n╔══════════════════════════════╗");
        	System.out.println("║      SISTEMA DE BLOGS        ║");
        	System.out.println("╠══════════════════════════════╣");
        	System.out.println("║ 1. Crear blog                ║");
        	System.out.println("║ 2. Ver blogs                 ║");
        	System.out.println("║ 3. Crear publicación         ║");
        	System.out.println("║ 4. Listar publicaciones      ║");
        	System.out.println("║ 5. Ver detalle publicación   ║");
        	System.out.println("║ 6. Agregar comentario        ║");
        	System.out.println("║ 7. Borrar comentario         ║");
        	System.out.println("║ 0. Salir                     ║");
        	System.out.println("╚══════════════════════════════╝");
        	System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripcion: ");
                    String desc = sc.nextLine();

                    control.crearBlog(nombre, desc);
                    System.out.println("Blog creado.");
                    break;

                case 2:
                    Map<Integer, String> blogs = control.obtenerBlogs();
                    System.out.println(blogs);
                    break;

                case 3:
                    System.out.print("Codigo Blog: ");
                    int codBlog = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Texto: ");
                    String texto = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.println(control.crearPublicacion(codBlog, titulo, texto, autor));
                    break;

                case 4:
                    System.out.print("Codigo Blog: ");
                    codBlog = sc.nextInt();

                    Map<Integer, String> pubs = control.obtenerPublicaciones(codBlog);
                    System.out.println(pubs);
                    break;

                case 5:
                    System.out.print("Codigo Blog: ");
                    codBlog = sc.nextInt();

                    System.out.print("Codigo Publicacion: ");
                    int codPub = sc.nextInt();

                    System.out.println(control.obtenerPublicacion(codBlog, codPub));
                    break;

                case 6:
                    System.out.print("Codigo Blog: ");
                    codBlog = sc.nextInt();

                    System.out.print("Codigo Publicacion: ");
                    codPub = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("IP: ");
                    String ip = sc.nextLine();

                    System.out.print("Comentario: ");
                    String comentario = sc.nextLine();

                    System.out.println(control.agregarComentario(codBlog, codPub, email, ip, comentario));
                    break;

                case 7:
                    System.out.print("Codigo Blog: ");
                    codBlog = sc.nextInt();

                    System.out.print("Codigo Publicacion: ");
                    codPub = sc.nextInt();

                    System.out.print("Posicion comentario: ");
                    int pos = sc.nextInt();

                    System.out.println(control.borrarComentario(codBlog, codPub, pos));
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }
}
