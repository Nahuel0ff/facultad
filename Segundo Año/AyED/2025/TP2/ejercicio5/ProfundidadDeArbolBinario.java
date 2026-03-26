package ejercicio5;

import Clases.Queue;
import ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	
	private BinaryTree <Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	public int sumaElementosProfundidad(int p) {
		int nivel = 0;
		if(arbol.isEmpty())
			return 0;                                   //Si el arbol esta vacio devuelve 0
		int suma = 0;
		Queue<BinaryTree<Integer>> cola = new Queue<>(); //Se crea la cola
		BinaryTree<Integer> arbol;
		cola.enqueue(this.arbol);                        // Se encola el arbol
		cola.enqueue(null);                              // Punto null
		while(!cola.isEmpty()) {                         // Mientras la cola no este vacia
			arbol = cola.dequeue();                      // Se desencola 
			if(arbol != null) {                          // Si el arbol es distinto de null
				if(nivel == p)                           // Si el nivel es igual al parametro
					suma += arbol.getData();             // Se suma el dato al sumador
				if (arbol.hasLeftChild())                // Se consulta por hijo izq
					cola.enqueue(arbol.getLeftChild());
				if (arbol.hasRightChild())               // Se consulta por el hijo der
					cola.enqueue(arbol.getRightChild());
			}
			else if (!cola.isEmpty()) {                  // Si la cola no esta vacia
	   	    	cola.enqueue(null);                      // Se agrega un salto en null
	   	    	nivel ++;                                // Incremento en nivel
			}
		}
		return suma;
	}
	
}
