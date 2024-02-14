package ejercicios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ListaPalabrasTest {

    @Test
    public void obtenerPalabraMasVocalesTest(){

        //Se crea un ArrayList de palabras y se agregan 6 palabras
        ArrayList<String> palabras = new ArrayList<>();

        palabras.add("Silla");
        palabras.add("Computador");
        palabras.add("Tortuga");
        palabras.add("Tablero");
        palabras.add("Cuaderno");
        palabras.add("Abecedario");

        //Se crea un objeto de la clase ListaPalabras y se llama al método obtenerPalabraMasVocales
        ListaPalabras listaPalabras = new ListaPalabras();
        String palabra = listaPalabras.obtenerPalabraMasVocales(palabras);

        //Se verifica que la palabra con más vocales sea "Abecedario", que tiene 6 vocales
        Assertions.assertEquals("Abecedario", palabra);

    }

}
