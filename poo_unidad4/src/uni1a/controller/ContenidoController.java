package uni1a.controller;

import uni1a.model.*;
import uni1a.persistence.FileManager;
import java.util.*;

public class ContenidoController {

    private List<ContenidoAudiovisual> lista = new ArrayList<>();

    // Agrega un contenido
    public void agregarContenido(ContenidoAudiovisual c) {
        lista.add(c);
        System.out.println("✔ Contenido agregado correctamente.");
    }

    // Muestra todos los contenidos
    public void mostrarTodos() {
        if (lista.isEmpty()) {
            System.out.println("No hay contenido guardado.");
            return;
        }
        System.out.println("\n--- LISTA DE CONTENIDO ---");
        for (ContenidoAudiovisual c : lista) {
            c.mostrarDetalles();
            System.out.println("--------------------------");
        }
    }

    // Carga lista desde CSV
    public void cargarCSV(String ruta) {
        lista = FileManager.leerCSV(ruta); // devuelve List<ContenidoAudiovisual>
        System.out.println("✔ Archivo cargado desde: " + ruta);
    }

    // Guarda lista en CSV
    public void guardarCSV(String ruta) {
        FileManager.guardarCSV(ruta, lista);
        System.out.println("✔ Archivo guardado en: " + ruta);
    }

    // Devuelve la lista (opcional)
    public List<ContenidoAudiovisual> getLista() {
        return lista;
    }
}
