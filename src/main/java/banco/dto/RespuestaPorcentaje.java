package banco.dto;

import java.util.Arrays;

/**
 * Clase que representa la respuesta de la operación de obtener porcentajes de ingresos y gastos
 * @version 1.0
 * @autor caflorezvi
 */
public class RespuestaPorcentaje {

    private final float porcentajeIngresos;
    private final float porcentajeGastos;
    private final float[] gastosPorCategoria;

    public RespuestaPorcentaje(float porcentajeIngresos, float porcentajeGastos, float[] gastosPorCategoria) {
        this.porcentajeIngresos = porcentajeIngresos;
        this.porcentajeGastos = porcentajeGastos;
        this.gastosPorCategoria = gastosPorCategoria;
    }

    public float getPorcentajeIngresos() {
        return porcentajeIngresos;
    }

    public float getPorcentajeGastos() {
        return porcentajeGastos;
    }

    public float[] getGastosPorCategoria() {
        return gastosPorCategoria;
    }

    @Override
    public String toString() {
        return "RespuestaPorcentaje{" +
                "porcentajeIngresos=" + porcentajeIngresos +
                ", porcentajeGastos=" + porcentajeGastos +
                ", gastosPorCategoria=" + Arrays.toString(gastosPorCategoria) +
                '}';
    }
}
