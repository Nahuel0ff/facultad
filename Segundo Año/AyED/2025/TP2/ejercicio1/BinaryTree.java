package ejercicio1;

import Clases.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	   
		return contarHojasRecursivo(this);
	}
	
	public int contarHojasRecursivo(BinaryTree<T> arbol) {
		if (arbol == null)
			return 0;
		if(arbol.isLeaf())
			return 1;
		return contarHojasRecursivo(arbol.getLeftChild()) + contarHojasRecursivo(arbol.getRightChild());
	}
		
		
    	 
    public BinaryTree<T> espejo(){
       BinaryTree<T> arbolEspejo = new BinaryTree<>(this.getData());
       if (!this.isLeaf()) {
    	   if(this.hasLeftChild())
    		   arbolEspejo.addRightChild(this.getLeftChild().espejo());
    	   if(this.hasRightChild())
    		   arbolEspejo.addLeftChild(this.getRightChild().espejo());
       }
 	   return arbolEspejo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (n > m || n < 0)
			return;
		int nivel = 0;
		Queue<BinaryTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		
		while (!cola.isEmpty()) {
			BinaryTree<T> arbol = cola.dequeue();
	   	    if (arbol != null) {
	   	    	if(nivel >= n && nivel <= m)
	   	    		System.out.print(arbol.getData()+ " ");
	   	    	if (arbol.hasLeftChild()) 
	   	    		cola.enqueue(arbol.getLeftChild());
	   	    	if (arbol.hasRightChild()) 
	   	    		cola.enqueue(arbol.getRightChild());
	   	    }
	   	    else if (!cola.isEmpty()) {
	   	    	System.out.println();
	   	    	cola.enqueue(null); 
	   	    	nivel ++;
	   	    }
		}
   }
		
}

