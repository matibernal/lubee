import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Maestro_obra {
	private String nombre;
	private int id_empleado;
	private String contraseña;
	private String sector_trabajo;
	private int cantidadobreros;
	private String Plano;
	private ArrayList<String> materiales;


	public Maestro_obra() {
		materiales = new ArrayList<>();
		materiales.add("Ladrillos");
		materiales.add("Cemento");
		materiales.add("Hierro");
		materiales.add("Acero");
		materiales.add("Madera");
		materiales.add("yeso");
		materiales.add("Arena");
		materiales.add("Hormigon");
		materiales.add("Camion");
		materiales.add("Motoniveladoras");
		materiales.add("Tractores Topadores");
		materiales.add("Excavadora");
		materiales.add("Pala cargadora");
		materiales.add("Volquete");
		materiales.add("Hormigonera");
	}

	private Maestro_obra maestro_obra;


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

	public String getPlano() {
		return Plano;
	}

	public void setPlano(String plano) {
		Plano = plano;
	}

	public ArrayList<String> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<String> materiales) {
		this.materiales = materiales;
	}


	public Maestro_obra(String nombre, int id_empleado, String contraseña, String sector_trabajo, int cantidadobreros,
						String plano) {
		super();
		this.nombre = nombre;
		this.id_empleado = id_empleado;
		this.contraseña = contraseña;
		this.sector_trabajo = sector_trabajo;
		this.cantidadobreros = cantidadobreros;
		Plano = plano;
	}


	@Override
	public String toString() {
		return "Maestro_obra [nombre=" + nombre + ", id_empleado=" + id_empleado + ", contraseña=" + contraseña
				+ ", sector_trabajo=" + sector_trabajo + ", cantidadobreros=" + cantidadobreros + ", Plano=" + Plano
				+ "]";
	}


	public boolean Login(String nombre, String contraseña) {   //login para entrar
		if ( contraseña.equalsIgnoreCase(this.getContraseña())) {
			return true;
		}else {
			return false;
		}
	}

	public void solicitarMateriales() {

		String input = JOptionPane.showInputDialog(null, "Ingrese los materiales que necesita separados por coma:");
		String[] materialesSolicitados = input.split(",");

		StringBuilder mensaje = new StringBuilder("Solicitud de materiales:\n");
		boolean hayEnStock = true;

		for (String material : materialesSolicitados) {
			if (materiales.contains(material.trim())) {
				mensaje.append("- ").append(material.trim()).append(": En stock\n");
			} else {
				mensaje.append("- ").append(material.trim()).append(": No hay en stock\n");
				hayEnStock = false;
			}
		}
		if (hayEnStock) {
			mensaje.append("\nTodos los materiales están en stock.");
		} else {
			mensaje.append("\nNo todos los materiales están en stock.");
		}

		JOptionPane.showMessageDialog(null, mensaje.toString(), "Solicitud de materiales", JOptionPane.INFORMATION_MESSAGE);

	}

	

}
