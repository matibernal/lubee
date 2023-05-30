package Datos;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Materiales {
		private String nom;
		private int id, cantidaddisp;
		private double precio;
		private boolean disp;
		private LinkedList<Materiales> listaMateriales;

	public Materiales(String nombre, int id, int cantidaddisp, double precio, boolean disp) {
		this.nom = nom;
		this.id = id;
		this.cantidaddisp = cantidaddisp;
		this.precio = precio;
		this.disp = disp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidaddisp() {
		return cantidaddisp;
	}

	public void setCantidaddisp(int cantidaddisp) {
		this.cantidaddisp = cantidaddisp;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	@Override
	public String toString() {
		return "Datos.Materiales{" +
				"nombre='" + nom + '\'' +
				", id=" + id +
				", cantidaddisp=" + cantidaddisp +
				", precio=" + precio +
				", disponible=" + disp +
				", listaMateriales=" + listaMateriales +
				'}';
	}


	public void AgregarMateriales() {
		String nombrei, seguiragregando="";
		boolean dispi;
		int cantidaddispi, idi;
		double precioi;
		int i;


		do {
			for (i=1; i<=30; i++) {

				Materiales material = new Materiales ("",0,0,0, true);

				JOptionPane.showMessageDialog(null, "Usted ingreso a la sesion de agregar materiales");

				nombrei=JOptionPane.showInputDialog("Digite la cantidad que ingresa");
				setNom(nombrei);
				idi=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que ingresa"));
				setId(idi);
				precioi=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio"));
				setPrecio(precioi);
				setDisp(true);
				cantidaddispi=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que ingresa"));
				setCantidaddisp(getCantidaddisp() + cantidaddispi);

				JOptionPane.showMessageDialog(null,"Agregado con exito!");

				listaMateriales.add(material);

				seguiragregando=JOptionPane.showInputDialog("Desea agregar otra maquinaria?");
				if (seguiragregando.equalsIgnoreCase("no")) {
					i=30;
				}

			}

		} while (seguiragregando.equalsIgnoreCase("si"));

	}


	public void SolicitarMateriales() {
		int cantidadi, idi;
		String nombrei;
		double precioi;
		LinkedList<Materiales> materialesSolicitados = new LinkedList<>();
		int pos=-1;

		nombrei=JOptionPane.showInputDialog("Ingrese el nombre del material");
		idi=Integer.parseInt(JOptionPane.showInputDialog("Digite el id del material"));
		precioi=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio"));
		cantidadi=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que desea"));

		//falta do while para que se repita

		for (int i=0 ;  i < listaMateriales.size() ; i++ ) {
			if (listaMateriales.get(i).getNom().equalsIgnoreCase(nombrei)) {
				if (listaMateriales.get(i).getId()==idi){
					if (listaMateriales.get(i).getCantidaddisp() >= cantidadi ) {
						if (listaMateriales.get(i).getPrecio()==precioi){
							if (listaMateriales.get(i).isDisp()){
								JOptionPane.showMessageDialog(null, "Maquinarias solicitadas correctamente.");
								materialesSolicitados.add(listaMateriales.get(i));
								setDisp(false);
								setCantidaddisp(getCantidaddisp() - cantidadi);
							} else {
								JOptionPane.showMessageDialog(null, "La maquina no esta disponible");
							}
						} else {
							JOptionPane.showMessageDialog(null, "El precio no coincide con el de una maquina");
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

		JOptionPane.showMessageDialog(null, "Los materiales solicitados son: " + materialesSolicitados);

	}







}
