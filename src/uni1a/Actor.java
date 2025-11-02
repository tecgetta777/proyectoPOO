package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private String nombre;
    private int edad;
    private List<Pelicula> peliculas; // Asociación con Pelicula

    public Actor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @Override
    public String toString() {
        return "Actor: " + nombre + " (" + edad + " años)";
    }
}
