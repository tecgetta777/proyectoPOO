package uni1a.model;

public class YouTube extends ContenidoAudiovisual {

    private String canal;  // Canal de YouTube
    private int likes;      // Número de likes del video

    // Constructor
    public YouTube(String titulo, int duracionEnMinutos, String genero, String canal, int likes) {
        super(titulo, duracionEnMinutos, genero);  // Llama al constructor de la superclase
        this.canal = canal;
        this.likes = likes;
    }

    // Implementación obligatoria del método abstracto
    @Override
    public void mostrarDetalles() {
        System.out.println("Video de YouTube: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " min");
        System.out.println("Género: " + getGenero());
        System.out.println("Canal: " + canal);
        System.out.println("Likes: " + likes);
    }

    // Getters opcionales
    public String getCanal() {
        return canal;
    }

    public int getLikes() {
        return likes;
    }
}
