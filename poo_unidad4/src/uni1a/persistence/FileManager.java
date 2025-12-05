package uni1a.persistence;

import uni1a.model.*;
import java.io.*;
import java.util.*;

public class FileManager {

    public static void guardarCSV(String ruta, List<ContenidoAudiovisual> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (ContenidoAudiovisual c : lista) {
                // guarda: Tipo;titulo;duracion;genero;campoExtra1;campoExtra2...
                pw.println(c.getClass().getSimpleName() + ";" + c.toString());
            }
        } catch (Exception e) {
            System.out.println("Error guardando archivo: " + e.getMessage());
        }
    }

    public static List<ContenidoAudiovisual> leerCSV(String ruta) {
        List<ContenidoAudiovisual> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");

                // Evitar errores si la línea no tiene suficientes campos
                for (int i = 0; i < datos.length; i++) datos[i] = datos[i].trim();

                String tipo = datos.length > 0 ? datos[0] : "";
                String titulo = datos.length > 1 ? datos[1] : "Sin título";
                int duracion = 0;
                try {
                    duracion = datos.length > 2 ? Integer.parseInt(datos[2]) : 0;
                } catch (NumberFormatException ex) {
                    duracion = 0;
                }
                String genero = datos.length > 3 ? datos[3] : "";

                // Dependiendo del tipo, leer campos extra (si existen) o usar valores por defecto
                if ("Pelicula".equalsIgnoreCase(tipo)) {
                    String estudio = datos.length > 4 ? datos[4] : "";
                    lista.add(new Pelicula(titulo, duracion, genero, estudio));
                } else if ("SerieDeTV".equalsIgnoreCase(tipo)) {
                    int numTemporadas = datos.length > 4 ? parseIntSafe(datos[4]) : 0;
                    lista.add(new SerieDeTV(titulo, duracion, genero, numTemporadas));
                } else if ("Documental".equalsIgnoreCase(tipo)) {
                    String tema = datos.length > 4 ? datos[4] : "";
                    // Documental constructor que usas: (titulo,duracion,genero,tema)
                    lista.add(new Documental(titulo, duracion, genero, tema));
                } else if ("Cortometraje".equalsIgnoreCase(tipo)) {
                    // Si guardaste el nombre del protagonista en campo 4, puedes crear Actor
                    Actor protagonista = (datos.length > 4 && !datos[4].isEmpty())
                            ? new Actor(datos[4], 0)
                            : null;
                    lista.add(new Cortometraje(titulo, duracion, genero, protagonista));
                } else if ("YouTube".equalsIgnoreCase(tipo)) {
                    String canal = datos.length > 4 ? datos[4] : "";
                    int likes = datos.length > 5 ? parseIntSafe(datos[5]) : 0;
                    lista.add(new YouTube(titulo, duracion, genero, canal, likes));
                } else {
                    // tipo desconocido: puedes ignorar o crear un objeto genérico
                    // lista.add(new Pelicula(titulo, duracion, genero, ""));
                }
            }

        } catch (Exception e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return lista;
    }

    // helper
    private static int parseIntSafe(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (Exception e) { return 0; }
    }
}
