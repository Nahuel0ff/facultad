package ejercicio3;

public abstract class Persona {
	
	protected String nombre;
	protected String apellido;
	protected String email;

	public Persona(String nom, String ape, String mail) {
		this.nombre = nom;
		this.apellido = ape;
		this.email = mail;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	public void setApellido(String ape) {
		this.apellido = ape;
	}
	
	public void setEmail(String mail) {
		this.email = mail;
	}
	
	public String toString() {
		return "Nombre: " + this.getNombre() + "\n" + "Apellido: " + this.getApellido() + "\n" + "Email: " + this.getEmail() + "\n";
	}
	
}
