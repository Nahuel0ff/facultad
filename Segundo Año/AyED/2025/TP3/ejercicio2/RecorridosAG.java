package Practica.TP3.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import Practica.TP2.Clases.Queue;
import Practica.TP3.ejercicio1.GeneralTree;

public class RecorridosAG {
	
	public List<Integer> numeroImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> resultado = new LinkedList<>();
		auxPreOrden(a,resultado,n);
		return resultado;
	}
	
	private void auxPreOrden(GeneralTree<Integer> a, List<Integer> resultado, Integer n){
		if(a.isEmpty())
			return;
		if(a.getData()% 2 != 0 && a.getData() > n) {
			resultado.add(a.getData());
		}
		for (GeneralTree<Integer>child : a.getChildren()) {
			auxPreOrden(child,resultado,n);
		}
		
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> resultado = new LinkedList<>();
		auxInOrden(a,resultado,n);
		return resultado;
	}
	
	private void auxInOrden(GeneralTree<Integer> a, List<Integer> resultado, Integer n) {
		if (a.isEmpty())
			return;
		List<GeneralTree<Integer>> hijos = a.getChildren();
		if(!hijos.isEmpty()) {
			auxInOrden(hijos.get(0),resultado,n);
		}
		if(a.getData()%2 != 0 && a.getData() > n) {
			resultado.add(a.getData());
		}
		
		for(int i = 1; i<hijos.size();i++) {
			auxInOrden(hijos.get(i),resultado,n);
		}
		
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> resultado = new LinkedList<>();
        auxPostOrden(a, resultado, n);
        return resultado;
	}
	
	private void auxPostOrden(GeneralTree<Integer> a, List<Integer> resultado, Integer n) {
		if (a.isEmpty()) 
			return;
		for(GeneralTree<Integer> child: a.getChildren()) {
			auxPostOrden(child, resultado, n);
		}
		
		if(a.getData() % 2 != 0 && a.getData() > n) {
			resultado.add(a.getData());
		}
		
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
        List<Integer> resultado = new LinkedList<>();
        if (a == null || a.isEmpty()) return resultado;

        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(a);

        while (!cola.isEmpty()) {
            GeneralTree<Integer> actual = cola.dequeue();

            if (actual.getData() % 2 != 0 && actual.getData() > n) {
                resultado.add(actual.getData());
            }

            for (GeneralTree<Integer> child : actual.getChildren()) {
                cola.enqueue(child);
            }
        }

        return resultado;
	}

	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(11, childen);
        

        
        RecorridosAG rec = new RecorridosAG();
        
        System.out.println("PREORDEN:" + rec.numeroImparesMayoresQuePreOrden(a, 0));
        System.out.println("INORDEN:" + rec.numerosImparesMayoresQueInOrden(a, 0));
        System.out.println("POSTORDEN:" + rec.numerosImparesMayoresQuePostOrden(a, 0));
        System.out.println("POR NIVELES:" + rec.numerosImparesMayoresQuePorNiveles(a, 0));

	}

}
