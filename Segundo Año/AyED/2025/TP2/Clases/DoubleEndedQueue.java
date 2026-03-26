package Clases;

public class DoubleEndedQueue<T> extends Queue<T> {

	public void enqueueFirst(T elemento) {
		getQueue().add(0,elemento);
	}
}
