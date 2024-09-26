package cl.ucn.modelo;

public class RecursosMultimedia {

    private String nombre;
    private String tipo;

    public void cargar() {
        // Simula la carga de un archivo grande en memoria
        System.out.println("Cargando el archivo: " + nombre + " (" + tipo + ")");
    }

    public void mostrar() {
        System.out.println("Mostrando el archivo: " + nombre + " (" + tipo + ")");
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

}
