package com.miapp.biblioteca;
import java.util.ArrayList;
public class Usuario {
	private String nombre;
    private String numeroIdentificacion;
    private ArrayList<Libro> listaLibrosPrestados;

    // Constructor
    public Usuario(String nombre, String numeroIdentificacion) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.listaLibrosPrestados = new ArrayList<>();
    }

    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el número de identificación
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    // Getter para el número de identificación
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    // Setter para la lista de libros prestados
    public void setListaLibrosPrestados(ArrayList<Libro> listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    // Getter para la lista de libros prestados
    public ArrayList<Libro> getListaLibrosPrestados() {
        return listaLibrosPrestados;
    }

    // Método para agregar un libro prestado a la lista
    public void agregarLibroPrestado(Libro libro) {
        listaLibrosPrestados.add(libro);
    }
    public void devolverLibroPrestado(Libro libro) {
        listaLibrosPrestados.remove(libro);
    }

    // Método toString para imprimir información del usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", listaLibrosPrestados=" + listaLibrosPrestados +
                '}';
    }
}
