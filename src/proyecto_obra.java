
import java.util.ArrayList;
import java.util.LinkedList;

public class proyecto_obra {
	//ArrayList obreros = new ArrayList();
	private String nombre;
    private String ubicacion;
	private int id_obra;
	private boolean habilitado;
	private LinkedList<proyecto_obra> ObrerosenObra;
	private LinkedList<proyecto_obra> listaProyectos;


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


	public proyecto_obra(int id_obra, boolean habilitado, String nombre, String ubicacion) {
		super();
		this.id_obra = id_obra;
		this.habilitado = habilitado;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

    }

	@Override
	public String toString() {
		return "proyecto_obra [id_obra=" + id_obra + ", habilitado="
				+ habilitado + "]";
	}


}
