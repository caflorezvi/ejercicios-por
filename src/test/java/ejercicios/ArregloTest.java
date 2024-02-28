package ejercicios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArregloTest {

    @Test
    public void invertirArregloTest(){

        //Se crea un arreglo de prueba con 4 elementos
        float[] arregloPrueba = new float[4];
        arregloPrueba[0] = 2.5f;
        arregloPrueba[1] = 3.8f;
        arregloPrueba[2] = 9.7f;
        arregloPrueba[3] = -1.6f;

        //Se crea una instancia de la clase Arreglo
        Arreglo arreglo = new Arreglo();

        //Invertimos el arreglo de prueba y lo guardamos en un nuevo arreglo
        float[] arregloInvertido = arreglo.invertirArreglo(arregloPrueba);

        //Se verifica que el arreglo invertido tenga los elementos esperados en el orden esperado
        Assertions.assertEquals(-1.6f, arregloInvertido[0]);
        Assertions.assertEquals(9.7f, arregloInvertido[1]);
        Assertions.assertEquals(3.8f, arregloInvertido[2]);
        Assertions.assertEquals(2.5f, arregloInvertido[3]);

    }

}
