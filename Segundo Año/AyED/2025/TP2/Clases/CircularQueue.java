package Clases;

public class CircularQueue<T> extends Queue<T> {

	public T shift() {
		T elemento = (T) this.data.get(0);
		dequeue();
		enqueue(elemento);
		return elemento;
	}
	
}
