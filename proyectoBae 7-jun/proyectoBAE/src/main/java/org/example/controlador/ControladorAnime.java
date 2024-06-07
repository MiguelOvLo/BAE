package org.example.controlador;

import java.util.List;
import java.util.Scanner;

import org.example.modelo.Anime;
import org.example.servicio.ServicioAnime;

public class ControladorAnime {
    private ServicioAnime servicioAnime;

    public ControladorAnime(){
        this.servicioAnime = new ServicioAnime();
    }

    public void inicio(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Añadir serie");
            System.out.println("2. Obtener serie por titulo ");
            System.out.println("3. Obtener todas las series");
            System.out.println("4. Modificar genero");
            System.out.println("5. Eliminar serie");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){

                case 1: 
                    System.out.println("Inserte el título");
                    String titulo = scanner.nextLine();
                    System.out.println("Inserte el género");
                    String genero = scanner.nextLine();
                    System.out.println("Inserte nombre del autor");
                    String autor = scanner.nextLine();
                    Anime anime = new Anime(titulo, genero, autor);
                    servicioAnime.añadirAnime(anime);
                    break;

                case 2: 
                    System.out.println("Introduzca el título:");
                    titulo = scanner.nextLine();
                    Anime animeEncontrado = servicioAnime.obtenerAnimePorTitulo(titulo);
                    System.out.println(animeEncontrado);
                    break;

                case 3:
                    List<Anime> animes = servicioAnime.obtenerTodos();
                    for(Anime a : animes) {
                        System.out.println(a);
                    }
                    break;
                
                case 4:
                    System.out.println("Introduzca un titulo:");
                    titulo = scanner.nextLine();
                    System.out.println("Inserte un nuevo autor:");
                    autor = scanner.nextLine();
                    servicioAnime.actualizarAutor(titulo, autor);
                    break;
            }
        }
    }
}
