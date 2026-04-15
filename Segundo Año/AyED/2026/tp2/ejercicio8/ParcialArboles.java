package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
		public ParcialArboles() {
			
		}

	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux= false;
		if (!arbol1.isEmpty() && arbol1 != null) {
			aux = dfs(arbol1,arbol2);
		}
		return aux;
	}
	
	private boolean dfs(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		if(!a1.getData().equals(a2.getData())) {
			return false;
		}
		boolean okIzq = true;
		boolean okDer = true;
		if (a1.hasLeftChild()) {
			if(a2.hasLeftChild()) {
				okIzq=dfs(a1.getLeftChild(),a2.getLeftChild());
			}else{
			return false;
		}
		if(a1.hasRightChild()) {
			if (a2.hasRightChild()) {
				okDer=dfs(a1.getRightChild(),a2.getRightChild());
			}else{
				return false;
			}
		}
		}
		return okIzq && okDer;
	}
}
