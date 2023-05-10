import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Recursoshumanos {


        private int idUsuario;
        private String nombre;
        private String apellido;
        private String sectorTrabajo;
        private List<Recursoshumanos> listaTrabajadores = new ArrayList<>();



    public Recursoshumanos(int idUsuario, String nombre, String apellido, String sectorTrabajo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sectorTrabajo = sectorTrabajo;

    }

    public Recursoshumanos(int idUsuario, String juan, String lopez, String obrero, LinkedList<Recursoshumanos> listaTrabajadores) {
    }

    public int getIdUsuario() {
            return idUsuario;
        }
        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getSectorTrabajo() {
            return sectorTrabajo;
        }

        public void setSectorTrabajo(String sectorTrabajo) {
            this.sectorTrabajo = sectorTrabajo;
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

        public void añadirTrabajador (Recursoshumanos trabajador) {

        //listaTrabajadores.add(trabajador)

        }

        public void quitarTrabajador(Recursoshumanos trabajador) {

        //listaTrabajadores.remove(trabajador)

        }

    @Override
    public String toString() {
        return "Recursoshumanos{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sectorTrabajo='" + sectorTrabajo + '\'' +
                ", listaTrabajadores=" + listaTrabajadores +
                '}';
    }
}


