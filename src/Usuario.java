public class Usuario {

    private int idUsuario;
    private String tipoUsuario;
    private int clave;
    private String nombre;
    private String apellido;

    public Usuario(int idUsuario, String tipoUsuario, int clave, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
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

    public boolean login (String dni, String clave) {
        return this.dni.equals(dni) && this.clave.equeals(clave);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
