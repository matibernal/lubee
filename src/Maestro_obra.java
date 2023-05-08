package proyecto_sof;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Maestro_obra {
	 private List<Obrero> listaObreros = new ArrayList<>();
	private List<Plano> listaPlanos= new ArrayList<>();
	private ArrayList<proyecto_obra> listaProyectos; 
	
	private String nombre;
	private int id_empleado;
	private String contraseña;
	private String sector_trabajo;
	private int cantidadobreros;
	private String Plano;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getSector_trabajo() {
		return sector_trabajo;
	}

	public void setSector_trabajo(String sector_trabajo) {
		this.sector_trabajo = sector_trabajo;
	}

	public int getCantidadobreros() {
		return cantidadobreros;
	}

	public void setCantidadobreros(int cantidadobreros) {
		this.cantidadobreros = cantidadobreros;
	}

	public void setListaPlanos(List<Plano> listaPlanos) {
		this.listaPlanos = listaPlanos;
	}
	

	public Maestro_obra(String nombre, int id_empleado, String contraseña, String sector_trabajo, int cantidadobreros) {
		super();
		this.nombre = nombre;
		this.id_empleado = id_empleado;
		this.contraseña = contraseña;
		this.sector_trabajo = sector_trabajo;
		this.cantidadobreros = cantidadobreros;
		this.listaPlanos = listaPlanos;
	}
	
	@Override
	public String toString() {
		return "Maestro_obra [nombre=" + nombre + ", id_empleado=" + id_empleado + ", contraseña=" + contraseña
				+ ", sector_trabajo=" + sector_trabajo + "]";
	}

	public boolean Login(String nombre, String contraseña) {   //login para entrar 
		if ( contraseña.equalsIgnoreCase(this.getContraseña())) {
			return true;
		}else {
			return false;
		}
	}

	public ArrayList<Obrero> solicitarObreros(int cantidad, String nombre) {// solicitar obreros
	    ArrayList<Obrero> obrerosSolicitados = new ArrayList<>();
	    int contador = 0;

	    for (Obrero obrero : listaObreros) {
	        if (obrero.getNombre().equalsIgnoreCase(nombre) && obrero.isDisponible()) {
	            obrerosSolicitados.add(obrero);
	            obrero.setDisponible(false);
	            contador++;

	            if (contador == cantidad) {
	                break;
	            }
	        }
	    }

	    if (contador == cantidad) {
	        JOptionPane.showMessageDialog(null, "Obreros solicitados correctamente.");
	    } else {
	        JOptionPane.showMessageDialog(null, "No hay suficientes obreros disponibles para la solicitud.");
	    }

	    return obrerosSolicitados;
	}
	
	public Maestro_obra() {

	    ArrayList<String>  listaProyectos = new ArrayList<String>();
        listaProyectos.add("Alvear Tower");
        listaProyectos.add("Tower Cruz");
        listaProyectos.add("Tower Main");
        listaProyectos.add("Tower ZEIN");
        listaProyectos.add("Tower Home");
    }
	public ArrayList<proyecto_obra> getListaProyectos() {
        return listaProyectos;
    }
	
	public void visualizarProyectos() {
        String detallesProyectos = "";
        for (proyecto_obra proyecto : listaProyectos) {
            detallesProyectos += "id_obra: " + proyecto.getId_obra() + "\n" +
                    "Obreros: " + proyecto.getObreros() + "\n" ;
        }
        JOptionPane.showMessageDialog(null, detallesProyectos);
    }

	

}
