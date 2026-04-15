package tp2.ejercicio5;

import tp2.ejercicio1.BinaryTree;

public class Ejercicio5 {

	public static void main(String[] args) {
        
        // Nivel 0
        BinaryTree<Integer> raiz = new BinaryTree<Integer>(10);
        // Nivel 1
        BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(2);
        BinaryTree<Integer> hijoDer = new BinaryTree<Integer>(3);
        raiz.addLeftChild(hijoIzq);
        raiz.addRightChild(hijoDer);
        //Nivel2
        hijoIzq.addLeftChild(new BinaryTree<Integer>(5));
        hijoIzq.addRightChild(new BinaryTree<Integer>(4));
        //Nivel2
        hijoDer.addLeftChild(new BinaryTree<Integer>(9));
        hijoDer.addRightChild(new BinaryTree<Integer>(8));

        ProfundidadDeArbolBinario profundizador = new ProfundidadDeArbolBinario(raiz);
        
        System.out.println("Pruebas del método sumaElementosProfundidad:");
        System.out.println("Suma en profundidad 0 (Esperado 10): " + profundizador.sumaElementosProfundidad(0));
        System.out.println("Suma en profundidad 1 (Esperado 5): " + profundizador.sumaElementosProfundidad(1));
        System.out.println("Suma en profundidad 2 (Esperado 26): " + profundizador.sumaElementosProfundidad(2));
        System.out.println("Suma en profundidad 3 (Esperado 0): " + profundizador.sumaElementosProfundidad(3)); // Nivel que no existe
    }


	}
