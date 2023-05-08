import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Administrador{

    private int idUsuario;
    private String nombre;
    private String apellido;
    private static List<Administrador> listaAdministradores = new ArrayList<>();

    public Administrador(int idUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        listaAdministradores.add(this);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void llamarCliente(int idCliente) {

        Cliente cliente = buscarClienteId(idCliente);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Llamando al cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID ingresado.");
        }
    }

    private Cliente buscarClienteId(int idCliente) {
        for (Cliente cliente : Cliente.getListaClientes()) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public void calcularPresupuesto() {
        int mat = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de materiales utilizados en la obra"));
        int presupuesto = mat * 20;
        JOptionPane.showMessageDialog(null, "El presupuesto por la cantidad de materiales utilizados es: " + presupuesto);
    }


    public void crearProyecto(int idCliente){

        Cliente cliente = buscarClienteId(idCliente);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "El proyecto es para el cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            int idProyecto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un ID para registrar el proyecto"));
            cliente.setIdProyecto(idProyecto);
            JOptionPane.showMessageDialog(null, "Al proyecto se le asigno el número: " + cliente.getIdProyecto());
            int cantMat = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de materiales para calcular el presupuesto"));
            cliente.setPresupuesto(cantMat*20);
            cliente.setMaterialesNecesarios(cantMat);
            JOptionPane.showMessageDialog(null, "El proyecto de " + cliente.getNombre() + " " + cliente.getApellido() +
                    "\n\nID: " + cliente.getIdProyecto()
                    + "\nCantidad de materiales: " +cliente.getMaterialesNecesarios()
                    + "\nPresupuesto total: " + cliente.getPresupuesto() + "$");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID ingresado.");
        }
    }

}

