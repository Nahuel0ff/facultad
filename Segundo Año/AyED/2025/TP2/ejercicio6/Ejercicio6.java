package Practica.TP2.ejercicio6;

import Practica.TP2.ejercicio1.BinaryTree;

public class Ejercicio6 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(10);
		arbol.addLeftChild(new BinaryTree<Integer>(2));
		arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arbol.addRightChild(new BinaryTree<Integer>(3));
		arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arbol.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
		arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		
		Transformacion tr = new Transformacion(arbol);
		BinaryTree<Integer> arbolResult = tr.suma();
		arbolResult.entreNiveles(0, 3);
		
	}

}
