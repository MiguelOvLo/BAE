package org.example.repositorio;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.modelo.Anime;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class RepositorioAnime {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public RepositorioAnime() {
        this.mongoClient = new MongoClient("localhost", 27017);
        this.database = mongoClient.getDatabase("ProyectoBae");
        this.collection = database.getCollection("Animu");
    }

    public void crearAnime (Anime anime){
        Document document = new Document("Título", anime.getTitulo())
        .append("Género", anime.getGenero())
        .append("Autor", anime.getAutor());
        collection.insertOne(document);
        anime.setId(document.getObjectId("_id").toString());
    }

    public Anime obtenerAnimePorTitulo(String titulo){
        Document doc = collection.find(eq("Título", titulo)).first();
        if (doc !=null) {
            Anime anime = new Anime(doc.getString("Título"), doc.getString("Género"), doc.getString("Autor"));
            anime.setId(doc.getObjectId("_id").toString());
            return anime;
        }
        return null;
    }

    public Anime obtenerTodos(){
        List<Anime> animes = new ArrayList<>();
        for(Document doc : collection.find()){
            Anime anime = new Anime(doc.getString("Título"), doc.getString("Género"), doc.getString("Autor"));
            anime.setId(doc.getObjectId("_id").toString());
            animes.add(anime);
        }
        return (Anime) animes;
    }

    public void actualizarAnime(String titulo, Bson actualizado){
        collection.updateOne(eq("Título", titulo), actualizado);
    }

    public void eliminarAnime(String titulo){
        collection.deleteOne(eq("Título", titulo));
    }

    public void cerrarMongo(){
        mongoClient.close();
    }
}
