package Practica.TP3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

import Practica.TP2.Clases.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	//Ejercicio 3
	
	public int altura() {	 
		if(!this.isEmpty())
			return alturaRecorrido(this);
		return 0;
	}
	
	private int alturaRecorrido(GeneralTree<T> arb) {
		if (arb.isLeaf())
			return 0;
		int alturaMax= 0;
		for (GeneralTree<T> child: arb.getChildren())
			alturaMax = Math.max(alturaMax, alturaRecorrido(child));
		return 1 + alturaMax;
	}
	
	public int nivel(T dato){
		int nivel = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<T> arbolAux = cola.dequeue();
			if(arbolAux != null) {
				if(arbolAux.getData().equals(dato)) 
					return nivel;
				for(GeneralTree<T> child: arbolAux.getChildren()) {
					cola.enqueue(child);
			}
		}
		else if(!cola.isEmpty()) {
			nivel ++;
			cola.enqueue(null);
		}
		}
		return 0;
	  }

	public int ancho(){
		if (this.isEmpty())
			return 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree <T>>();
		cola.enqueue(this);
		int maxNodos = 0;
		while(!cola.isEmpty()) {
			int nivelAct = cola.size();
			if(nivelAct > maxNodos)
				maxNodos = nivelAct;
			for (int i = 0; i< nivelAct; i++) {
				GeneralTree<T> arbolAux = cola.dequeue();
				for(GeneralTree<T> child: arbolAux.getChildren())
					cola.enqueue(child);
			}
		}
		return maxNodos;
	}
	
	//Ejercicio 5
	public boolean esAncestro(T a, T b) {
		if(this.isEmpty()) // Si esta vacio, da falso
			return false;
		return esAncestroAux(a,b,this); // Si no, entra en Aux
	}
	
	private GeneralTree<T> retArbol(T a, GeneralTree<T> arb){
		if(arb.getData().equals(a)) // Compara si es igual
			return arb;             // Devuelveel arbol
		for(GeneralTree<T> child : arb.getChildren()) {
			GeneralTree<T> result = retArbol(a,child); // Recorren los hijos
		if (result != null)
			return result;  //Si no esta vacio, devuelve resultado
		}
		return null;       //Si esta vacio, da vacio
	}
	
	private boolean esAncestroAux(T a, T b, GeneralTree<T> arb) {
		if(retArbol(a,arb) == null) 
			return false;  //Si esta vacio, da falso
		return recorrer(b,arb);  //Si no, recorre
	}
	
	private boolean recorrer(T b, GeneralTree<T> arb) {
		if(arb.getData().equals(b))   //Compara si es igual
			return true;              // Si lo es, da verdadero
		for(GeneralTree<T> child: arb.getChildren()) {  //Recorre los hijos
			if(recorrer(b,child))   //Si da verdadero, es porque todo esta bien
				return true;
		}
		return false;             // si no, da falso
	}
	
	
	
}