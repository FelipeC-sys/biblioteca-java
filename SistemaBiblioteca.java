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

    public void actualizarDisponibilidad(String isbn, boolean estado) {

        Libro libro = buscarLibro(isbn);

        if (libro != null) {
            libro.disponible = estado;
            System.out.println("Estado actualizado");
        } else {
            System.out.println("Libro no encontrado");
        }
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

    public void registrarUsuario(Usuario usuario) {

        for (Usuario u : usuarios) {
            if (u.documento.equals(usuario.documento)) {
                System.out.println("Documento ya existe");
                return;
            }
        }

        usuarios.add(usuario);
        System.out.println("Usuario registrado");
    }

    public void listarUsuarios() {

        for (Usuario u : usuarios) {
            u.mostrar();
        }
    }

    public Usuario buscarUsuario(String doc) {

        for (Usuario u : usuarios) {
            if (u.documento.equals(doc)) {
                return u;
            }
        }

        return null;
    }

    public void eliminarUsuario(String doc) {

        Usuario u = buscarUsuario(doc);

        if (u != null) {
            usuarios.remove(u);
            System.out.println("Usuario eliminado");
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

    public void devolverLibro(String isbn) {

        for (Prestamo p : prestamos) {

            if (p.isbnLibro.equals(isbn)) {

                prestamos.remove(p);

                Libro libro = buscarLibro(isbn);
                if (libro != null) {
                    libro.disponible = true;
                }

                System.out.println("Libro devuelto");
                return;
            }
        }

        System.out.println("Préstamo no encontrado");
    }

    public void listarPrestamos() {

        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos activos");
            return;
        }

        for (Prestamo p : prestamos) {
            System.out.println("Libro: " + p.isbnLibro + " Usuario: " + p.documentoUsuario);
        }
    }

    public void registrarPrestamo(String isbn, String documento) {

        Libro libro = buscarLibro(isbn);
        Usuario usuario = buscarUsuario(documento);

        if (libro == null) {
            System.out.println("Libro no existe");
            return;
        }

        if (usuario == null) {
            System.out.println("Usuario no existe");
            return;
        }

        if (!(usuario.tipo.equals("Administrador") || usuario.tipo.equals("Bibliotecario"))) {
            System.out.println("No tiene permisos para prestar");
            return;
        }

        if (!libro.disponible) {
            System.out.println("Libro no disponible");
            return;
        }

        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.documentoUsuario.equals(documento)) {
                contador++;
            }
        }

        if (contador >= 3) {
            System.out.println("Límite de préstamos alcanzado");
            return;
        }

        prestamos.add(new Prestamo(isbn, documento));
        libro.disponible = false;

        System.out.println("Préstamo registrado");
    }
}