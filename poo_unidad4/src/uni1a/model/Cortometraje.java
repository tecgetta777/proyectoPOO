package uni1a.model;

public class Cortometraje extends ContenidoAudiovisual {

    public Cortometraje(String titulo, int duracion, String genero) {
        super(titulo, duracion, genero);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("🎞 Cortometraje: " + getTitulo() +
                " | Duración: " + getDuracionEnMinutos() +
                " min | Género: " + getGenero());
    }
}
