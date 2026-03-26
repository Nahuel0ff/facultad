package Practica.TP2.ejercicio6;

import Practica.TP2.ejercicio1.BinaryTree;

public class Transformacion {
	
	private BinaryTree<Integer> arbol;
	
	public Transformacion (BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma(){
		if(arbol.isEmpty())
			return null;
		return sumaRecursiva(this.arbol);
	}
	
	private BinaryTree<Integer> sumaRecursiva(BinaryTree<Integer> arbol) {
		if (arbol.isLeaf())
			return new BinaryTree<Integer>(0);
		
		BinaryTree<Integer> izq = null;
		BinaryTree<Integer> der = null;
		int suma = 0;

		if (arbol.hasLeftChild()) {
			izq = sumaRecursiva(arbol.getLeftChild());
			suma += izq.getData();
			suma += arbol.getLeftChild().getData();
		}
		if (arbol.hasRightChild()) {
			der = sumaRecursiva(arbol.getRightChild());
			suma += der.getData();
			suma += arbol.getRightChild().getData();
		}

		BinaryTree<Integer> nuevo = new BinaryTree<Integer>(suma);
		nuevo.addLeftChild(izq);
		nuevo.addRightChild(der);
		return nuevo;
	}

	
}
