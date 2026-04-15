package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		// Nivel 0: Raíz
		BinaryTree<Integer> arbol = new BinaryTree<>(10);

		// Nivel 1
		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
		arbol.addLeftChild(nodo2);
		arbol.addRightChild(nodo3);

		// Nivel 2 (Hijos de 2 y 3)
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		nodo2.addLeftChild(nodo5);
		nodo2.addRightChild(nodo4);

		BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
		BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
		nodo3.addLeftChild(nodo9);
		nodo3.addRightChild(nodo8);

		// Nivel 3 (Hojas - Hijos de 5, 4, 9 y 8)
		// Hijos del 5
		nodo5.addLeftChild(new BinaryTree<>(7));
		nodo5.addRightChild(new BinaryTree<>(8));

		// Hijos del 4
		nodo4.addLeftChild(new BinaryTree<>(5));
		nodo4.addRightChild(new BinaryTree<>(6));

		// Hijos del 9
		nodo9.addLeftChild(new BinaryTree<>(12));
		nodo9.addRightChild(new BinaryTree<>(8));

		// Hijos del 8
		nodo8.addLeftChild(new BinaryTree<>(2));
		nodo8.addRightChild(new BinaryTree<>(1));
		
		RedBinariaLlena red = new RedBinariaLlena(arbol);
		
		System.out.println(red.retardoReenvio());
	}

}
