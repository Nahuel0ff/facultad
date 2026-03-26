package Practica.TP3.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import Practica.TP3.ejercicio1.GeneralTree;

public class Prueba {

	public static void main(String[] args) {
		AreaEmpresa area1 = new AreaEmpresa("M", 14);
		AreaEmpresa area2 = new AreaEmpresa("J", 13);
		AreaEmpresa area3 = new AreaEmpresa("K", 25);
		AreaEmpresa area4 = new AreaEmpresa("L", 10);
		AreaEmpresa area5 = new AreaEmpresa("A", 4);
		AreaEmpresa area6 = new AreaEmpresa("B", 7);
		AreaEmpresa area7 = new AreaEmpresa("C", 5);
		AreaEmpresa area8 = new AreaEmpresa("D", 6);
		AreaEmpresa area9 = new AreaEmpresa("E", 10);
		AreaEmpresa area10 = new AreaEmpresa("F", 18);
		AreaEmpresa area11 = new AreaEmpresa("G", 9);
		AreaEmpresa area12 = new AreaEmpresa("H", 12);
		AreaEmpresa area13 = new AreaEmpresa("I", 19);
		
		GeneralTree<AreaEmpresa> a1 = new GeneralTree<>(area1); // Raíz
		GeneralTree<AreaEmpresa> a2 = new GeneralTree<>(area2); // Hijo de la raíz
		GeneralTree<AreaEmpresa> a3 = new GeneralTree<>(area3); // Hijo de la raíz
		GeneralTree<AreaEmpresa> a4 = new GeneralTree<>(area4); // Hijo de la raíz
		GeneralTree<AreaEmpresa> a5 = new GeneralTree<>(area5); // Hijo de a2
		GeneralTree<AreaEmpresa> a6 = new GeneralTree<>(area6); // Hijo de a2
		GeneralTree<AreaEmpresa> a7 = new GeneralTree<>(area7); // Hijo de a2
		GeneralTree<AreaEmpresa> a8 = new GeneralTree<>(area8); // Hijo de a3
		GeneralTree<AreaEmpresa> a9 = new GeneralTree<>(area9); // Hijo de a3
		GeneralTree<AreaEmpresa> a10 = new GeneralTree<>(area10); // Hijo de a3
		GeneralTree<AreaEmpresa> a11 = new GeneralTree<>(area11); // Hijo de a4
		GeneralTree<AreaEmpresa> a12= new GeneralTree<>(area12); // Hijo de a4
		GeneralTree<AreaEmpresa> a13 = new GeneralTree<>(area13); // Hijo de a4

	    // Agregar hijos a los nodos correspondientes
	    List<GeneralTree<AreaEmpresa>> hijosRaiz = new LinkedList<>();
		hijosRaiz.add(a2);
		hijosRaiz.add(a3);
        hijosRaiz.add(a4);
        a1.setChildren(hijosRaiz);

        List<GeneralTree<AreaEmpresa>> hijosA2 = new LinkedList<>();
        hijosA2.add(a5);
        hijosA2.add(a6);
        hijosA2.add(a7);
        a2.setChildren(hijosA2);

        List<GeneralTree<AreaEmpresa>> hijosA3 = new LinkedList<>();
        hijosA3.add(a8);
		hijosA3.add(a9);
		hijosA3.add(a10);
		a3.setChildren(hijosA3);
		    
		List<GeneralTree<AreaEmpresa>> hijosA4 = new LinkedList<>();
		hijosA3.add(a11);
		hijosA3.add(a12);
		hijosA3.add(a13);
		a4.setChildren(hijosA4);
		    
		AnalizadorArbol analizar = new AnalizadorArbol();
		System.out.println(analizar.devolverMaximoPromedio(a1));

	}

}
