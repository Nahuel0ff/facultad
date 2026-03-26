package ejercicio5;

public class ejercicio5 {

	public static void main(String[] args) {
		Resultados r = new Resultados();
		Numeros numeros =  new Numeros();
		int vector [] = new int[5];
		
		//Cargo el vector
		for (int i=0; i<vector.length;i++)
			vector[i] = i+10;                    //10 11 12 13 14 
		
		
		// Aplicamos el metodo 1
		numeros = r.met1(vector);
		System.out.println(numeros.toString());   //10 14 12
		System.out.println("-----------------");
		
		//Vuelvo a cargar el vector
		for (int i = 0; i<vector.length; i++) 
			vector[i] = i+15;                     //15 16 17 18 19
		
		//Aplicamos el metodo 2
		numeros = r.met2(vector,numeros);
		System.out.println(numeros.toString());   //15 19 17
		System.out.println("-----------------");
		
		
		//Vuelvo a cargar el vector
		for (int i = 0; i<vector.length; i++) 
			vector[i] = i+20;                      //20 21 22 23 24
		
		//Aplicamos el metodo 3
		r.met3(vector);
		System.out.println(Resultados.numeros.toString());   //20 24 22

	}

}
