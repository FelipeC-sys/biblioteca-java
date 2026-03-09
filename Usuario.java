public class Usuario {

    String documento;
    String nombre;
    String tipo;

    public Usuario(String documento, String nombre, String tipo) {
        this.documento = documento;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void mostrar() {
        System.out.println(documento + " - " + nombre + " - " + tipo);
    }
}