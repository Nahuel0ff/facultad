package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class Test {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol1 = new BinaryTree<Integer>(65);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(37);
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(81);
		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(47);
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(93);
		arbol1.addLeftChild(nodo1);
		arbol1.addRightChild(nodo2);
		nodo1.addRightChild(nodo3);
		nodo2.addRightChild(nodo4);
		
		BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(65);
		BinaryTree<Integer> nodo5 = new BinaryTree<Integer>(37);
		BinaryTree<Integer> nodo6 = new BinaryTree<Integer>(81);
		BinaryTree<Integer> nodo7 = new BinaryTree<Integer>(47);
		BinaryTree<Integer> nodo8 = new BinaryTree<Integer>(93);
		arbol2.addLeftChild(nodo5);
		arbol2.addRightChild(nodo6);
		nodo5.addRightChild(nodo7);
		nodo6.addRightChild(nodo8);
		BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(22);
		BinaryTree<Integer> nodo10 = new BinaryTree<Integer>(76);
		BinaryTree<Integer> nodo11 = new BinaryTree<Integer>(11);
		BinaryTree<Integer> nodo12 = new BinaryTree<Integer>(29);
		BinaryTree<Integer> nodo13 = new BinaryTree<Integer>(85);
		BinaryTree<Integer> nodo14 = new BinaryTree<Integer>(94);
		nodo5.addLeftChild(nodo9);
		nodo6.addLeftChild(nodo10);
		nodo9.addLeftChild(nodo11);
		nodo9.addRightChild(nodo12);
		nodo8.addLeftChild(nodo13);
		nodo8.addRightChild(nodo14);
		
		ParcialArboles a = new ParcialArboles();
		
		System.out.println(a.esPrefijo(arbol1,arbol2));
		
		
	}

}
