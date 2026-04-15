package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		BinaryTree<Integer> arbol = new BinaryTree<>(1);
		
		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
		arbol.addLeftChild(nodo2);
		arbol.addRightChild(nodo3);
		
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		
		nodo2.addRightChild(nodo4);
		nodo3.addLeftChild(nodo5);
		nodo3.addRightChild(nodo6);

		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
		
		nodo5.addLeftChild(nodo7);
		nodo5.addRightChild(nodo8);
		
		Transformacion t = new Transformacion(arbol);
		t.imprimir(arbol);
		t.suma();
		t.imprimir(arbol);
		
		
		
		

	}

}
