package ejercicio7;

import java.util.ArrayList;

public class Invertir {
	
	public static void invertirArrayList(ArrayList<Integer> lista) {
		invertirRecursivo(lista, 0 ,lista.size() - 1);
	}
	
	public static void invertirRecursivo(ArrayList<Integer> lista, int inicio, int fin) {
		if(inicio < fin) {
			int aux = lista.get(fin);
			lista.set(fin, lista.get(inicio));
			lista.set(inicio, aux);
			invertirRecursivo(lista,inicio+1,fin-1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		System.out.println(lista);
		
		Invertir.invertirArrayList(lista);
		
		System.out.println(lista);
	}

}
