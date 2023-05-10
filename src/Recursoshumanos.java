import java.util.List;

public class Recursoshumanos {


        private int idUsuario;
        private String nombre;
        private String apellido;
        private String sectorTrabajo;
        private LinkedList<Recursoshumanos> listaTrabajadores;



    public Recursoshumanos(int idUsuario, String nombre, String apellido, String sectorTrabajo, LinkedList<Recursoshumanos> listaTrabajadores) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sectorTrabajo = sectorTrabajo;
        listaTrabajadores = new LinkedList<>();

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
            listaTrabajadores.add(trabajador)
        }

        public void quitarTrabajaro(Recursoshumanos trabajador) {
            listaTrabajadores.remove(trabajador)
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


