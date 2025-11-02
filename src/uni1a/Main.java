package uni1a;

public class Main {
    public static void main(String[] args) {

        // ===== ACTORES =====
        Actor actor1 = new Actor("Leonardo DiCaprio", 48);
        Actor actor2 = new Actor("Joseph Gordon-Levitt", 42);
        Actor actor3 = new Actor("Emma Stone", 35);

        // ===== PELÍCULAS =====
        Pelicula pelicula1 = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
        pelicula1.agregarActor(actor1);
        pelicula1.agregarActor(actor2);

        Pelicula pelicula2 = new Pelicula("La La Land", 128, "Musical", "Summit Entertainment");
        pelicula2.agregarActor(actor3);

        // ===== TEMPORADAS Y SERIES DE TV =====
        Temporada temp1 = new Temporada(1, 8);
        Temporada temp2 = new Temporada(2, 9);

        SerieDeTV serie1 = new SerieDeTV("Stranger Things", 50, "Suspense", 2);
        serie1.agregarTemporada(temp1);
        serie1.agregarTemporada(temp2);

        // ===== INVESTIGADORES Y DOCUMENTALES =====
        Investigador investigador1 = new Investigador("David Attenborough", "Naturaleza");
        Documental doc1 = new Documental("Planeta Tierra", 90, "Documental", "Fauna y Flora");
        doc1.setInvestigador(investigador1);

        Investigador investigador2 = new Investigador("Jane Goodall", "Primates");
        Documental doc2 = new Documental("Chimpancés en acción", 75, "Documental", "Comportamiento de primates");
        doc2.setInvestigador(investigador2);

        // ===== CORTOMETRAJES =====
        Actor protagonistaCorto = new Actor("Protagonista Ficticio", 30);
        Cortometraje corto1 = new Cortometraje("Corto Animado", 20, "Animación", protagonistaCorto);

        // ===== VIDEOS DE YOUTUBE =====
        YouTube video1 = new YouTube("Tutorial Java", 15, "Educativo", "Canal Educativo", 1200);
        YouTube video2 = new YouTube("Tips de programación", 10, "Educativo", "CodeMaster", 850);

        // ===== MOSTRAR DETALLES =====
        System.out.println("===== PELÍCULAS =====");
        pelicula1.mostrarDetalles();
        pelicula2.mostrarDetalles();

        System.out.println("===== ACTORES =====");
        System.out.println(actor1);
        System.out.println(actor2);
        System.out.println(actor3);

        System.out.println("===== SERIES DE TV =====");
        serie1.mostrarDetalles();

        System.out.println("===== DOCUMENTALES =====");
        doc1.mostrarDetalles();
        doc2.mostrarDetalles();

        System.out.println("===== CORTOMETRAJES =====");
        corto1.mostrarDetalles();

        System.out.println("===== VIDEOS DE YOUTUBE =====");
        video1.mostrarDetalles();
        video2.mostrarDetalles();
    }
}
