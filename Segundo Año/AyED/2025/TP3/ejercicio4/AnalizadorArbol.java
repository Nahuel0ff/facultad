package Practica.TP3.ejercicio4;


import Practica.TP2.Clases.Queue;
import Practica.TP3.ejercicio1.GeneralTree;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		if(arbol.isEmpty())
			return 0;
		double result = -1; //Inicia el mayor en -1
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();  //Genera la cola
		queue.enqueue(arbol);  //Encola el arbol
		while(!queue.isEmpty()) {   // Si no esta vacio, mantiene el While
			int aux = queue.size();   //Toma la dimension
			double suma = 0;          // Inicia la suma
			for(int i = 0; i< aux; i++) {   //Recorre teniendo en cuenta la dimension
				GeneralTree<AreaEmpresa> arbaux = queue.dequeue();    //Desencola
				suma += arbaux.getData().getTardanza();   // Suma la tardanza
				for(GeneralTree<AreaEmpresa> child: arbaux.getChildren())  //recorre los hijos
					queue.enqueue(child);       
			}
			double promAux = suma / aux;
			System.out.println(promAux);
			if (promAux > result)
				result = promAux;
		}
		return result;
	}



}
