package uni1a;

public class Cortometraje extends ContenidoAudiovisual {

    private Actor protagonista;

    public Cortometraje(String titulo, int duracionEnMinutos, String genero, Actor protagonista) {
        super(titulo, duracionEnMinutos, genero);
        this.protagonista = protagonista;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Cortometraje: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " min");
        System.out.println("Género: " + getGenero());
        System.out.println("Protagonista: " + protagonista.getNombre());
    }

    public Actor getProtagonista() {
        return protagonista;
    }
}
