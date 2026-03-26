package ejercicio2;

import ejercicio1.BinaryTree;

public class ejercicio2 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(1);
		arbol.addLeftChild(new BinaryTree<>(2));
		arbol.addRightChild(new BinaryTree<>(3));
		arbol.getRightChild().addLeftChild(new BinaryTree<>(4));
		arbol.getRightChild().addRightChild(new BinaryTree<>(5));
		arbol.getLeftChild().addLeftChild(new BinaryTree<>(6));
		System.out.println("La cantidad de hojas del arbol: "+ arbol.contarHojas());
		
		BinaryTree<Integer> arbolEspejado = arbol.espejo();
		arbol.entreNiveles(0, 1);
		System.out.println();
		arbolEspejado.entreNiveles(0, 2);
	}

}
