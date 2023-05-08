package lubee.src;

import java.util.ArrayList;
import java.util.List;

public class Maquinaria {
    private String tipo;
    private String patente;
    private int cantidadDisponible;
    private boolean disponible;

    public Maquinaria(String tipo, String patente, int cantidadDisponible, boolean disponible) {
        this.tipo = tipo;
        this.patente = patente;
        this.cantidadDisponible = cantidadDisponible;
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

public class ControlMaquinas {
    private List<Maquina> maquinas;

    public ControlMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public int contarMaquinasDisponibles() {
        int cantidadDisponibles = 0;
        for (Maquina maquina : maquinas) {
            if (maquina.isDisponible()) {
                cantidadDisponibles++;
            }
        }
        return cantidadDisponibles;
    }

    public static void main(String[] args) {
        List<Maquina> maquinas = new ArrayList<>();
        maquinas.add(new Maquina("Tipo1", "Patente1", 5, true));
        maquinas.add(new Maquina("Tipo2", "Patente2", 3, false));
        maquinas.add(new Maquina("Tipo3", "Patente3", 2, true));

        ControlMaquinas control = new ControlMaquinas(maquinas);
        int cantidadDisponibles = control.contarMaquinasDisponibles();
        return System.out.println("Cantidad de máquinas disponibles: " + cantidadDisponibles
                ;
    }




