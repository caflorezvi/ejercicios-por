package juego;

import juego.enums.CaracteristicasGuerrero;
import juego.enums.HabilidadesGuerrero;
import juego.modelo.Personaje;

import java.util.ArrayList;

public class Prueba {

    public static void main(String[] args) {

        PersonajeBuilder builder = new GuerreroBuilder();
        DirectorPersonaje director = new DirectorPersonaje(builder);

        ArrayList<HabilidadesGuerrero> habilidades = new ArrayList<>();
        habilidades.add(HabilidadesGuerrero.GOLPE_DEFINITIVO);
        habilidades.add(HabilidadesGuerrero.ESPADA_AFILADA);

        ArrayList<CaracteristicasGuerrero> caracteristicas = new ArrayList<>();
        caracteristicas.add(CaracteristicasGuerrero.FUERZA);

        director.build("Guerrero", 1, "Un valiente guerrero", habilidades, caracteristicas);
        Personaje guerrero = builder.build();

        System.out.println(guerrero);

    }

}
