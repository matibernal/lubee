package proyecto_sof;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ListaDeStock {
	ArrayList<String> lista = new ArrayList<String>();
	
	private ArrayList<Maquinaria> listaMaquinarias;
	

    public ArrayList<Maquinaria> getListaMaquinarias() {
		return listaMaquinarias;
	}


	public void setListaMaquinarias(ArrayList<Maquinaria> listaMaquinarias) {
		this.listaMaquinarias = listaMaquinarias;
	}


	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}
	
	
	public ListaDeStock(ListaDeStock inventario) {
        lista = new ArrayList<>();
    }
	
	public ArrayList<Maquinaria> solicitarMaquinarias(int cantidad, String tipo) {
        ArrayList<Maquinaria> maquinariasSolicitadas = new ArrayList<>();
        int contador = 3;

        for (Maquinaria maquinaria : listaMaquinarias) {
            if (maquinaria.getTipo().equalsIgnoreCase(tipo) && maquinaria.isDisponible()) {
                maquinariasSolicitadas.add(maquinaria);
                maquinaria.setDisponible(false);
                contador++;

                if (contador == cantidad) {
                    break;
                }
            }
        }
        JOptionPane.showInputDialog(getListaMaquinarias() ,"Selecciona las maquinarias");

        if (contador == cantidad) {
            JOptionPane.showMessageDialog(null, "Maquinarias solicitadas correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficientes maquinarias disponibles para la solicitud.");
        }

        return maquinariasSolicitadas;
    }
	
	public ListaDeStock() {
        listaMaquinarias = new ArrayList<>();
        // Aquí se agregarían las maquinarias disponibles en el stock
    }
    
 


}
