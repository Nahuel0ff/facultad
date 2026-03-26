package ejercicio3;

public class Profesor extends Persona {
	
	private String catedra;
	private String facultad;

	public Profesor(String nom, String ape, String mail,String cat,String fac) {
		super(nom, ape, mail);
		this.catedra = cat;
		this.facultad = fac;
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String cat) {
		this.catedra = cat;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String fac) {
		this.facultad = fac;
	}
	
	public String toString() {
		String aux = super.toString();
		return aux + "Catedra: " + this.getCatedra() + "\n" + "Facultad: " + this.getFacultad() + "\n";
	}

}
