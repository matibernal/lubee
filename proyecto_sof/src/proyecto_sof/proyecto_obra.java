package proyecto_sof;

import java.util.ArrayList;

public class proyecto_obra {
	ArrayList obreros = new ArrayList();
	private String nombre;
    private String ubicacion;
	private int id_obra;
	private boolean habilitado;
	
	
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public int getId_obra() {
		return id_obra;
	}
	public void setId_obra(int id_obra) {
		this.id_obra = id_obra;
	}
	
	public ArrayList getObreros() {
		return obreros;
	}
	public void setObreros(ArrayList obreros) {
		this.obreros = obreros;
	}
	
	
	public proyecto_obra(int id_obra, ArrayList maquinas, ArrayList obreros, boolean habilitado) {
		super();
		this.id_obra = id_obra;
		this.obreros = obreros;
		this.habilitado = habilitado;
	}
	
	public proyecto_obra(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
	@Override
	public String toString() {
		return "proyecto_obra [id_obra=" + id_obra + ", obreros=" + obreros + ", habilitado="
				+ habilitado + "]";
	}
	 
}
