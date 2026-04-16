package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

	public ParcialArboles() {
		
	}
	
	public BinaryTree<Dato> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Dato> a1 = new BinaryTree<Dato>();
		if (!arbol.isEmpty() && arbol != null) {
			dfs(arbol,a1,0);
		}
		return a1;
	}
	
	private void dfs(BinaryTree<Integer> arbol, BinaryTree<Dato> a1, int sum) {
			int suma = arbol.getData() + sum;
			int menos = arbol.getData() - sum;
			Dato b = new Dato(suma,menos);
			a1.setData(b);
			if (arbol.hasLeftChild()) {
				BinaryTree<Dato> c = new BinaryTree<>();
				a1.addLeftChild(c);
				dfs(arbol.getLeftChild(),c,suma);
			}
			if (arbol.hasRightChild()) {
				BinaryTree<Dato> d = new BinaryTree<>();
				a1.addRightChild(d);
				dfs(arbol.getRightChild(),d,suma);
			}
		
	}

	public void imprimirDFS(BinaryTree<Dato> a) {
	    if (a != null && !a.isEmpty()) {
	        System.out.println(a.getData()); 

	        if (a.hasLeftChild()) {
	            imprimirDFS(a.getLeftChild());
	        }
	        if (a.hasRightChild()) {
	            imprimirDFS(a.getRightChild());
	        }
	    }
	}
	
	
	
}
