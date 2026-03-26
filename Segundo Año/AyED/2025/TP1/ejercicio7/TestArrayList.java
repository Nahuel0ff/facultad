package ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ejercicio3.Estudiante;

public class TestArrayList {

	public static void main(String[] args) {
		
		//Creo la ArrayList
		
		ArrayList<Integer> numeros = new ArrayList<>();
		
		//Declaro es Scanner
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese los numeros, 'fin' para terminar");
		
		String entrada = scanner.next();                // Ingresa el numero
		while(!entrada.equalsIgnoreCase("fin")) {       // Revisa si es punto de corte
			if(esNumero(entrada)) {                     // Verifica
				int numero = Integer.parseInt(entrada); //Lo pasa a entero
				numeros.add(numero);                    //Lo agrega a la lista
			}else {
				System.out.println("El valor"+entrada+"no es un numero valido");
			}
			System.out.println("Ingrese otro numero, 'fin' para terminar");
			entrada = scanner.next(); //Lee el siguiente
		}
		//Forma 1 de imprimir
		System.out.println("Contenido de la lista: ");
		for(int i = 0; i < numeros.size();i++){
			System.out.println(numeros.get(i));	
		}
		//Forma 2 de imprimir
		System.out.println("Contenido de la lista2: ");
		for(int l: numeros){
			System.out.println(l);	
		}
		
		scanner.close();
			
		//b Es mejor un ArrayList que una LinkedList porque puedo hacerlo por indice y agregar simple
		//Si usaba una Linked, funciona de igual forma pero mas lento  
		//
		
		//Parte D del ejercicio//
		
		
		List<Estudiante> listaEstudiantess = new LinkedList<>();
		listaEstudiantess.add(new Estudiante("Juancito","Perez","soyrecapo@hotmail.com","33","Cataluña"));
		listaEstudiantess.add(new Estudiante("Juana","Gomez","soyrecapa@hotmail.com","14","Asturias"));
		listaEstudiantess.add(new Estudiante("Juan","Hernandez","soyrecapito@hotmail.com","1","Oviedo"));
		listaEstudiantess.add(new Estudiante("Pablo","Lopez","nosoytancapo@yahoo.com","3","España"));
		
		List<Estudiante> listaEstudiantess2 = new LinkedList<>(listaEstudiantess);
		
		System.out.println("-------Lista de Estudiantes 1-------");
		for(Estudiante l: listaEstudiantess) {
			System.out.println(l);
		}
		
		System.out.println("-------Lista de Estudiantes 2-------");
		for(Estudiante p: listaEstudiantess2) {
			System.out.println(p);
		}
		
		//Modifico archivo
		
		System.out.println("----SE CAMBIO UN APELLIDO----");
		listaEstudiantess.get(1).setApellido("Hamilton");
		
		
		System.out.println("-------Lista de Estudiantes 1-------");
		for(Estudiante l: listaEstudiantess) {
			System.out.println(l);
		}
		
		System.out.println("-------Lista de Estudiantes 2-------");
		for(Estudiante p: listaEstudiantess2) {
			System.out.println(p);
		}
		
		
		//Conclusion, la lista 2 es un puntero a lista 1
		
		Estudiante estudianteNuevito = new Estudiante("Fenrnando","Alonso","tremendocrack@f1.com","33","Victoria");
		if (!listaEstudiantess.contains(estudianteNuevito))
			listaEstudiantess.add(estudianteNuevito);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	private static boolean esNumero(String str) {
		return str.matches("\\d+");
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
