package ejercicio5;

import ejercicio1.BinaryTree;

public class Ejercicio5 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(10);
		arbol.addLeftChild(new BinaryTree<Integer>(2));
		arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		arbol.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
		arbol.addRightChild(new BinaryTree<Integer>(3));
		arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arbol.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
		arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		arbol.getRightChild().addRightChild(new BinaryTree<Integer>(8));
		arbol.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(2));
		arbol.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(1));
		
		ProfundidadDeArbolBinario pdab = new ProfundidadDeArbolBinario(arbol);
		int suma = pdab.sumaElementosProfundidad(1);
		System.out.println(suma);

	}

}
