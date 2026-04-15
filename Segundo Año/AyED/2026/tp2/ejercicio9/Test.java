package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

public class Test {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(20);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(30);
		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(-5);
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(50);
		BinaryTree<Integer> nodo6 = new BinaryTree<Integer>(-9);
		BinaryTree<Integer> nodo7 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> nodo8 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(6);
		arbol.addLeftChild(nodo1);
		arbol.addRightChild(nodo2);
		nodo1.addLeftChild(nodo3);
		nodo1.addRightChild(nodo4);
		nodo2.addLeftChild(nodo5);
		nodo2.addRightChild(nodo6);
		nodo4.addLeftChild(nodo7);
		nodo5.addRightChild(nodo8);
		nodo8.addRightChild(nodo9);
		
		ParcialArboles a = new ParcialArboles();
		
		BinaryTree<Dato> a1 = a.sumAndDif(arbol);
		
		arbol.entreNiveles(0, 4);
		a1.entreNiveles(0, 4);
		// Esta roto, tengo que corregir el arbol creado
		
	}

}
