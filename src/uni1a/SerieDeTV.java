/**
 * Class SerieDeTV
 */
package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private List<Temporada> listaTemporadas; // Composición: la serie contiene temporadas

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    // Método para agregar temporadas a la serie
    public void agregarTemporada(Temporada temporada) {
        listaTemporadas.add(temporada);
    }

    // Método para obtener la lista de temporadas
    public List<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Número de temporadas: " + this.temporadas);

        // Mostrar detalles de cada temporada
        if (!listaTemporadas.isEmpty()) {
            System.out.println("Temporadas:");
            for (Temporada t : listaTemporadas) {
                System.out.println(" - " + t);
            }
        }
        System.out.println();
    }
}
