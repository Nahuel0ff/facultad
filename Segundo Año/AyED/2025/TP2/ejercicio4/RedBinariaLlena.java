package ejercicio4;

import ejercicio1.BinaryTree;

public class RedBinariaLlena {
	
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	
	public int retardoEnvio(){
		if (!this.arbol.isEmpty())
			return 0;
		return maximo(0, this.arbol);
	}
	
	private int maximo(int suma, BinaryTree<Integer> arbol) {
		suma+= arbol.getData();
		if(arbol.isLeaf()) {
			return suma;
		}
		int MaxIzq =0;
		int MaxDer =0;
		if (arbol.hasLeftChild()) {
			MaxIzq = maximo(suma, arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			MaxIzq = maximo(suma, arbol.getRightChild());
		}
		return Math.max(MaxIzq, MaxDer);
		
		
	}

}
