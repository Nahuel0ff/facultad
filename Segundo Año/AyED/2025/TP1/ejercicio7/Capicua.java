package ejercicio7;

import java.util.ArrayList;

public class Capicua {
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		int tamaño = lista.size();                    //Toma el tamaño
		int [] vector = new int [tamaño];             //Crea un vector del mismo tamaño
		for (int i=0; i<tamaño;i++) {                 //recorre la lista
			vector[i] = lista.get(tamaño-i-1);        //Pasa el dato
		}
		
		int i = 0; 
		boolean ok = true;
		while(i<tamaño && ok == true) {               
			if (vector[i] == lista.get(i))           //Compara si es igual
				ok= true;                            // Si esta todo bien mantiene el true
			else
				ok=false;                            //hay diferencia y pasa a false
			i++;                                     //Sigue avanzando
		}

		return ok;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(0);
		lista.add(1);
		lista.add(2);
		lista.add(1);
		lista.add(1);
		
		System.out.println(Capicua.esCapicua(lista));
	}

}
