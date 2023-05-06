package proyecto_sof;

public class Obrero {
	private String nombre; // Atributo que identifica el nombre de una persona
	private String apellidos; /* Atributo que identifica los apellidos de una persona */
	private boolean disponible;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public Obrero(String nombre, String apellidos, boolean disponible) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.disponible = disponible;
	}
	@Override
	public String toString() {
		return "Obrero [nombre=" + nombre + ", apellidos=" + apellidos + ", disponible=" + disponible + "]";
	}
	


}
