package com.miapp.biblioteca.service;
import com.miapp.biblioteca.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

public class UsuarioService {
private ArrayList <Usuario> usuarios;
	
	
	public UsuarioService(ArrayList usuarios){
		this.usuarios = new ArrayList<>();
	}
	
	
	// Getter para el atributo biblioteca
	public ArrayList<Usuario> getUsuarios() {
	    return usuarios;
	}
	
	// Setter para el atributo biblioteca
	public void setUsuarios(ArrayList<Usuario> usuarios) {
	    this.usuarios = usuarios;
	}
	
	public void crearUsuario(String nombre, String id) {
		Usuario newUsr = new Usuario(nombre,id);
		usuarios.add(newUsr);		
	}
	public void actualizarUsuario(String nombre, String id) {
		for(Usuario usuario : usuarios) {
			if(usuario.getNumeroIdentificacion().equals(id)) {
				usuario.setNombre(nombre);
				usuario.setNumeroIdentificacion(id);
				
				
			}
				
		}
	}
	
	/*public void eliminarUsuario(String id) {
		for(Usuario usuario: usuarios) {
			if(usuario.getNumeroIdentificacion().equals(id)) {
				usuarios.remove(usuario);
				
			}
				
		}
	}*/
	
	public void eliminarUsuario(String id) {
	    Iterator<Usuario> iterator = usuarios.iterator();
	    while (iterator.hasNext()) {
	        Usuario usuario = iterator.next();
	        if (usuario.getNumeroIdentificacion().equals(id)) {
	            iterator.remove();
	            break; // Terminamos la iteración después de eliminar el usuario
	        }
	    }
	}
	
	public void prestarLibro(Libro libro, Usuario usuario) {
			if(libro.isDisponible()) {
				usuario.agregarLibroPrestado(libro);
				libro.setDisponible(false);
			}else {
				System.out.println("Lo lamento muchísimo pero el libro no se encuentra disponible, intente en otro momento. =(");
			}		
	}
	
	public void devolverLibro(Libro libro, Usuario usuario) {
			if(usuario.getListaLibrosPrestados().contains(libro)) {
				usuario.getListaLibrosPrestados().remove(libro);
				libro.setDisponible(true);
			}		
	}
	
	public void buscarUsuario(Usuario usuario) {
		for (Usuario usr:usuarios) {
			if(usr.getNumeroIdentificacion() == usuario.getNumeroIdentificacion()) {
				usr.toString();
			}
		}
	}
	
	
}
