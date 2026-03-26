package ejercicio7;

import java.util.ArrayList;

public class Combinar {
	
	public static ArrayList<Integer> combinarOrd(ArrayList<Integer>lista1, ArrayList<Integer>lista2){
		ArrayList<Integer> listaComb = new ArrayList<>();
		int i = 0;
		int j = 0;
		while ((i < lista1.size())&&(j<lista2.size())) {
			if (lista1.get(i) <= lista2.get(j)) {
				listaComb.add(lista1.get(i));
				i++;
			}else {
				listaComb.add(lista2.get(j));
				j++;
			}
			
		}
		while (i < lista1.size()) {
			listaComb.add(lista1.get(i));
			i++;
		}
		while (j < lista2.size()) {
			listaComb.add(lista2.get(j));
			j++;
		}		
		return listaComb;
	}

	public static void main(String[] args) {
		ArrayList<Integer> lista1 = new ArrayList<>();
		ArrayList<Integer> lista2 = new ArrayList<>();
		lista1.add(3);
		lista1.add(6);
		lista1.add(8);
		lista1.add(9);
		lista1.add(14);
		lista2.add(5);
		lista2.add(7);
		lista2.add(13);
		
		ArrayList<Integer> combinado = new ArrayList<>();
		combinado = Combinar.combinarOrd(lista1, lista2);
		System.out.println(combinado);

	}

}
