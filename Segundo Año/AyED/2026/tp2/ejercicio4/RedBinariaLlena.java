package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
	    if (this.arbol == null || this.arbol.isEmpty()) {
	        return 0;
	    }
	    return calcularRetardo(this.arbol);
	}

	private int calcularRetardo(BinaryTree<Integer> nodo) {
	    if (nodo.isLeaf()) {
	        return nodo.getData();
	    }
	    
	    int retardoIzquierdo = 0;
	    int retardoDerecho = 0;
	    
	    if (nodo.hasLeftChild()) {
	        retardoIzquierdo = calcularRetardo(nodo.getLeftChild());
	    }
	    if (nodo.hasRightChild()) {
	        retardoDerecho = calcularRetardo(nodo.getRightChild());
	    }
	    
	    return nodo.getData() + Math.max(retardoIzquierdo, retardoDerecho);
	}

}
