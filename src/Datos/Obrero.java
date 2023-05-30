package Datos;

import javax.swing.*;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Interfaces.*;

public class Obrero implements Interfaces {
	private int idobrero;
	private String nombre; // Atributo que identifica el nombre de una persona
	private String apellidos; /* Atributo que identifica los apellidos de una persona */
	private boolean disponible;
	private int id_obra=0;
	proyecto_obra obra;



	public int getiIdobrero() {
		return idobrero;
	}
	public void setIdobrero (int idobrero) {
		this.idobrero = idobrero;
	}

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
	public int getId_obra() {
		return id_obra;
	}
	public void setId_obra(int id_obra) {
		this.id_obra = id_obra;
	}

	Conexion con = new Conexion();
	Connection conexion = con.conectar();
	PreparedStatement stmt;
	
	public Obrero(int idobrero,String nombre, String apellidos, boolean disponible, int id_obra) {
		super();
		this.idobrero = idobrero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.disponible = disponible;
		this.id_obra = id_obra;
	}

	@Override
	public String toString() {
		return "Obrero [nombre=" + nombre + ", apellidos=" + apellidos + ", disponible=" + disponible + "]";
	}

	public boolean Agregar() {

		String sql ="INSERT INTO `obrero`(`idobrero`,`nombre`, `apellido`, `disponible`, `id_obra`) VALUES (?,?,?,?,?)";

		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.getiIdobrero());
			stmt.setString(2, this.getNombre());
			stmt.setString(3, this.getApellidos());
			stmt.setBoolean(4, this.isDisponible());
			stmt.setInt(5, this.getId_obra());
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}
	}



	public LinkedList<Obrero> Mostrar() {

		LinkedList<Obrero> listaObreros = new LinkedList<Obrero>();

		String sql ="SELECT * FROM `obrero`";

		String[] datos = new String[5];
		try {

			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				datos[0]= String.valueOf(result.getInt(1));
				datos[1]= result.getString(2);
				datos[2]= result.getString(3);
				datos[3]= String.valueOf(result.getBoolean(4));
				datos[4]= String.valueOf(result.getInt(5));
				listaObreros.add(new Obrero(Integer.parseInt(datos[0]),datos[1],datos[2],Boolean.parseBoolean(datos[3]) ,Integer.parseInt(datos[4])));
			}

			return listaObreros;
			//JOptionPane.showMessageDialog(null, "Lista de obreros: " + listaObreros);

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return null;
		}

	}


/*
	public LinkedList<Object> Mostrar() {
		String sql ="SELECT * FROM `obrero`";

		String[] datos = new String[5];
		try {

			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				datos[0]= String.valueOf(result.getInt(1));
				datos[1]= result.getString(2);
				datos[2]= result.getString(3);
				datos[3]= String.valueOf(result.getBoolean(4));
				datos[4]= String.valueOf(result.getInt(5));
				listaObreros.add(new Obrero(Integer.parseInt(datos[0]),datos[1],datos[2],Boolean.parseBoolean(datos[3]) ,Integer.parseInt(datos[4])));
			}

			return listaObreros;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return null;
		}

	}

 */


	public boolean Eliminar(int idobrero) {

		String sql ="DELETE FROM `obrero` WHERE idobrero = ?";

		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idobrero);
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}
	}
/*
	public boolean EditarPersona(int idobrero) {

		String sql ="UPDATE `obrero` SET `idobrero`='?',`nombre`='?',`apellido`='?',`disponible`='?',`id_obra`='?' WHERE idobra = '?'";

		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.getiIdobrero());
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}
	}

 */




/*
	public void AgregarObrero(){
		String nombrei, apellidoi, seguiragregando="";
		boolean dispi;
		int i;

		Obrero obrero1 = new Obrero(idobrero,"Franco","Perez", true, 0);
		Obrero obrero2 = new Obrero(idobrero,"Macarena","Diaz", true, 0);

		listaObreros.add(obrero1);
		listaObreros.add(obrero2);

		do {
			for (i=1; i<=30; i++) {

				Obrero obrero = new Obrero(idobrero, nombre,apellidos, true, 0);

				JOptionPane.showMessageDialog(null, "Usted ingreso a la sesion de agregar obreros");
				nombrei=JOptionPane.showInputDialog("Digite el nombre del obrero");
				setNombre(nombrei);
				apellidoi=JOptionPane.showInputDialog("Digite el apellido del obrero");
				setApellidos(apellidoi);
				setDisponible(true);

				JOptionPane.showMessageDialog(null,"Agregado con exito!");

				listaObreros.add(obrero);

				seguiragregando=JOptionPane.showInputDialog("Desea agregar otra obrero?");
				if (seguiragregando.equalsIgnoreCase("no")) {
					i=30;
				}
			}
		} while (seguiragregando.equalsIgnoreCase("si"));

	}

	public void VerObreros() {
		JOptionPane.showMessageDialog(null, listaObreros);
	}



	public void BuscarObrero(){
		String nombrei, apellidoi;
		int idingre;

		Obrero obrero = new Obrero(idobrero,"","", true, 0);

		nombrei= JOptionPane.showInputDialog("Ingrese el nombre del obrero");
		apellidoi= JOptionPane.showInputDialog("Ingrese el apellido del obrero");

		for (int i=0 ;  i < listaObreros.size() ; i++ ) {
			if (listaObreros.get(i).getNombre().equalsIgnoreCase(nombrei)) {
				if (listaObreros.get(i).getApellidos().equalsIgnoreCase(apellidoi)){

					JOptionPane.showMessageDialog(null, "Datos.Obrero encontrado!");
					JOptionPane.showMessageDialog(null, "Nombre: " + listaObreros.get(i).getNombre() );
					JOptionPane.showMessageDialog(null, "Apellido: " + listaObreros.get(i).getApellidos() );

				} else {
					JOptionPane.showMessageDialog(null, "El apellido ingresado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre ingresado no existe");
			}
		}
	}


	public void AsignarObrero(proyecto_obra obra, LinkedList<proyecto_obra> listaProyectos, LinkedList<proyecto_obra> ObrerosenObra ) {
		String nombrei, apellidoi;
		int idingre;

		Obrero obrero = new Obrero(idobrero, nombre,apellidos, true, 0);

		nombrei= JOptionPane.showInputDialog("Ingrese el nombre del obrero");
		apellidoi= JOptionPane.showInputDialog("Ingrese el apellido del obrero");

		for (int i=0 ;  i < listaObreros.size() ; i++ ) {
			if (listaObreros.get(i).getNombre().equalsIgnoreCase(nombrei)) {
				if (listaObreros.get(i).getApellidos().equalsIgnoreCase(apellidoi)){
					JOptionPane.showMessageDialog(null, "Datos.Obrero encontrado!");
					idingre=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la obra a asignar obrero"));
					if (listaProyectos.get(i).getId_obra()==idingre) {
						obrero.setId_obra(idingre); //le cambio el id de la obra al obrero
						JOptionPane.showMessageDialog(null, getNombre() + " fue asignado con exito al id de obra numero: " + idingre);
					} else {
						JOptionPane.showMessageDialog(null,"La obra no se encontro");
					}

				} else {
					JOptionPane.showMessageDialog(null, "El apellido ingresado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre ingresado no existe");
			}
		}

	}

 */





}
