package juego;

import juego.enums.CaracteristicasMago;
import juego.enums.HablidadesMago;
import juego.modelo.Personaje;
import java.util.ArrayList;

public class MagoBuilder implements PersonajeBuilder {

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

        ArrayList<HablidadesMago> habilidadesMago = new ArrayList<>();

        habilidades.forEach( habilidad -> {
            if( ! (habilidad instanceof HablidadesMago) ) {
                throw new RuntimeException("Habilidad no válida para un mago");
            }else{
                habilidadesMago.add((HablidadesMago) habilidad);
            }
        });

        personaje.setHabilidades(habilidadesMago);
    }

    @Override
    public void asignarCaracteristicas(ArrayList<? extends Enum<?>> caracteristicas) {

        ArrayList<CaracteristicasMago> caracteristicasMago = new ArrayList<>();

        caracteristicas.forEach( caracteristica -> {
            if( ! (caracteristica instanceof CaracteristicasMago) ) {
                throw new RuntimeException("Característica no válida para un mago");
            }else{
                caracteristicasMago.add((CaracteristicasMago) caracteristica);
            }
        });

        personaje.setCaracteristicas(caracteristicasMago);
    }

    @Override
    public Personaje build() {
        return personaje;
    }
}
