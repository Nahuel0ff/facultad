package Practica.TP3.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import Practica.TP3.ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> red;
	
	public RedDeAguaPotable(GeneralTree<Character> red) {
		this.red = red;
	}
	
	
	public double minimoCaudal(double caudal) {
		if (red.isEmpty())
			return 0;
		return calcular(red,caudal);	//Llama aux para respetar la firma	
	}
	
	private double calcular(GeneralTree<Character> nodo, double caudal) {
		if(nodo.isLeaf()) {
			return caudal;  //Si es hoja, es el fin, devuelve el caudal
		}
		
		int cant = nodo.getChildren().size();
		double nuevoCau = caudal / cant;
		double minimo = Double.MAX_VALUE;
		
		for(GeneralTree<Character> child : nodo.getChildren()) {
			double cauChild = calcular(child,nuevoCau);
			if(cauChild < minimo) {
				minimo = cauChild;
			}
		}
		return minimo;
	}

	
	
	

	public static void main(String[] args) {
		GeneralTree<Character> ab1 = new GeneralTree<Character>('B');
        
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('L'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('G', subChildren1);
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('F'));
        subChildren2.add(subAb1);
        GeneralTree<Character> ab2 = new GeneralTree<Character>('C', subChildren2);
        
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(new GeneralTree<Character>('M'));
        subChildren3.add(new GeneralTree<Character>('N'));
        GeneralTree<Character> subAb2 = new GeneralTree<Character>('J', subChildren3);
        List<GeneralTree<Character>> subChildren4 = new LinkedList<GeneralTree<Character>>();
        subChildren4.add(new GeneralTree<Character>('H'));
        subChildren4.add(new GeneralTree<Character>('I'));
        subChildren4.add(subAb2);
        subChildren4.add(new GeneralTree<Character>('K'));
        subChildren4.add(new GeneralTree<Character>('P'));
        GeneralTree<Character> ab3 = new GeneralTree<Character>('D', subChildren4);
        
        GeneralTree<Character> ab4 = new GeneralTree<Character>('E');
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(ab1);
        arbol.add(ab2);
        arbol.add(ab3);
        arbol.add(ab4);
        GeneralTree<Character> ab = new GeneralTree<Character>('A', arbol);
        
        RedDeAguaPotable red = new RedDeAguaPotable(ab);
        System.out.println("Caudal minimo que recibe una casa: " + red.minimoCaudal(1000.0));

	}

}
