package ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class Sucesion {
	
	
	private static void calcularSucesion (List<Integer> lista, int n) {
		lista.add(n);
		if(n>1) {
			if(n%2==0)
				calcularSucesion(lista,n/2);
			else
				calcularSucesion(lista,3*n+1);

				
		}
	}
		
		public static List<Integer> calcularSucesion(int n){
			List<Integer> lista = new LinkedList <Integer>();
			Sucesion.calcularSucesion(lista,n);
			return lista;
		}
		
		


	public static void main(String[] args) {
		List<Integer> lista = Sucesion.calcularSucesion(6);
		System.out.println(lista);

	}

}
