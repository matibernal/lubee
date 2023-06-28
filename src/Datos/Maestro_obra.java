package Datos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Maestro_obra {

	// private List<Datos.Plano> listaPlanos= new ArrayList<>();
	
	private String nombre;
	private int id_empleado;
	private String contrasena;
	private String sector_trabajo;
	//private int cantidadobreros;
	//private String Datos.Plano;
	

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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getSector_trabajo() {
		return sector_trabajo;
	}
	public void setSector_trabajo(String sector_trabajo) {
		this.sector_trabajo = sector_trabajo;
	}
	

	public Maestro_obra(String nombre, int id_empleado, String contrasena, String sector_trabajo, int cantidadobreros) {
		super();
		this.nombre = nombre;
		this.id_empleado = id_empleado;
		this.contrasena = contrasena;
		this.sector_trabajo = sector_trabajo;
		//this.cantidadobreros = cantidadobreros;
	}
	
	@Override
	public String toString() {
		return "Datos.Maestro_obra [nombre=" + nombre + ", id_empleado=" + id_empleado + ", contrase�a=" + contrasena
				+ ", sector_trabajo=" + sector_trabajo + "]";
	}

	public boolean Login(String nombre, String contrasena) {//login para entrar
		if ( contrasena.equalsIgnoreCase(this.getContrasena())) {
			return true;
		}else {
			return false;
		}
	}

	/*
	public ArrayList<Datos.Obrero> solicitarObreros(int cantidad, String nombre) {// solicitar obreros
	    ArrayList<Datos.Obrero> obrerosSolicitados = new ArrayList<>();
	    int contador = 0;

	    for (Datos.Obrero obrero : listaObreros) {
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


	public Datos.Maestro_obra() {

	    ArrayList<String>  listaProyectos = new ArrayList<String>();
        listaProyectos.add("Alvear Tower");
        listaProyectos.add("Tower Cruz");
        listaProyectos.add("Tower Interfaz.Main");
        listaProyectos.add("Tower ZEIN");
        listaProyectos.add("Tower Home");
    }

	public ArrayList<Datos.proyecto_obra> getListaProyectos() {
        return listaProyectos;
    }
	
	public void visualizarProyectos() {
        String detallesProyectos = "";
        for (Datos.proyecto_obra proyecto : listaProyectos) {
            detallesProyectos += "id_obra: " + proyecto.getId_obra() + "\n" +
                    "Obreros: " + proyecto.getObreros() + "\n" ;
        }
        JOptionPane.showMessageDialog(null, detallesProyectos);
    }
*/

	

}
