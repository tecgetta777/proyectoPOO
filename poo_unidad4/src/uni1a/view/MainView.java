package uni1a.view;

import java.util.Scanner;
import uni1a.controller.ContenidoController;
import uni1a.model.*;

public class MainView {

    private ContenidoController controller;
    private Scanner scanner;

    public MainView() {
        this.controller = new ContenidoController();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarContenido();
                    break;
                case 2:
                    listarContenido();
                    break;
                case 3:
                    cargarDesdeArchivo();
                    break;
                case 4:
                    guardarEnArchivo();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE CONTENIDO AUDIOVISUAL =====");
        System.out.println("1. Agregar Contenido");
        System.out.println("2. Listar Contenidos");
        System.out.println("3. Cargar desde Archivo CSV");
        System.out.println("4. Guardar en Archivo CSV");
        System.out.println("0. Salir");
        System.out.println("============================================");
    }

    private void agregarContenido() {
        System.out.println("\n--- AGREGAR CONTENIDO ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        int duracion = leerEntero("Duración en minutos: ");

        System.out.print("Tipo (Pelicula / Serie / Documental / Cortometraje): ");
        String tipo = scanner.nextLine().trim().toLowerCase();

        ContenidoAudiovisual c = null;

        switch (tipo) {
            case "pelicula":
                c = new Pelicula(titulo, duracion, "Pelicula");
                break;
            case "serie":
                c = new SerieDeTV(titulo, duracion, "Serie");
                break;
            case "documental":
                c = new Documental(titulo, duracion, "Documental");
                break;
            case "cortometraje":
                c = new Cortometraje(titulo, duracion, "Cortometraje");
                break;
            default:
                System.out.println("Tipo no válido. No se agregó contenido.");
                return;
        }

        controller.agregarContenido(c);
        System.out.println("✔ Contenido agregado exitosamente.");
    }

    private void listarContenido() {
        System.out.println("\n--- LISTA DE CONTENIDOS ---");
        controller.mostrarTodos();
    }

    private void cargarDesdeArchivo() {
        System.out.print("Ingrese ruta del archivo CSV: ");
        String nombre = scanner.nextLine();
        controller.cargarCSV(nombre);
    }

    private void guardarEnArchivo() {
        System.out.print("Ingrese ruta del archivo CSV: ");
        String nombre = scanner.nextLine();
        controller.guardarCSV(nombre);
    }

    private int leerEntero(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese un número válido.");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return num;
    }
}
