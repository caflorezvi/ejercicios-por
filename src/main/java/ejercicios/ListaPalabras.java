package ejercicios;

import java.util.ArrayList;

public class ListaPalabras {

    /**
     * Método que evalúa si un caracter es vocal o no
     * @param letra Caracter a evaluar
     * @return True si es vocal, False si no lo es
     */
    public boolean esVocal(char letra){

        boolean respuesta = false;

        if( letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' ){
            respuesta = true;
        }

        return respuesta;
    }

    /**
     * Método que cuenta la cantidad de vocales en una palabra
     * @param palabra Palabra a evaluar
     * @return Cantidad de vocales en la palabra
     */
    public int contarVocales(String palabra){

        int contador = 0;
        palabra = palabra.toLowerCase();

        for( int i = 0; i < palabra.length(); i++ ){

            char letra = palabra.charAt(i);

            if( esVocal(letra) ){
                contador ++;
            }

        }

        return contador;
    }

    /**
     * Método que obtiene la palabra con más vocales de una lista
     * @param palabras Lista de palabras a evaluar
     * @return Palabra con más vocales de la lista
     */
    public String obtenerPalabraMasVocales(ArrayList<String> palabras){

        int mayor = 0;
        String palabraMayor = "";

        for( int i = 0; i<palabras.size(); i++ ){
            int vocales = contarVocales( palabras.get(i) );

            if( vocales > mayor ){
                mayor = vocales;
                palabraMayor = palabras.get(i);
            }

        }

        return palabraMayor;
    }

}
