/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtoblob;
import java.io.File;
import java.sql.*;
import java.io.FileOutputStream;

/**
 *
 * @author raman
 */
public class readstringblob {
    public static void main(String args[])
    {
        FileOutputStream fs=null;
 try 
 {
     String driverName = "com.mysql.jdbc.Driver";
		    Class.forName(driverName);
String url ="jdbc:mysql://127.0.0.1:3306/stringblob";
Statement stmt;
		int rs;
		Connection con =DriverManager.getConnection(url,"root", "");
     //Step 1 : Connecting to server and database
    
      PreparedStatement ps= con.prepareStatement("SELECT * FROM stringblob");
     ResultSet rset=ps.executeQuery();
     	    
     byte b[];
     Blob blob;
     int i=1;
     while(rset.next())
     {
      
      
      File f=new File("c:\\temp\\filetext1.txt");
     fs=new FileOutputStream(f);
      blob=rset.getBlob("data");
      b=blob.getBytes(1, (int)blob.length());
      fs.write(b);
     }
     System.out.println("Data Read");
 }
 
 catch (Exception e) 
 {
     System.err.println("Cannot connect ! ");
     e.printStackTrace();
 }
 

    }
}
