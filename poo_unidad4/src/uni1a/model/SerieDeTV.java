package uni1a.model;

public class SerieDeTV extends ContenidoAudiovisual {

    public SerieDeTV(String titulo, int duracion, String genero) {
        super(titulo, duracion, genero);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("📺 Serie de TV: " + getTitulo() +
                " | Duración: " + getDuracionEnMinutos() +
                " min | Género: " + getGenero());
    }
}
