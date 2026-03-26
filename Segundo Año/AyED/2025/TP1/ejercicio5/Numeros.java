package ejercicio5;

public class Numeros {

	private int minimo;
	private int maximo;
	private double promedio;
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	public String toString() {
		return "Minimo: " + this.getMinimo() + "\n" + "Maximo: " + this.getMaximo() + "\n" + "Promedio: " + this.getPromedio();
	}
	
}
