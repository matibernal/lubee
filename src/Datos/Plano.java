package Datos;

import Interfaces.Interfaces;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;


public class Plano { //implementarle interfaz
	private int id_plano;
	private String nombre;
	private int id_maestro;
	private int id_cliente;
	Maestro_obra maestro;
	Cliente cliente;
	LinkedList<Plano> listaPlanos;

	Conexion con = new Conexion();
	Connection conexion = con.conectar();
	PreparedStatement stmt;
	
	public String getNombre() {
		return nombre;
	}
	public int getId_plano() {
		return id_plano;
	}
	public void setId_plano(int id_plano) {
		this.id_plano = id_plano;
	}
	public void setNombre(String nombre) {
		nombre = nombre;
	}
	public int getId_maestro() {
		return id_maestro;
	}
	public void setId_maestro(int id_maestro) {
		this.id_maestro = id_maestro;
	}

	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	
	
	public Plano(int id_plano, String nombre, int id_maestro, int id_cliente) {
		super();
		this.id_plano = id_plano;
		this.nombre = nombre;
		this.id_maestro = id_maestro;
		this.id_cliente = id_cliente;
	}
	

	@Override
	public String toString() {
		return "Datos.Plano [id_plano=" + ", Nombre=" + nombre + "]";
	}
	
	public boolean Agregar() {
		String sql ="INSERT INTO `plano`(`idplano`, `nombre`, `id_maestro`, `id_cliente`) VALUES (?,?,?,?)";

		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.getId_plano());
			stmt.setString(2, this.getNombre());
			stmt.setInt(3, this.getId_maestro());
			stmt.setInt(4, this.getId_cliente());
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}

	}
	
	/*
	public boolean Eliminar(int id) {

		String sql ="DELETE FROM `plano` WHERE idplano = ?";

		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id_plano);
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}



	}

	 */
	/*
		public Datos.Plano buscarPlano() {

	    for (Datos.Plano p : listaPlanos) {
	        if (p.getId_plano() == idPlano) {
	            return p;
	        }
	    }
	    return null;


		}
	
		public static List<Datos.Plano> realizarPlano2() {
        List<Datos.Plano> listaPlanos = new ArrayList<>();
        listaPlanos.add(new Datos.Plano(1, "Datos.Plano 1", "Datos.Cliente 1"));
        listaPlanos.add(new Datos.Plano(2, "Datos.Plano 2", "Datos.Cliente 2"));
        listaPlanos.add(new Datos.Plano(3, "Datos.Plano 3", "Datos.Cliente 3"));
        listaPlanos.add(new Datos.Plano(4, "Datos.Plano 4", "Datos.Cliente 4"));
        listaPlanos.add(new Datos.Plano(5, "Datos.Plano 5", "Datos.Cliente 5"));
        return listaPlanos;
    	}

		 */
	
	
}

