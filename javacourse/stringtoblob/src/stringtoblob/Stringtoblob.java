/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtoblob;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author raman
 */
public class Stringtoblob {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        String strdata="";
        try {
      File myObj = new File("c:\\temp\\textfile.txt");
      FileInputStream input = new FileInputStream(myObj);
         String driverName = "com.mysql.jdbc.Driver";
		    Class.forName(driverName);
String url ="jdbc:mysql://127.0.0.1:3306/stringblob";
Connection con =DriverManager.getConnection(url,"root", "");
PreparedStatement ps=con.prepareStatement("insert into stringblob values(?)");
ps.setBinaryStream(1,input,(int)myObj.length());
ps.executeUpdate();
System.out.println("Data Written");
     
      
      
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
}
