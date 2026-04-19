package final6;

public class Empleado {
	private String nombre;
	private String apellido;
	private int antiguedad;
	
	public Empleado (String nom, String ape, int ant) {
		this.nombre = nom;
		this.apellido = ape;
		this.antiguedad = ant;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", antiguedad=" + antiguedad;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	
	
}
