package banco;

import dto.RespuestaPorcentaje;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una cuenta de ahorros y sus operaciones
 * @version 1.0
 * @autor caflorezvi
 */
public class CuentaAhorros {

    private final String numeroCuenta;
    private float saldo;
    private final List<Transaccion> transacciones;
    private final Usuario propietario;

    public CuentaAhorros(String numeroCuenta, Usuario propietario, float saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
        this.saldo = saldoInicial;
        this.transacciones = new ArrayList<>();
    }

    /**
     * Método que realiza un depósito en la cuenta de ahorros y registra la transacción
     * @param cantidad cantidad a retirar
     * @param emisor usuario que realiza el retiro
     * @param categoria categoría de la transacción
     */
    private void depositar(float cantidad, Usuario emisor, CategoriaTransaccion categoria) {
        // Se realiza el depósito
        saldo += cantidad;

        // Se registra la transacción de depósito
        transacciones.add(new Transaccion(TipoTransaccion.DEPOSITO, cantidad, emisor, LocalDateTime.now(), categoria));
    }

    /**
     * Método que realiza un retiro en la cuenta de ahorros y registra la transacción
     * @param cantidad cantidad a retirar
     * @param cuentaDestino cuenta de destino de la transferencia
     * @param categoria categoría de la transacción
     */
    public void transferir(float cantidad, CuentaAhorros cuentaDestino, CategoriaTransaccion categoria) throws Exception{

        // Se cobra 200 por cada transferencia
        cantidad += 200;

        // Se valida que el saldo sea suficiente
        if (saldo >= cantidad) {

            // Se realiza el retiro
            saldo -= cantidad;

            // Se registra la transacción de depósito en la cuenta de destino
            cuentaDestino.depositar(cantidad, propietario, categoria);

            // Se registra la transacción de retiro en la cuenta de origen
            transacciones.add(new Transaccion(TipoTransaccion.RETIRO, cantidad, cuentaDestino.getPropietario(), LocalDateTime.now(), categoria));

        } else {
            throw new Exception("Saldo insuficiente");
        }
    }

    /**
     * Método que obtiene las transacciones de un mes y año específico de la cuenta de ahorros
     * @param mes mes de las transacciones
     * @param anio año de las transacciones
     * @return lista de transacciones del mes y año
     */
    public List<Transaccion> obtenerTransaccionesPeriodo(int mes, int anio) {

        List<Transaccion> transaccionesMes = new ArrayList<>();

        for (int i = 0; i < transacciones.size(); i++) {
            if(transacciones.get(i).getFecha().getMonthValue() == mes && transacciones.get(i).getFecha().getYear() == anio){
                transaccionesMes.add(transacciones.get(i));
            }
        }
        return transaccionesMes;
    }


    /**
     * Método que obtiene el porcentaje de gastos de un mes y año específico de la cuenta de ahorros
     * @param mes mes de las transacciones
     * @param anio año de las transacciones
     * @return porcentaje de gastos y categorías de gastos del mes y año
     */
    public RespuestaPorcentaje obtenerPorcentajeGastos(int mes, int anio) {

        List<Transaccion> transaccionesMes = obtenerTransaccionesPeriodo(mes, anio);
        float gastos = 0;
        float ingresos = 0;
        float[] categorias = new float[6];

        for (int i = 0; i < transaccionesMes.size(); i++) {
            if(transaccionesMes.get(i).getTipo() == TipoTransaccion.RETIRO){

                switch (transaccionesMes.get(i).getCategoria()) {
                    case VIAJES:
                        categorias[0] += transaccionesMes.get(i).getMonto();
                        break;
                    case FACTURAS:
                        categorias[1] += transaccionesMes.get(i).getMonto();
                        break;
                    case GASOLINA:
                        categorias[2] += transaccionesMes.get(i).getMonto();
                        break;
                    case ROPA:
                        categorias[3] += transaccionesMes.get(i).getMonto();
                        break;
                    case PAGO:
                        categorias[4] += transaccionesMes.get(i).getMonto();
                        break;
                    case OTROS:
                        categorias[5] += transaccionesMes.get(i).getMonto();
                        break;
                }

                gastos += transaccionesMes.get(i).getMonto();
            }else{
                ingresos += transaccionesMes.get(i).getMonto();
            }
        }

        float total = gastos + ingresos;
        float porcentajeIngresos = (ingresos / (total)) * 100;
        float porcentajeGastos = (gastos / (total)) * 100;

        return new RespuestaPorcentaje(porcentajeIngresos, porcentajeGastos, categorias);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", transacciones=" + transacciones +
                ", propietario=" + propietario.getNombre() +
                '}';
    }
}
