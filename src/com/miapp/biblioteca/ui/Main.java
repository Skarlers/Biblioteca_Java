package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.*;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		ArrayList <Libro> biblioteca = new ArrayList<>();
		ArrayList <Usuario> usuarios = new ArrayList<>();
		//Instancio a los objetos de las clases service (para poder realizar las operaciones)
		LibroService libroService = new LibroService (biblioteca);
		UsuarioService usuarioService = new UsuarioService (usuarios);
		
		
		int opc;
		do {
			mostrarMenu();
			opc = teclado.nextInt();
			switch (opc){
			  case 1:
				  System.out.println("Ingrese el título del libro:");
			      String titulo = teclado.next();
			      teclado.nextLine();
			      System.out.println("Ingrese el autor del libro:");
			      String autor = teclado.next();
			      teclado.nextLine();
			      System.out.println("Ingrese el ISBN:");
			      String isbn = teclado.next();
			      teclado.nextLine();
			      System.out.println("Ingrese el género del libro:");
			      String genero = teclado.next();
			      teclado.nextLine();
			      
			      libroService.crearLibro(titulo, autor, isbn, genero);
			      
			      
			      
			      System.out.println("El libro se ingresó correctamente.\n");
			      break;
			  case 2:
				  System.out.println("Ingrese el título del libro:");
				  String tituloAct = teclado.nextLine();
				  teclado.nextLine();
				  System.out.println("Ingrese el autor del libro:");
				  String autorAct = teclado.nextLine();
				  teclado.nextLine();
				  System.out.println("Ingrese el ISBN:");
				  String isbnAct = teclado.nextLine();
				  teclado.nextLine();
				  System.out.println("Ingrese el género del libro:");
				  String generoAct = teclado.nextLine();
				  teclado.nextLine(); 
				  libroService.actualizarLibro(tituloAct, autorAct, isbnAct, generoAct);
				  break;
			  case 3:
				  System.out.println("Ingrese el libro a buscar con su ISBN: ");
				  String isbnSearch = teclado.next();
				  teclado.nextLine();
				 libroService.buscarLibroISBN(isbnSearch);
				  break;
				  
			  case 4:
				  System.out.println("Ingrese el libro a buscar por su nombre (Recuerde, tienen que ser exactos): ");
				  String nombreSearch = teclado.next();
				  teclado.nextLine();
				  System.out.println(libroService.buscarLibro(nombreSearch));
				  break;
			  case 5:
				  System.out.println(libroService.getBiblioteca());
				  break;
			  case 6: 
				  System.out.println("Ingrese el ISBN del libro a eliminar: ");
				  String isbnDel = teclado.next();
				  teclado.nextLine();
				  libroService.eliminarLibro(isbnDel);
				  break;
			  case 7:
				  System.out.println("Usted tiene hecha ya su usuario('s' ó 'n'): ");
				  String opcCr = teclado.next();
				  if(opcCr.equals("n")) {
					  teclado.nextLine();
					  System.out.println("Ingrese el nombre del nuevo usuario: ");
					  String nomCreacion = teclado.nextLine();
					  teclado.nextLine();
					  System.out.println("Ingrese ID del nuevo Usuario: ");
					  String idUsrNew = teclado.nextLine();
					  teclado.nextLine();
					  usuarioService.crearUsuario(nomCreacion, idUsrNew);
					  
				  }
				  
				 
				  
				  
				  System.out.println("Ingrese el nombre del usuario Existente: ");
				  String nameUsr = teclado.next();
				  teclado.nextLine();
				  System.out.println("Ingrese ID del Usuario Existente: ");
				  String idUsr = teclado.next();
				  teclado.nextLine();
				  
				  
			      System.out.println("Ingrese el ISBN del libro a prestar:");
			      String isbn1 = teclado.next();
			      teclado.nextLine();
			      
				  
				  
				  Usuario usr = new Usuario (nameUsr,idUsr);	  
				  
				  Libro libroBuscar = new Libro (null, null, isbn1, null);
			
				  for(Usuario usrFor : usuarioService.getUsuarios()) {
					  if(usrFor.getNumeroIdentificacion().equals(usr.getNumeroIdentificacion())){
						  for(Libro libroFor : libroService.getBiblioteca()) {
							  if(libroFor.getISBN().equals(libroBuscar.getISBN())) {
								  usuarioService.prestarLibro(libroFor, usrFor);
								  System.out.println("Libro prestado.");
								  System.out.println(usrFor.getListaLibrosPrestados());
							  }
						  }
					 
							  
					  }
				  }
						  
					  
					  
			  break;
					  
			  case 8: 	
				  
				  System.out.println("Ingrese el nombre del usuario: ");
				  String nameUsr1 = teclado.nextLine();
				  teclado.nextLine();
				  System.out.println("Ingrese ID del Usuario: ");
				  String idUsr1 = teclado.nextLine();
				  teclado.nextLine();
				  
				 
			      System.out.println("Ingrese el ISBN:");
			      String isbn11 = teclado.next();
			      teclado.nextLine();
			       
			      Usuario usr1 = new Usuario (nameUsr1,idUsr1);
			      Libro libro1 = new Libro (null, null, isbn11, null);
				  for(Usuario usrFor : usuarioService.getUsuarios()) {
					  if(usr1.getNumeroIdentificacion().equals(usrFor.getNumeroIdentificacion())){
						  for(Libro libroFor : libroService.getBiblioteca()) {
							  if(libroFor.getISBN().equals(libro1.getISBN())) {
								  usuarioService.devolverLibro(libroFor, usrFor);
								  System.out.println("Libro devuelto");
								  System.out.println(usrFor.getListaLibrosPrestados());
							  }
						  }
					 
							  
					  }
				  }
				
					  
				  
				  
				  usuarioService.devolverLibro(libro1, usr1);
				  break;
				  
				  
				  
				  
			}
			
		}while(opc!=9);
	
	}
	
		
	public static void mostrarMenu() {
	       System.out.println("Bienvenido a la Biblioteca");
	       System.out.println("1. Crear Libro");
	       System.out.println("2. Actualizar Libro");
	       System.out.println("3. Buscar Libro");
	       System.out.println("4. Buscar Libro por Título");
	       System.out.println("5. Listar Libros");
	       System.out.println("6. Eliminar Libro");
	       System.out.println("7. Realizar Préstamo");
	       System.out.println("8. Realizar Devolución");
	       System.out.println("9. Salir");
	       System.out.println("Ingrese el número de la opción deseada:");
	}

}

