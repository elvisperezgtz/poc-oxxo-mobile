package starter.models;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private String nombreNegocio;
    private String actividadEconomica;
    private String codigoPostal;


    public Usuario(){
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public void defaulValues(){
        this.nombre= "Pepe";
        this.apellido ="Perez";
        this.email="testautomationoxxo@gmail.com";
        this.contrasenia = "Fensa2022**";
        this.nombreNegocio= "OXXO";
        this.actividadEconomica="ALIMENTOS Y BEBIDAS";
        this.codigoPostal="50001";
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", nombreNegocio='" + nombreNegocio + '\'' +
                ", actividadEconomica='" + actividadEconomica + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}
