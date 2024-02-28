package banco;

import java.util.Objects;

/**
 * Clase que representa un usuario del banco
 * @version 1.0
 * @autor caflorezvi
 */
public class Usuario {

    private final String nombre;
    private final String direccion;
    private final String numeroIdentificacion;
    private final String correoElectronico;
    private final String contrasena;


    public Usuario(String nombre, String direccion, String numeroIdentificacion, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(numeroIdentificacion, usuario.numeroIdentificacion);
    }

    @Override
    public int hashCode() {
        return numeroIdentificacion != null ? numeroIdentificacion.hashCode() : 0;
    }
}
