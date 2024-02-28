package banco;

import java.time.LocalDateTime;

/**
 * Clase que representa una transacción bancaria
 * @version 1.0
 * @author caflorezvi
 */
public class Transaccion {

    private final TipoTransaccion tipo; // "Depósito" o "Retiro" NO es tan necesario
    private final float monto;
    private final Usuario usuario; // Usuario emisor o destinatario de la transacción
    private final LocalDateTime fecha;
    private final CategoriaTransaccion categoria;

    public Transaccion(TipoTransaccion tipo, float monto, Usuario usuario, LocalDateTime fecha, CategoriaTransaccion categoria) {
        this.tipo = tipo;
        this.monto = monto;
        this.usuario = usuario;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public float getMonto() {
        return monto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public CategoriaTransaccion getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "tipo=" + tipo +
                ", monto=" + monto +
                ", usuario=" + usuario.getNombre() +
                ", fecha=" + fecha +
                ", categoria=" + categoria +
                '}';
    }
}
