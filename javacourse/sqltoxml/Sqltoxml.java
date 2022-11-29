/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltoxml;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
/**
 *
 * @author raman
 */
public class Sqltoxml {
  private String role1 = null;
private String role2 = null;
private String role3 = null;
private String role4 = null;
private ArrayList rolev;   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        try {
		Statement stmt;
		ResultSet rs;
Document dom;
    Element e = null;

    // instance of a DocumentBuilderFactory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      // use factory to get an instance of document builder
        DocumentBuilder db = dbf.newDocumentBuilder();
        // create instance of DOM
        dom = db.newDocument();

        // create the root element
        Element rootEle = dom.createElement("students");

        dom.appendChild(rootEle);
         
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://127.0.0.1:3306/abcdef";
		Connection con =DriverManager.getConnection(url,"root", "");
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * from students");
		int rollno;
                String name="";
                int marks;
		while(rs.next()){
                rollno=rs.getInt("rollno");
                name=rs.getString("name");
                marks=rs.getInt("marks");
                e = dom.createElement("rollno");
        e.appendChild(dom.createTextNode(String.valueOf(rollno)));
        rootEle.appendChild(e);

        e = dom.createElement("name");
        e.appendChild(dom.createTextNode(name));
        rootEle.appendChild(e);

        e = dom.createElement("marks");
        e.appendChild(dom.createTextNode(String.valueOf(marks)));
        rootEle.appendChild(e);

   

       
		}
           
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(dom),   new StreamResult(new FileOutputStream("c:\\temp\\students.xml")));
System.out.println("done");
       
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
    }
    
}
