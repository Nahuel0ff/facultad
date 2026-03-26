package ejercicio3;

import java.util.ArrayList;
import java.util.List;

import ejercicio1.BinaryTree;

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
	
	
	public List<Integer> paresInOrden() {
		List<Integer> lista = new ArrayList<>();
		if (!this.arbol.isEmpty())
			paresRecursivosInOrden(lista, this.arbol);
		return lista;
	}
	
	private void paresRecursivosInOrden(List<Integer> lista, BinaryTree<Integer> arbol) {
		if (arbol.hasLeftChild())
			paresRecursivosInOrden(lista, arbol.getLeftChild());
		if (arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
		if (arbol.hasRightChild())
			paresRecursivosInOrden(lista,arbol.getRightChild());
	}
	
	public List<Integer> paresPostOrden(){
		List<Integer> lista = new ArrayList<>();
		if (!this.arbol.isEmpty())
			paresRecursivoPostOrden(lista,this.arbol);
		return lista;
	}
	
	private void paresRecursivoPostOrden(List<Integer> lista, BinaryTree<Integer> arbol) {
		if (arbol.hasLeftChild())
			paresRecursivoPostOrden(lista, arbol.getLeftChild());
		if (arbol.hasRightChild())
			paresRecursivoPostOrden(lista, arbol.getRightChild());
		if (arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
	}
	
	
}
