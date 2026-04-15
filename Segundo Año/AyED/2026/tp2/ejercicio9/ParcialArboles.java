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
		if (arbol != null) {
			int suma = arbol.getData() + sum;
			int menos = arbol.getData() - sum;
			Dato b = new Dato(suma,menos);
			BinaryTree<Dato> a = new BinaryTree<>(b);
			if (arbol.hasLeftChild() /*&& !a1.hasLeftChild()*/) {
				a1.addLeftChild(a);
				dfs(arbol.getLeftChild(),a1.getLeftChild(),suma);
			}
			if (arbol.hasRightChild() /*&& !a1.hasRightChild()*/) {
				a1.addRightChild(a);
				dfs(arbol.getRightChild(),a1.getRightChild(),suma);
			}
		}
	}
	
	
}
