import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (!Auth.login()) {

            System.out.println("Acceso denegado");
            return;
        }

        SistemaBiblioteca sistema = new SistemaBiblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n|...... SISTEMA BIBLIOTECA ......|");
            System.out.println("\n1 Registrar libro");
            System.out.println("2 Listar libros");
            System.out.println("3 Buscar libro");
            System.out.println("4 Registrar usuario");
            System.out.println("5 Listar usuarios");
            System.out.println("6 Buscar usuario");
            System.out.println("7 Eliminar usuario");
            System.out.println("8 Registrar préstamo");
            System.out.println("9 Devolver libro");
            System.out.println("10 Ver préstamos");
            System.out.println("0 Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Año: ");
                    int anio = sc.nextInt();

                    Libro libro = new Libro(isbn, titulo, autor, anio);

                    sistema.registrarLibro(libro);

                    break;

                case 2:

                    sistema.listarLibros();

                    break;

                case 3:

                    System.out.print("ISBN: ");
                    String buscar = sc.nextLine();

                    Libro l = sistema.buscarLibro(buscar);

                    if (l != null) {
                        l.mostrar();
                    } else {
                        System.out.println("Libro no encontrado");
                    }

                    break;
                case 4:

                    System.out.print("Documento: ");
                    String doc = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo (Administrador/Bibliotecario/Lector): ");
                    String tipo = sc.nextLine();

                    Usuario usuario = new Usuario(doc, nombre, tipo);
                    sistema.registrarUsuario(usuario);

                    break;

                case 5:

                    sistema.listarUsuarios();

                    break;

                case 6:

                    System.out.print("Documento: ");
                    String buscarDoc = sc.nextLine();

                    Usuario u = sistema.buscarUsuario(buscarDoc);

                    if (u != null) {
                        u.mostrar();
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;

                case 7:

                    System.out.print("Documento: ");
                    String eliminar = sc.nextLine();

                    sistema.eliminarUsuario(eliminar);

                    break;
                case 8:

                    System.out.print("ISBN del libro: ");
                    String isbnPrestamo = sc.nextLine();

                    System.out.print("Documento del usuario: ");
                    String docPrestamo = sc.nextLine();

                    sistema.registrarPrestamo(isbnPrestamo, docPrestamo);

                    break;

                case 9:

                    System.out.print("ISBN del libro: ");
                    String isbnDev = sc.nextLine();

                    sistema.devolverLibro(isbnDev);

                    break;

                case 10:

                    sistema.listarPrestamos();

                    break;
            }

        } while (opcion != 0);
    }

}