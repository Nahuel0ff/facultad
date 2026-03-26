package Practica.TP3.ejercicio7;

import java.util.LinkedList;
import java.util.List;

import Practica.TP3.ejercicio1.GeneralTree;

public class Caminos {
	
	private GeneralTree<Integer> ab;
	
	public Caminos(GeneralTree<Integer> ab) {
		this.ab = ab;
	}
	
	public List<Integer> caminoAHojaMasLejana () {
		List<Integer> act = new LinkedList<Integer>();
		List<Integer> max = new LinkedList<Integer>();
		if (!ab.isEmpty())
			aux(ab, act, max);
		return max;
	}
	
	private void aux(GeneralTree<Integer> ab, List<Integer> act, List<Integer> max) {
		act.add(ab.getData());
		if (!ab.isLeaf()) {
			for (GeneralTree<Integer> child : ab.getChildren()) {
				aux(child, act, max);
			}
		} else {
			if (act.size() > max.size()) {
				max.clear();
				max.addAll(act);
			}
		}
		act.remove(act.size() - 1);
	}
	
	public static void main(String[] args) {
		// Subárbol izquierdo
		GeneralTree<Integer> nodo1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> hijos6 = new LinkedList<>();
		hijos6.add(nodo1);
		GeneralTree<Integer> nodo6 = new GeneralTree<Integer>(6, hijos6);
		
		List<GeneralTree<Integer>> hijos17 = new LinkedList<>();
		hijos17.add(new GeneralTree<Integer>(10));
		hijos17.add(nodo6);
		GeneralTree<Integer> nodo17 = new GeneralTree<Integer>(17, hijos17);
		
		// Subárbol central
		GeneralTree<Integer> nodo8 = new GeneralTree<Integer>(8);
		List<GeneralTree<Integer>> hijos9 = new LinkedList<>();
		hijos9.add(nodo8);
		GeneralTree<Integer> nodo9 = new GeneralTree<Integer>(9, hijos9);
		
		// Subárbol derecho
		GeneralTree<Integer> nodo16 = new GeneralTree<Integer>(16);
		GeneralTree<Integer> nodo7 = new GeneralTree<Integer>(7);
		List<GeneralTree<Integer>> hijos14 = new LinkedList<>();
		hijos14.add(nodo16);
		hijos14.add(nodo7);
		GeneralTree<Integer> nodo14 = new GeneralTree<Integer>(14, hijos14);
		
		List<GeneralTree<Integer>> hijos15 = new LinkedList<>();
		hijos15.add(nodo14);
		hijos15.add(new GeneralTree<Integer>(18));
		GeneralTree<Integer> nodo15 = new GeneralTree<Integer>(15, hijos15);
		
		// Raíz
		List<GeneralTree<Integer>> hijos12 = new LinkedList<>();
		hijos12.add(nodo17);
		hijos12.add(nodo9);
		hijos12.add(nodo15);
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(12, hijos12);
		
		// Instanciar Caminos y mostrar resultado
		Caminos cam = new Caminos(raiz);
		System.out.println("Camino a hoja más lejana: " + cam.caminoAHojaMasLejana());
	}
}
