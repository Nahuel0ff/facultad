package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class Test {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(-5);
		arbol.addLeftChild(nodo1);
		arbol.addRightChild(nodo2);
		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(23);
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(19);
		nodo1.addLeftChild(nodo3);
		nodo1.addRightChild(nodo4);
		nodo2.addLeftChild(nodo5);
		BinaryTree<Integer> nodo6 = new BinaryTree<Integer>(-3);
		BinaryTree<Integer> nodo7 = new BinaryTree<Integer>(55);
		BinaryTree<Integer> nodo8 = new BinaryTree<Integer>(11);
		BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> nodo10 = new BinaryTree<Integer>(18);
		nodo3.addLeftChild(nodo6);
		nodo4.addLeftChild(nodo7);
		nodo4.addRightChild(nodo8);
		nodo5.addRightChild(nodo9);
		nodo9.addLeftChild(nodo10);
		
		ParcialArboles parcial = new ParcialArboles(arbol);
		
		System.out.println(parcial.isLeftTree(7));
		
	}

}
