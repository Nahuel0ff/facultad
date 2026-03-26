package ejercicio5;

public class Resultados {
	
	static Numeros numeros;
	public Resultados() {
		
	}
	
	public Numeros met1(int array[]) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double suma = 0;
		for (int i = 0; i<array.length;i++) {
			if(array[i]<min) 
				min = array[i];
			if(array[i]>max)
				max = array[i];
			suma += array[i];
			
		}
		Numeros numeros = new Numeros();
		numeros.setMaximo(max);
		numeros.setMinimo(min);
		numeros.setPromedio(suma/array.length);
		return numeros;
	
	}
	
	public Numeros met2(int array[], Numeros numeros) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double suma = 0;
		for (int i = 0; i< array.length; i++) {
			if (array[i]<min)
				min = array[i];
			if (array[i]>max)
				max = array[i];
			suma += array[i];
		}
		numeros.setMaximo(max);
		numeros.setMinimo(min);
		numeros.setPromedio(suma/array.length);
		return numeros;
	}
	
	
	public void met3 (int array[]) {
		double suma = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if(array[i] < min) min = array[i];
			if(array[i] > max) max = array[i];
			suma += array[i];
		}
		
		numeros = new Numeros(); // usar la variable estática
		numeros.setMinimo(min);
		numeros.setMaximo(max);
		numeros.setPromedio(suma / array.length);
	}

	}
	
