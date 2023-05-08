import java.util.ArrayList;
import java.util.List;

public class Recursoshumanos {


        private int idUsuario;
        private String nombre;
        private String apellido;
        private String sectorTrabajo;




    public Recursoshumanos(int idUsuario, String nombre, String apellido, String sectorTrabajo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sectorTrabajo = sectorTrabajo;

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

    public void agregarPersonal(int idUsuario,String nombre, String apellido, String sectorTrabajo){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sectorTrabajo = sectorTrabajo;
    }


}


