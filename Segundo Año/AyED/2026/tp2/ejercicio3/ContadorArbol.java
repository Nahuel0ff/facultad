package tp2.ejercicio3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

public class ContadorArbol {
	
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> numerosPares() {
		List<Integer> lista = new ArrayList<>();
		if(!arbol.isEmpty())
			numerosParesRecursivos(lista,this.arbol);
		return lista;
	}
	
	private void numerosParesRecursivos(List<Integer> lista, BinaryTree<Integer> arbol) {
		if (arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
		if (arbol.hasLeftChild())
			numerosParesRecursivos(lista, arbol.getLeftChild());
		if (arbol.hasRightChild())
			numerosParesRecursivos(lista, arbol.getRightChild());
	}
	
	
	public List<Integer> numerosParesInOrder(){
		if (this.arbol != null) {
			LinkedList<Integer> lista = new LinkedList<Integer>();
			inOrder(this.arbol,lista);
			return lista;
		}
		return null;
	}
	
	private void inOrder(BinaryTree<Integer> ab, LinkedList<Integer> lista){
			if(ab.hasLeftChild() && ab != null) {
				this.inOrder(ab.getLeftChild(),lista);
			}
			if(ab.getData() % 2 == 0) {	
				lista.add(ab.getData());
			}
			if(ab.hasRightChild() && ab != null) {
				this.inOrder(ab.getRightChild(), lista);
			}
	}
	
	public List<Integer> numerosParesPostOrder(){
		if (this.arbol != null) {
			LinkedList<Integer> lista = new LinkedList<Integer>();
			postOrden(this.arbol,lista);
			return lista;
		}
		return null;
	}
	
	private void postOrden(BinaryTree<Integer> ab, LinkedList<Integer> lista) {
		if(ab.hasLeftChild() && ab != null) {
			this.inOrder(ab.getLeftChild(),lista);
		}
		if(ab.hasRightChild() && ab != null) {
			this.inOrder(ab.getRightChild(), lista);
		}	
		if(ab.getData() % 2 == 0) {	
			lista.add(ab.getData());
		}

	}
	
	
}
