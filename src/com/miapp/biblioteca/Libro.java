package com.miapp.biblioteca;

public class Libro {
	private String titulo;
	private String autor;
	private String ISBN;
	private String genero;
	private boolean disponible;
	
	//Constructor y Constructor vacío
	public Libro(String titulo, String autor, String ISBN, String genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.genero = genero;
		this.disponible = true;
		
	}
	public Libro() {
		
	}
	
	//Getters & Setters
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setISBN(String isbn) {
		this.ISBN = isbn;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setDisponible(boolean disp) {
		this.disponible = disp;
	}
	public String getTitulo() {
        return titulo;
    }

    // Getter para el autor
    public String getAutor() {
        return autor;
    }

    // Getter para el ISBN
    public String getISBN() {
        return ISBN;
    }

    // Getter para el género
    public String getGenero() {
        return genero;
    }

    // Getter para la disponibilidad
    public boolean isDisponible() {
        return disponible;
    }
    
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genero='" + genero + '\'' +
                ", disponible=" + disponible +
                '}';
    }
    
    
	
}
