public class RecursosHumanos {

    private int idUsuario;
    private String sectorTrabajo;

    public RecursosHumanos(int idUsuario, String sectorTrabajo) {
        this.idUsuario = idUsuario;
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
}
