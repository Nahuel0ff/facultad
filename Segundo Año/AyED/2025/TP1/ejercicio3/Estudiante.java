package ejercicio3;

public class Estudiante extends Persona {
	
	private String comision;
	private String direccion;

	public Estudiante(String nom, String ape, String mail,String comi, String dir) {
		super(nom, ape, mail);
		this.setComision(comi);
		this.setDireccion(dir);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String dir) {
		this.direccion = dir;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comi) {
		this.comision = comi;
	}

	public String toString() {
		String aux = super.toString();
		return aux + "Comision: " + this.getComision() + "\n" + "Direccion: " + this.getDireccion() + "\n";
	}
	
}
