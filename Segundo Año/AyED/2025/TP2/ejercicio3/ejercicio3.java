package ejercicio3;

import java.util.List;

import ejercicio1.BinaryTree;

public class ejercicio3 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(1);
		arbol.addLeftChild(new BinaryTree<Integer>(2));
		arbol.addRightChild(new BinaryTree<Integer>(3));
		arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(6));
		arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arbol.getRightChild().addRightChild(new BinaryTree<Integer>(10));
		
		ContadorArbol ca = new ContadorArbol(arbol);
		
		//PreOrden
		List<Integer> lista = ca.numerosPares();
		System.out.println("-----PreOrden-----");
		System.out.print(lista);
		System.out.println();
		//InOrden
		lista = ca.paresInOrden();
		System.out.println("-----InOrden-----");
		System.out.println(lista);
		//PostOrden
		lista = ca.paresPostOrden();
		System.out.println("-----PostOrden-----");
		System.out.println(lista);

	}

}
