
import javax.swing.*;
import java.awt.Component;
import java.awt.Container;
import java.util.LinkedList;
import java.util.List;


public class Plano {
	private int id_plano;
	//private String cliente;
	private String nombre;
	Maestro_obra maestro;
	Cliente cliente;
	private LinkedList<Plano> listaPlanos;
	
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
	
	
	public Plano(int id_plano, String nombre) {
		super();
		this.id_plano = id_plano;
		this.nombre = nombre;
	}
	

	@Override
	public String toString() {
		return "Plano [id_plano=" + ", Nombre=" + nombre + "]";
	}
	
	public void realizarPlano() {

		int idplanoi;
		String nombrei;
		/*
	    // creaci�n de los planos y agregado a la lista
	    Plano plano1 = new Plano(213,"ricardo ford","");
	    listaPlanos.add(plano1);
	    
	    Plano plano2 = new Plano(214,"Marcelo Tinneli","");
	    listaPlanos.add(plano2);
	    
	    Plano plano3 = new Plano(215,"Julian weich","");
	    listaPlanos.add(plano3);
	    
	    return listaPlanos;

		 */

		Plano plano = new Plano (0, "");

		nombrei= JOptionPane.showInputDialog("Digite el nombre del obrero");
		setNombre(nombrei);
		idplanoi=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad que ingresa"));
		setId_plano(idplanoi);

		listaPlanos.add(plano);

	}
	
	
	public void eliminarPlano() {

		int idplanoi;
		String nombrei;

		nombrei=JOptionPane.showInputDialog("Ingrese el nombre del plano");
		idplanoi=Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del plano"));

		//falta do while para que se repita

		for (int i=0 ;  i < listaPlanos.size() ; i++ ) {
			if (listaPlanos.get(i).getNombre().equalsIgnoreCase(nombrei)) {
				if (listaPlanos.get(i).getId_plano()==idplanoi){
					listaPlanos.remove(i);
					JOptionPane.showMessageDialog(null, "Ha sido eliminado con exito");
				} else {
					JOptionPane.showMessageDialog(null, "El id del plano no existe");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre del plano no existe");
			}
		}



	}
	/*
		public Plano buscarPlano() {

	    for (Plano p : listaPlanos) {
	        if (p.getId_plano() == idPlano) {
	            return p;
	        }
	    }
	    return null;


		}
	
		public static List<Plano> realizarPlano2() {
        List<Plano> listaPlanos = new ArrayList<>();
        listaPlanos.add(new Plano(1, "Plano 1", "Cliente 1"));
        listaPlanos.add(new Plano(2, "Plano 2", "Cliente 2"));
        listaPlanos.add(new Plano(3, "Plano 3", "Cliente 3"));
        listaPlanos.add(new Plano(4, "Plano 4", "Cliente 4"));
        listaPlanos.add(new Plano(5, "Plano 5", "Cliente 5"));
        return listaPlanos;
    	}

		 */
	
	
}

