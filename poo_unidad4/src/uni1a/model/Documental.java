package uni1a.model;

public class Documental extends ContenidoAudiovisual {

    public Documental(String titulo, int duracion, String genero) {
        super(titulo, duracion, genero);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("🎥 Documental: " + getTitulo() +
                " | Duración: " + getDuracionEnMinutos() +
                " min | Tema: " + getGenero());
    }
}
