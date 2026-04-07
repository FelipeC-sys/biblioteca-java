import java.util.ArrayList;
import java.time.Year;

public class SistemaBiblioteca {

    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void registrarLibro(Libro libro) {

        if (libro.isbn.isEmpty() || libro.titulo.isEmpty() || libro.autor.isEmpty()) {
            System.out.println("Error: campos vacíos");
            return;
        }

        for (Libro l : libros) {
            if (l.isbn.equals(libro.isbn)) {
                System.out.println("Error: ISBN repetido");
                return;
            }
        }

        int anioActual = Year.now().getValue();
        if (libro.anio > anioActual) {
            System.out.println("Error: año inválido");
            return;
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

    public void eliminarLibro(String isbn) {

        Libro libro = buscarLibro(isbn);

        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado");
        } else {
            System.out.println("Libro no encontrado");
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