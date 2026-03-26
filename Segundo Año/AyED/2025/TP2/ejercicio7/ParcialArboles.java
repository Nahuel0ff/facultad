package Practica.TP2.ejercicio7;

import Practica.TP2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	private BinaryTree<Integer> arbol;
	
	//Constructor
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol= arbol;
	}
	
	public BinaryTree<Integer>getArbol(){
		return arbol;
	}
	
	private int contarUnicoHijo(BinaryTree<Integer> ar) {
		int cant = 0;
		if(ar.hasLeftChild())                                //Si tiene hijo Izq
			cant += contarUnicoHijo(ar.getLeftChild());      //Suma
		if(ar.hasRightChild())                               //Si tiene hijo Der
			cant += contarUnicoHijo(ar.getRightChild());     // Suma
		if( (ar.hasLeftChild()&& !ar.hasRightChild()) || (!ar.hasLeftChild() && ar.hasRightChild())) 
			cant++;                                          //Si tiene uno pero no otro, suma
		return cant;                                         //Devuelve cantidad
	} 
	
	
	private boolean isLeftTree(BinaryTree<Integer> ar) {
		int ramaIzq = -1;
		int ramaDer = -1;
		if (ar.hasLeftChild())                             //Si tiene hijo Izq
			ramaIzq = contarUnicoHijo(ar.getLeftChild());  //Se le asigna lado Izq
		if(ar.hasRightChild())                             //Si tiene hijo Der
			ramaDer = contarUnicoHijo(ar.getRightChild()); //Se le asigna lado Der
		return ramaIzq > ramaDer;                          //True si el lado Izq es mayor
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> ab, int num){
		if(ab.getData() == num) 
			return ab;                                        //Devuelve el arbol
		BinaryTree<Integer> res = new BinaryTree<Integer>();  //Se crea un nuevo arbol
		if(ab.hasLeftChild())                                 //Si tiene hijo izq
			res = buscar(ab.getLeftChild(),num);              //Res tiene la data
		if((ab.hasRightChild())&& (res.isEmpty()))            //Si tiene hijo Der
			res = buscar(ab.getRightChild(),num);             //Res tiene la data
		return res;                                           //Devuelve Res
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> arb = buscar(arbol,num);          //
		return(!arb.isEmpty()) ? isLeftTree(arb) : false;
	}
	
}
