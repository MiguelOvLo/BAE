package org.example;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main{
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://movalle49:6YShx2fKabry3d0t@miguel.wlr5fok.mongodb.net/?retryWrites=true&w=majority&appName=Miguel";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("ProyectoBae");
            MongoCollection<Document> collection = database.getCollection("Animu");

            Document doc = collection.find().first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}