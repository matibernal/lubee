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

}


