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
            System.out.println("1 Registrar libro");
            System.out.println("2 Listar libros");
            System.out.println("3 Buscar libro");
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
            }

        } while (opcion != 0);
    }

}
