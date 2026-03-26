package ejercicio7;

import java.util.LinkedList;

public class Sumar {

	
	public static int sumaRecursiva(LinkedList<Integer> lista, int pos) {
		if(pos < lista.size()) {
			return lista.get(pos) + sumaRecursiva(lista, pos+1);
		}
			return 0;
		
	}
	
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		return sumaRecursiva(lista,0);
	}
	
	
	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		int resultado = Sumar.sumarLinkedList(lista);
		System.out.println(resultado);

	}

}
