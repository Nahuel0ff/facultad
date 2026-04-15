package tp2.ejercicio3;

import java.util.List;

import tp2.ejercicio1.BinaryTree
;

public class ejercicio3 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(6);
		arbol.addLeftChild(new BinaryTree<>(2));
		arbol.addRightChild(new BinaryTree<>(9));
		arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
		arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
		arbol.getRightChild().addLeftChild(new BinaryTree<>(8));
		arbol.getRightChild().addRightChild(new BinaryTree<>(10));
		
		ContadorArbol ca = new ContadorArbol(arbol);
		
		//PreOrden
		List<Integer> lista = ca.numerosPares();
		System.out.println("-----PreOrden-----");
		System.out.print(lista);
		System.out.println();
		//InOrden
		lista = ca.numerosParesInOrder();
		System.out.println("-----InOrden-----");
		System.out.println(lista);
		//PostOrden
		lista = ca.numerosParesPostOrder();
		System.out.println("-----PostOrden-----");
		System.out.println(lista);

	}

}