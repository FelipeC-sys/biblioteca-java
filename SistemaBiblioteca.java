import java.util.ArrayList;

public class SistemaBiblioteca {

    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void registrarLibro(Libro libro) {

        for (Libro l : libros) {
            if (l.isbn.equals(libro.isbn)) {
                System.out.println("Error: ISBN ya existe");
                return;
            }
        }

        libros.add(libro);
        System.out.println("Libro registrado correctamente");
    }

    public void listarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }

        for (Libro l : libros) {
            l.mostrar();
        }
    }

    public Libro buscarLibro(String isbn) {

        for (Libro l : libros) {
            if (l.isbn.equals(isbn)) {
                return l;
            }
        }

        return null;
    }
}