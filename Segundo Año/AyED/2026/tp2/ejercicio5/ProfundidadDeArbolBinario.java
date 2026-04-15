package tp2.ejercicio5;

import tp1.ejercicio1.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
 private BinaryTree<Integer> arbol;
 
 public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
     this.arbol = arbol;
 }

 	public int sumaElementosProfundidad(int p) {
 		int suma = 0;
     
     if (this.arbol != null && !this.arbol.isEmpty()) {
         Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
         int profundidadActual = 0;
         
         cola.enqueue(this.arbol);
         cola.enqueue(null);
         
         while (!cola.isEmpty()) {
             BinaryTree<Integer> ab = cola.dequeue();
             
             if (ab != null) {
                 if (profundidadActual == p) {
                     suma += ab.getData();
                 } 
                 else if (profundidadActual < p) {
                     if (ab.hasLeftChild()) {
                         cola.enqueue(ab.getLeftChild());
                     }
                     if (ab.hasRightChild()) {
                         cola.enqueue(ab.getRightChild());
                     }
                 }
             } else if (!cola.isEmpty()) {
                 profundidadActual++;
                 cola.enqueue(null);
                 
                 if (profundidadActual > p) {
                     break; 
                 }
             }
         }
     }
     
     return suma;
 }
}
