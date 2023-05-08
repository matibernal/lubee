package proyecto_sof;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

public class Plano {
	private int id_plano;
	private String cliente;
	private String Nombre;
	
	public String getNombre() {
		return Nombre;
	}
	public int getId_plano() {
		return id_plano;
	}
	public void setId_plano(int id_plano) {
		this.id_plano = id_plano;
	}
	public String getCliente() {
		return cliente;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	public Plano(int id_plano, String cliente, String planos) {
		super();
		this.id_plano = id_plano;
		this.cliente = cliente;
	}
	

	@Override
	public String toString() {
		return "Plano [id_plano=" + id_plano + ", cliente=" + cliente + ", Nombre=" + Nombre + "]";
	}
	
	public static List<Plano> realizarPlano() {
	    List<Plano> listaPlanos = new ArrayList<>();
	    
	    // creación de los planos y agregado a la lista
	    Plano plano1 = new Plano(213,"ricardo ford","");
	    listaPlanos.add(plano1);
	    
	    Plano plano2 = new Plano(214,"Marcelo Tinneli","");
	    listaPlanos.add(plano2);
	    
	    Plano plano3 = new Plano(215,"Julian weich","");
	    listaPlanos.add(plano3);
	    
	    return listaPlanos;
	}
	
	
	public void eliminarPlano() {

	}
	
	public Plano buscarPlano(int idPlano, Plano[] listaPlanos) {
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
	
	
}
