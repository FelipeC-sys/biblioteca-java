public class Libro {

    String isbn;
    String titulo;
    String autor;
    int anio;
    boolean disponible;

    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = true;
    }

    public void mostrar() {
        System.out.println(isbn + " - " + titulo + " - " + autor + " - " + anio + " - " + (disponible ? "Disponible" : "Prestado"));
    }
}