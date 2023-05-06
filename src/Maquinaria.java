package proyecto_sof;

public class Maquinaria {
	
	private String tipo;
	private boolean Disponible;
	private String patente;
	private int CantidadDisponible;
	
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isDisponible() {
		return Disponible;
	}
	public void setDisponible(boolean disponible) {
		Disponible = disponible;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}

	
	public int getCantidadDisponible() {
		return CantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		CantidadDisponible = cantidadDisponible;
	}
	
	
	public Maquinaria(String tipo, boolean disponible, String patente, int cantidadDisponible) {
		super();
		this.tipo = tipo;
		Disponible = disponible;
		this.patente = patente;
		CantidadDisponible = cantidadDisponible;
	}
	
	@Override
	public String toString() {
		return "Maquinaria [tipo=" + tipo + ", Disponible=" + Disponible + ", patente=" + patente
				+ ", CantidadDisponible=" + CantidadDisponible + "]";
	}

	


}
