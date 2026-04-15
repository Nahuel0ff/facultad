package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num) {
        if (this.arbol == null || this.arbol.isEmpty())
        	return false;
        BinaryTree<Integer> subArbolNum = buscarNodo(this.arbol, num);
       
        if (subArbolNum == null) 
        	return false;
        int cantIzq = subArbolNum.hasLeftChild() ? contarHijosUnicos(subArbolNum.getLeftChild()) : -1;
        int cantDer = subArbolNum.hasRightChild() ? contarHijosUnicos(subArbolNum.getRightChild()) : -1;

        return cantIzq > cantDer;
    }

    private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> ab, int num) {
        if (ab.getData() == num)
        	return ab;
        BinaryTree<Integer> res = null;
        if (ab.hasLeftChild()) res = buscarNodo(ab.getLeftChild(), num);
        if (res == null && ab.hasRightChild()) res = buscarNodo(ab.getRightChild(), num);
        return res;
    }

    private int contarHijosUnicos(BinaryTree<Integer> ab) {
        int count = 0;
        if (ab.hasLeftChild() ^ ab.hasRightChild()) {
            count = 1;
        }
        if (ab.hasLeftChild()) count += contarHijosUnicos(ab.getLeftChild());
        if (ab.hasRightChild()) count += contarHijosUnicos(ab.getRightChild());
        return count;
    }
}