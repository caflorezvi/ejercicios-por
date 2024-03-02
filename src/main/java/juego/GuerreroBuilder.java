package juego;

import juego.enums.CaracteristicasGuerrero;
import juego.enums.HabilidadesGuerrero;
import juego.modelo.Personaje;
import java.util.ArrayList;

public class GuerreroBuilder implements PersonajeBuilder {

    private final Personaje personaje = new Personaje();

    @Override
    public void asignarNombre(String nombre) {
        personaje.setNombre(nombre);
    }

    @Override
    public void asignarNivel(int nivel) {
        personaje.setNivel(nivel);
    }

    @Override
    public void asignarDescripcion(String descripcion) {
        personaje.setDescripcion(descripcion);
    }

    @Override
    public void asignarHabilidades(ArrayList<? extends Enum<?>> habilidades) {

        ArrayList<HabilidadesGuerrero> habilidadesGuerrero = new ArrayList<>();

        habilidades.forEach( habilidad -> {
            if( ! (habilidad instanceof HabilidadesGuerrero) ) {
                throw new RuntimeException("Habilidad no válida para un guerrero");
            }else {
                habilidadesGuerrero.add( (HabilidadesGuerrero) habilidad );
            }
        });

        personaje.setHabilidades(habilidadesGuerrero);
    }

    @Override
    public void asignarCaracteristicas(ArrayList<? extends Enum<?>> caracteristicas) {

        ArrayList<CaracteristicasGuerrero> caracteristicasGuerrero = new ArrayList<>();

        caracteristicas.forEach( caracteristica -> {
            if( ! (caracteristica instanceof CaracteristicasGuerrero) ) {
                throw new RuntimeException("Característica no válida para un guerrero");
            }else {
                caracteristicasGuerrero.add( (CaracteristicasGuerrero) caracteristica );
            }
        });

        personaje.setCaracteristicas( caracteristicasGuerrero );
    }

    @Override
    public Personaje build() {
        return personaje;
    }
}
