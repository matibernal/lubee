package lubee.src;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

        

        public class Main {

            public static void main(String[] args) {

                JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE  ");
                JOptionPane.showMessageDialog(null, "  La empresa numero 1 en construcciones  ");

                List<Maquina> maquinas = new ArrayList<>();
                int opcion;
                do {
                    String menu = "Menú:\n"
                            + "1. Agregar máquina\n"
                            + "2. Ver cantidad de máquinas disponibles\n"
                            + "3. Salir";
                    opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Programa de máquinas"));
                    switch (opcion) {
                        case 1:
                            String tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de la máquina:", "Agregar máquina");
                            String patente = JOptionPane.showInputDialog(null, "Ingrese la patente de la máquina:", "Agregar máquina");
                            int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de máquinas disponibles:", "Agregar máquina"));
                            boolean disponible = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Ingrese si la máquina está disponible (true/false):", "Agregar máquina"));
                            maquinas.add(new Maquina(tipo, patente, cantidadDisponible, disponible));
                            JOptionPane.showMessageDialog(null, "Máquina agregada exitosamente", "Agregar máquina", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            ControlMaquinas control = new ControlMaquinas(maquinas);
                            int cantidadDisponibles = control.contarMaquinasDisponibles();
                            JOptionPane.showMessageDialog(null, "Cantidad de máquinas disponibles: " + cantidadDisponibles, "Ver máquinas disponibles", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Saliendo del programa...", "Programa de máquinas", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción inválida", "Programa de máquinas", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } while (opcion != 3);
            }
        }

    }




