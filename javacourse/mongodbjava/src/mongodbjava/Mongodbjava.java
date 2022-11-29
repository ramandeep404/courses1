/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodbjava;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;


/**
 *
 * @author raman
 */
public class Mongodbjava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongo = new MongoClient("localhost", 27017);
 MongoDatabase database = mongo.getDatabase("abcdef");
      //Creating a collection
      //database.createCollection("students");
      //Preparing a document
      Document document = new Document();
      document.append("name", "Ram");
      document.append("age", 26);
      document.append("city", "Hyderabad");
      //Inserting the document into the collection
      database.getCollection("abc").insertOne(document);
      System.out.println("Document inserted successfully");

    }
    
}
