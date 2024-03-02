package banco;

import banco.dto.RespuestaPorcentaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Clase que representa un banco y sus operaciones de prueba
 * @version 1.0
 * @author caflorezvi
 */
public class BancoTest {

    @Test
    public void registroUsuarioTest() throws Exception {

        Banco banco = new Banco("Banco de la gente");
        // Se agrega un usuario al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "654321", "juan@gmail.com", "123");

        // Se verifica que el usuario haya sido agregado
        Assertions.assertEquals(1, banco.getUsuarios().size());
    }

    @Test
    public void eliminarUsuarioTest() throws Exception {
        Banco banco = new Banco("Banco de la gente");
        // Se agrega un usuario al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "654321", "juan@gmail.com", "123");

        // Se elimina el usuario
        banco.eliminarUsuario("654321");

        // Se verifica que el usuario haya sido eliminado
        Assertions.assertTrue(banco.getUsuarios().isEmpty());
    }

    @Test
    public void creacionCuentaAhorrosTest() throws Exception {
        Banco banco = new Banco("Banco de la gente");

        // Se agrega un usuario al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "654321", "juan@gmail.com", "123");

        // Se crea una cuenta de ahorros para el usuario
        String numeroCuenta1 = banco.agregarCuentaAhorros("654321", 100000);

        // Se verifica que la cuenta haya sido creada y asociada al usuario
        Assertions.assertNotNull(banco.obtenerCuentaAhorros(numeroCuenta1));
    }

    @Test
    public void validarUsuarioTest() throws Exception {
        Banco banco = new Banco("Banco de la gente");

        // Se agrega un usuario al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "654321", "juan@gmail.com", "123");

        // Se valida que el usuario exista dado su número de identificación y contraseña
        Usuario usuarioBuscado = banco.validarUsuario("654321", "123");

        // Se verifica que el usuario haya sido encontrado
        Assertions.assertNotNull(usuarioBuscado);
    }

    @Test
    public void consultarSaldoTest() throws Exception {
        Banco banco = new Banco("Banco de la gente");

        // Se agrega un usuario al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "654321", "juan@gmail.com", "123");

        // Se crea una cuenta de ahorros para el usuario
        banco.agregarCuentaAhorros("654321", 100000);

        // Se consulta el saldo de la cuenta de ahorros del usuario
        List<CuentaAhorros> cuentas = banco.consultarSaldo("654321", "123");

        // Se verifica que el saldo sea el esperado
        Assertions.assertEquals(100000, cuentas.get(0).getSaldo());

    }

    @Test
    public void realizarTransferenciaTest() throws Exception{

        Banco banco = new Banco("Banco de la gente");

        // Se agregan dos usuarios al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "123456", "juan@gmail.com", "123");
        banco.agregarUsuario("Carlos Perez", "Calle 2322", "654321", "carlos@gmail.com", "123");

        // Se crea una cuenta de ahorros para cada usuario
        String numeroCuenta1 = banco.agregarCuentaAhorros("123456", 100000);
        String numeroCuenta2 = banco.agregarCuentaAhorros("654321", 0);

        // Se realiza una transferencia entre las cuentas de ahorros
        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 10000, CategoriaTransaccion.PAGO);

        // Se verifica que el saldo de las cuentas sea el esperado después de la transferencia
        Assertions.assertEquals(89800, banco.consultarSaldo("123456", "123").get(0).getSaldo());

    }

    @Test
    public void consultarTransaccionesTest() throws Exception {
        Banco banco = new Banco("Banco de la gente");

        // Se agregan dos usuarios al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "123456", "juan@gmail.com", "123");
        banco.agregarUsuario("Carlos Perez", "Calle 2322", "654321", "carlos@gmail.com", "123");

        // Se crea una cuenta de ahorros para cada usuario
        String numeroCuenta1 = banco.agregarCuentaAhorros("123456", 100000);
        String numeroCuenta2 = banco.agregarCuentaAhorros("654321", 0);

        // Se realizan dos transferencias entre las cuentas de ahorros
        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 10000, CategoriaTransaccion.PAGO);
        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 37600, CategoriaTransaccion.FACTURAS);

        // Se consulta las cuentas de ahorros del usuario
        List<CuentaAhorros> cuentas = banco.consultarSaldo("123456", "123");

        // Se obtienen las transacciones de la primera cuenta de ahorros del usuario en el mes 2 del año 2024
        List<Transaccion> transacciones = cuentas.get(0).obtenerTransaccionesPeriodo(2, 2024);

        // Se verifica que las transacciones obtenidas sean las esperadas
        Assertions.assertEquals(2, transacciones.size());

    }

    @Test
    public void consultarPorcentajeTransaccionesTest() throws Exception {
        Banco banco = new Banco("Banco de la gente");

        // Se agregan dos usuarios al banco
        banco.agregarUsuario("Juan Perez", "Calle 123", "123456", "juan@gmail.com", "123");
        banco.agregarUsuario("Carlos Perez", "Calle 2322", "654321", "carlos@gmail.com", "123");

        // Se crea una cuenta de ahorros para cada usuario
        String numeroCuenta1 = banco.agregarCuentaAhorros("123456", 100000);
        String numeroCuenta2 = banco.agregarCuentaAhorros("654321", 0);

        // Se realizan dos transferencias entre las cuentas de ahorros
        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 10000, CategoriaTransaccion.PAGO);
        banco.realizarTransferencia(numeroCuenta1, numeroCuenta2, 37600, CategoriaTransaccion.FACTURAS);

        // Se consulta las cuentas de ahorros del usuario
        List<CuentaAhorros> cuentas = banco.consultarSaldo("123456", "123");

        // Se obtiene el porcentaje de gastos del usuario en el mes 2 del año 2024
        RespuestaPorcentaje respuestaPorcentaje = cuentas.get(0).obtenerPorcentajeGastos(2, 2024);

        // Se verifica que el porcentaje de gastos sea el esperado
        Assertions.assertEquals(100, respuestaPorcentaje.getPorcentajeGastos());

    }

}
