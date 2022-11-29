/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodbjava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class readdata {

    public static void main(String[] args) {
try
{
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

            MongoDatabase database = mongoClient.getDatabase("abcdef");

            MongoCollection<Document> collection = database.getCollection("abc");

            try (MongoCursor<Document> cur = collection.find().iterator()) {

                while (cur.hasNext()) {

                    Document doc = cur.next();
                    System.out.println(doc.values());
                }
            }
        }
catch(Exception e)
{
    System.out.println(e.toString());
}
    }
}