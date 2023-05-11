import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Obrero {
	private String nombre; // Atributo que identifica el nombre de una persona
	private String apellidos; /* Atributo que identifica los apellidos de una persona */
	private boolean disponible;
	proyecto_obra obra;
	private LinkedList<Obrero> listaObreros = new LinkedList<>();


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
	
	public Obrero(String nombre, String apellidos, boolean disponible) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.disponible = disponible;
	}
	@Override
	public String toString() {
		return "Obrero [nombre=" + nombre + ", apellidos=" + apellidos + ", disponible=" + disponible + "]";
	}

	public void AgregarObrero(){
		String nombrei, apellidoi, seguiragregando="";
		boolean dispi;
		int i;

		do {
			for (i=1; i<=30; i++) {

				Obrero obrero = new Obrero("","", true);

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

	public void BuscarObrero(){
		String nombrei, apellidoi;
		int idingre;

		Obrero obrero = new Obrero("","", true);

		nombrei= JOptionPane.showInputDialog("Ingrese el nombre del obrero");
		apellidoi= JOptionPane.showInputDialog("Ingrese el apellido del obrero");

		for (int i=0 ;  i < listaObreros.size() ; i++ ) {
			if (listaObreros.get(i).getNombre().equalsIgnoreCase(nombrei)) {
				if (listaObreros.get(i).getApellidos().equalsIgnoreCase(apellidoi)){

					JOptionPane.showMessageDialog(null, "Obrero encontrado!");
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

		Obrero obrero = new Obrero("","", true);

		nombrei= JOptionPane.showInputDialog("Ingrese el nombre del obrero");
		apellidoi= JOptionPane.showInputDialog("Ingrese el apellido del obrero");

		for (int i=0 ;  i < listaObreros.size() ; i++ ) {
			if (listaObreros.get(i).getNombre().equalsIgnoreCase(nombrei)) {
				if (listaObreros.get(i).getApellidos().equalsIgnoreCase(apellidoi)){
					JOptionPane.showMessageDialog(null, "Obrero encontrado!");
					idingre=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la obra a asignar obrero"));
					if (listaProyectos.get(i).getId_obra()==idingre) {
						//agregar el obrero a la obra que ya tengo el id
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





}
