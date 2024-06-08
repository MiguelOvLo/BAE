package org.example;

import java.util.List;
import org.example.controlador.ControladorAnime;
import org.example.controlador.ControladorEstudio;
import org.example.controlador.ControladorPersonajes;
import org.example.modelo.Anime;
import org.example.modelo.Personajes;
import org.example.modelo.Estudio;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main{
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://movalle49:6YShx2fKabry3d0t@miguel.wlr5fok.mongodb.net/?retryWrites=true&w=majority&appName=Miguel";

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://movalle49:6YShx2fKabry3d0t@miguel.wlr5fok.mongodb.net/?retryWrites=true&w=majority&appName=Miguel")) {
            MongoDatabase database = mongoClient.getDatabase("ProyectoBae");

            ControladorAnime controladorAnime = new ControladorAnime(database);

            /* Cntrolador de anime */
            controladorAnime.crearAnime("Naruto", "Shonen", "Masashi Kishimoto");
            List<Anime> animes = controladorAnime.obtenerTodos();
            for(Anime anime : animes){
                System.out.println("Anime: "+ anime.getTitulo()+ ", Género: "+anime.getGenero()+", Autor :"+anime.getAutor()+".");
            }

            /* Controlador de peresonajes */
            ControladorPersonajes controladorPersonajes = new ControladorPersonajes(database);
            controladorPersonajes.crearPersonaje("Naruto Uzumaki", "Naruto");
            List<Personajes> personajes = controladorPersonajes.obtenerTodos();
            for(Personajes personaje : personajes){
                System.out.println("Nombre: "+ personaje.getNombre()+ ", Anime: "+personaje.getAnime()+".");
            }    



            /* Controlador de */

            ControladorEstudio controladorEstudio = new ControladorEstudio(database);
            controladorEstudio.crearEstudio("Mappa", "Tokyo");
            List<Estudio> estudios = controladorEstudio.obtenerTodo();
            for(Estudio estudio : estudios){
                System.out.println("Nombre: "+ estudio.getNombre()+ ", Ubicación: "+estudio.getUbicacion()+".");
            } 
        }
    }
}