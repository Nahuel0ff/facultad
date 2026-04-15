package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {

	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma(){
		if (this.arbol != null || !this.arbol.isEmpty()) {
			dfs(this.arbol);
	    }
		return this.arbol;
	}
	
	private int dfs(BinaryTree<Integer> a){
		int sumaIzq = 0;
		int sumaDer = 0;
		if (a.hasLeftChild()) {
			sumaIzq= dfs(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			sumaDer = dfs(a.getRightChild());
		}
		
		int valor = a.getData();
		
		a.setData(sumaIzq + sumaDer);
		
		return valor + sumaIzq + sumaDer;
	}
	
	public void imprimir(BinaryTree<Integer> ab) {
		if(ab != null) {
			System.out.println(ab.getData());
			if (ab.hasLeftChild()) {
				imprimir(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				imprimir(ab.getRightChild());
			}
	}
	}
	
	
	
}
