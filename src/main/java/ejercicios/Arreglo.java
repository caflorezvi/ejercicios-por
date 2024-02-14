package ejercicios;

public class Arreglo {

    /**
     * Permite invertir un arreglo de tipo float
     * @param arreglo Arreglo de tipo float
     * @return Arreglo invertido
     */
    public float[] invertirArreglo(float[] arreglo){

        float[] nuevo = new float[ arreglo.length ];
        int j = 0;

        for( int i = arreglo.length-1; i >= 0; i -- ){
            nuevo[j] = arreglo[i];
            j++;
        }

        return nuevo;
    }

}
