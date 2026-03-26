package Clases;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> extends Sequence {
	
	protected List<T> data;

	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	public void enqueue(T dato) {
		this.data.add(dato);
	}
	public T dequeue() {
		return this.data.remove(0);
	}
	
	public T head() {
		return this.data.get(0);
	}
	
	public boolean isEmpty() {
		if(this.data.size() < 1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return this.data.size();
	}
	
	public List<T> getQueue(){
		return this.data;
	}
	
	public String toString() {
		return this.data.toString();
	}
}
