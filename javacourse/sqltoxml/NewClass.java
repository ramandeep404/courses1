/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltoxml;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class NewClass {
    private String configFile;

    public void setFile(String configFile) {
        this.configFile = configFile;
    }

    public void saveConfig() throws Exception {
        // create an XMLOutputFactory
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        // create XMLEventWriter
        XMLEventWriter eventWriter = outputFactory
                .createXMLEventWriter(new FileOutputStream(configFile));
        // create an EventFactory
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        // create and write Start Tag
        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);
StartElement configStartElement1 = eventFactory.createStartElement("",
                "", "students");
eventWriter.add(configStartElement1);
        // create config open tag
        
        // Write the different nodes
     /*   createNode(eventWriter, "mode", "1");
        createNode(eventWriter, "unit", "901");
        createNode(eventWriter, "current", "0");
        createNode(eventWriter, "interactive", "0");
*/
        Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://127.0.0.1:3306/abcdef";
		Connection con =DriverManager.getConnection(url,"root", "");
                Statement stmt;
                ResultSet rs;
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * from students");
		int rollno;
                String name="";
                int marks;
		while(rs.next()){
                     StartElement configStartElement = eventFactory.createStartElement("",
                "", "student");
     eventWriter.add(configStartElement);
                rollno=rs.getInt("rollno");
                name=rs.getString("name");
                marks=rs.getInt("marks");
                createNode(eventWriter,"rollno",String.valueOf(rollno));
                createNode(eventWriter,"name",name);
                createNode(eventWriter,"marks",String.valueOf(marks));
                eventWriter.add(eventFactory.createEndElement("", "", "student"));
   
                }
                   
        eventWriter.add(end);
          
        eventWriter.add(eventFactory.createEndDocument());
        
        eventWriter.close();
    }

    private void createNode(XMLEventWriter eventWriter, String name,
            String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
}
