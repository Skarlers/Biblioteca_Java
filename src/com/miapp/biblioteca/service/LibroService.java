package com.miapp.biblioteca.service;
import com.miapp.biblioteca.*;
import java.util.*;
public class LibroService {
	
	private ArrayList <Libro> biblioteca;
	
	
	public LibroService(ArrayList biblioteca){
		this.biblioteca = new ArrayList<>();
	}
	
	
	// Getter para el atributo biblioteca
	public ArrayList<Libro> getBiblioteca() {
	    return biblioteca;
	}
	
	// Setter para el atributo biblioteca
	public void setBiblioteca(ArrayList<Libro> biblioteca) {
	    this.biblioteca = biblioteca;
	}
	
	public void crearLibro(String nombre, String autor, String isbn, String genero) {
		Libro newLibro = new Libro(nombre, autor,isbn,genero);
		biblioteca.add(newLibro);		
	}
	public void actualizarLibro(String nombre, String autor, String isbn, String genero) {
		for(Libro libro : biblioteca) {
			if(libro.getISBN().equals(isbn)) {
				libro.setTitulo(nombre);
				libro.setGenero(genero);
				libro.setAutor(autor);
				libro.setISBN(isbn);
				
			}
				
		}
	}
	/*
	//El problema radica en que estás intentando modificar la lista (biblioteca) mientras la estás iterando mediante un bucle for-each. 
	//Esto puede causar una excepción ConcurrentModificationException.
	public void eliminarLibro(String isbn) {
		for(Libro libro : biblioteca) {
			if(libro.getISBN().equals(isbn)) {
				biblioteca.remove(libro);
				
			}
				
		}
	}*/
	public void eliminarLibro(String isbn) {
	    Iterator<Libro> iterator = biblioteca.iterator();
	    while (iterator.hasNext()) {
	        Libro libro = iterator.next();
	        if (libro.getISBN().equals(isbn)) {
	            iterator.remove();
	        }
	    }
	}
	
	public void buscarLibroISBN(String isbn) {
		for (Libro libroBuscar :biblioteca) {
			if(libroBuscar.getISBN().equals(isbn)) {
				System.out.println(libroBuscar.toString());
			}
		}
		
	}
	
	public Libro buscarLibro(String titulo) {
		for (Libro libroBuscar :biblioteca) {
			if(libroBuscar.getTitulo().equalsIgnoreCase(titulo)) {
				return libroBuscar;
			}
		}
		return null;
	}
	
	
	}
	
	

