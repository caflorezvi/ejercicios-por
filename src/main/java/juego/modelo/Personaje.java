package juego.modelo;

import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Personaje {

    private String nombre, descripcion;
    private int nivel;
    private ArrayList<? extends Enum<?>> habilidades;
    private ArrayList<? extends Enum<?>> caracteristicas;

}
