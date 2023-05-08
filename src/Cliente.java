import java.util.ArrayList;
import java.util.List;

public class Cliente{

    private int idCliente;
    private int dni;
    private String nombre;
    private String apellido;
    private String numeroDeCelular;
    private int idProyecto;
    private int presupuesto;
    private int materialesNecesarios;
    private static List<Cliente> listaClientes = new ArrayList<>();

    public Cliente(int idCliente, int dni, String nombre, String apellido, String numeroDeCelular) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCelular = numeroDeCelular;
        listaClientes.add(this);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public String getNumeroDeCelular() {
        return numeroDeCelular;
    }

    public void setNumeroDeCelular(String numeroDeCelular) {
        this.numeroDeCelular = numeroDeCelular;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getMaterialesNecesarios() {
        return materialesNecesarios;
    }

    public void setMaterialesNecesarios(int materialesNecesarios) {
        this.materialesNecesarios = materialesNecesarios;
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }
}