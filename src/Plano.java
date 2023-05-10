import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Plano  implements Serializable{
    public List<Plano> realizarPlano() {
        List<Plano> listaPlanos = new ArrayList<>();
        listaPlanos.add(new Plano("Plano 1", "Palermo Soho", 1000.0, 2000.0));
        listaPlanos.add(new Plano("Plano 2", "Quilmes", 1500.0, 2500.0));
        listaPlanos.add(new Plano("Plano 3", "Avenida Corrientes", 2000.0, 3000.0));
        listaPlanos.add(new Plano("Plano 4", "Rivadavia", 2000.0, 3000.0));
        listaPlanos.add(new Plano("Plano 5", "Alcorta", 2000.0, 3000.0));
        return listaPlanos;

    }
    private static int nextId = 1;
    private int id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private double ancho;
    private double alto;
    private ArrayList<String> obrerosAsignados;

    public Plano(String nombre, String descripcion, String ubicacion, double ancho, double alto) {
        this.id = nextId++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
    }

    public Plano() {
    }

    public Plano(String nombre, String descripcion, double ancho, double alto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ancho = ancho;
        this.alto = alto;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Plano.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public ArrayList<String> getObrerosAsignados() {
        return obrerosAsignados;
    }

    public void setObrerosAsignados(ArrayList<String> obrerosAsignados) {
        this.obrerosAsignados = obrerosAsignados;
    }

    public Plano(String descripcion, String ubicacion, double ancho, double alto, int id) {
        super();
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.ancho = ancho;
        this.alto = alto;
        this.id = id;
        this.obrerosAsignados = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDescripción: " + descripcion +
                "\nAncho: " + ancho + "\nAlto: " + alto;
    }

    public void eliminarPlano() {
        // TODO Auto-generated method stub

    }


}
