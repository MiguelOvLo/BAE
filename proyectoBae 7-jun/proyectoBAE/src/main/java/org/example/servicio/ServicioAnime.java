package org.example.servicio;

import java.util.List;

import org.bson.conversions.Bson;
import org.example.modelo.Anime;
import org.example.repositorio.RepositorioAnime;

import com.mongodb.client.model.Updates;

public class ServicioAnime {
    private RepositorioAnime repositorioAnime;

    public ServicioAnime(){
        this.repositorioAnime = new RepositorioAnime();
    }

    public void añadirAnime(Anime anime){
        repositorioAnime.crearAnime(anime);
    }

    public Anime obtenerAnimePorTitulo(String titulo){
        return repositorioAnime.obtenerAnimePorTitulo(titulo);
    }

    public List<Anime> obtenerTodos(){
        return (List<Anime>) repositorioAnime.obtenerTodos();
    }

    public void actualizarAutor(String titulo, String autor){
        Bson actualizar = Updates.set("Autor",autor);
        repositorioAnime.actualizarAnime(titulo, actualizar);
    }

    public void eliminarAnime(String titulo){
        repositorioAnime.eliminarAnime(titulo);
    }

    public void cerrarMongo(){
        repositorioAnime.cerrarMongo();
    }
}
