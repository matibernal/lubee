package Datos;

import Interfaces.Interfaces;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class Maquinaria implements Interfaces {
	private int idmaquinaria;
	private String tipo;
	private boolean disponible;
	private String patente;
	private int cantidadDisponible;
	private LinkedList<Maquinaria> listaMaquinarias;


	public int getIdmaquinaria() {
		return idmaquinaria;
	}
	public void setIdmaquinaria(int idmaquinaria) {
		idmaquinaria = idmaquinaria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		disponible = disponible;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}

	
	public int getCantidadDisponible() {
		return cantidadDisponible;
	}
	public void setCantidadDisponible(int cantidadDisponible) {
		cantidadDisponible = cantidadDisponible;
	}
	
	
	public Maquinaria(int idmaquinaria, String tipo, boolean disponible, String patente, int cantidadDisponible) {
		super();
		this.idmaquinaria = idmaquinaria;
		this.tipo = tipo;
		this.disponible = disponible;
		this.patente = patente;
		this.cantidadDisponible = cantidadDisponible;
	}

	Conexion con = new Conexion();
	Connection conexion = con.conectar();
	PreparedStatement stmt;
	
	@Override
	public String toString() {
		return "Maquinarias \n Id: " + idmaquinaria + " Tipo: " + tipo + ", Disponible: " + disponible + ", patente: " + patente
				+ ", CantidadDisponible: " + cantidadDisponible ;
	}


	public boolean Agregar(){

		String sql ="INSERT INTO `maquinaria`(`idmaquinaria`, `tipo`, `disponible`, `patente`, `cantidad`) VALUES (?,?,?,?,?)";

		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, this.getIdmaquinaria());
			stmt.setString(2, this.getTipo());
			stmt.setBoolean(3, this.isDisponible());
			stmt.setString(4, this.getPatente());
			stmt.setInt(5, this.getCantidadDisponible());
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}


	}

	public boolean Eliminar(int idmaquinaria) {

		String sql ="DELETE FROM `maquinaria` WHERE idmaquinaria = ?";

		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idmaquinaria);
			stmt.executeUpdate();
			return true;

		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
			return false;
		}
	}

	/*
	public void AgregarMaquinaria() {
		String tipoi, patentei, seguiragregando="";
		boolean dispi;
		int cantidaddispi;
		String nombre;
		int i;


		do {
			for (i=1; i<=30; i++) {

		Maquinaria maquinarian = new Maquinaria ("",false,"",0);

		JOptionPane.showMessageDialog(null, "Usted ingreso a la sesion de agregar maquinari");
		tipoi=JOptionPane.showInputDialog("Ingrese el tipo de la maquina");
		setTipo(tipoi);
		patentei=JOptionPane.showInputDialog("Ingrese la patente de la maquina");
		setPatente(patentei);
		setDisponible(true);
		cantidaddispi=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que ingresa"));
		setCantidadDisponible(getCantidadDisponible() + cantidaddispi);

		JOptionPane.showMessageDialog(null,"Agregado con exito!");

		listaMaquinarias.add(maquinarian);

		seguiragregando=JOptionPane.showInputDialog("Desea agregar otra maquinaria?");
		if (seguiragregando.equalsIgnoreCase("no")) {
				i=30;
			}

			}

		} while (seguiragregando.equalsIgnoreCase("si"));

	}

	 */

	public void solicitarMaquinarias() {
		int cantidadi;
		String tipoi, patentei;
		LinkedList<Maquinaria> maquinariasSolicitadas = new LinkedList<>();
		int pos=-1;

		tipoi=JOptionPane.showInputDialog("Ingrese el tipo de la maquina");
		patentei=JOptionPane.showInputDialog("Ingrese la patente de la maquina");
		cantidadi=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que desea"));

		//falta do while para que se repita

		for (int i=0 ;  i < listaMaquinarias.size() ; i++ ) {
			if (listaMaquinarias.get(i).getTipo().equalsIgnoreCase(tipoi)) {
				if (listaMaquinarias.get(i).getPatente().equalsIgnoreCase(patentei)){
					if (listaMaquinarias.get(i).getCantidadDisponible() > cantidadi ) {
						if (listaMaquinarias.get(i).isDisponible()){
							JOptionPane.showMessageDialog(null, "Maquinarias solicitadas correctamente.");
							maquinariasSolicitadas.add(listaMaquinarias.get(i));
							setDisponible(false);
							setCantidadDisponible(getCantidadDisponible() - cantidadi);
						} else {
							JOptionPane.showMessageDialog(null, "La maquina no esta disponible");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No hay la cantidad suficiente de esa maquina");
					}
				} else {
					JOptionPane.showMessageDialog(null, "La patente ingresada no existe");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El tipo ingresado no existe");
			}
		}

		JOptionPane.showMessageDialog(null, "Los materiales solicitados son: " + maquinariasSolicitadas);

	}



}
