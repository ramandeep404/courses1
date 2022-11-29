/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttopdfserver;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author raman
 */
public class pdfserver extends Thread{
 private ServerSocket serverSocket;
 public pdfserver() throws IOException
 {
     serverSocket = new ServerSocket(7807);
 }
      public void run() {
      while(true) {
         try {
          Socket clientSocket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            FileOutputStream fout = new FileOutputStream("c:\\temps\\abcd.txt");
            int i;
            while ( (i = dis.read()) > -1) {
                fout.write(i);
            }
            fout.close();
            String data="";
             File myObj = new File("c:\\temps\\abcd.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data = data + myReader.nextLine();
      }
              Document document = new Document(new Rectangle(PageSize.A4));    
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c:\\temps\\pdffile1.pdf"));    
    document.open();    
	    document.add(new Paragraph(data));
     document.close();
          System.out.println("PDF File Generated");
                  
         } catch (Exception s) {
            System.out.println(s.toString());
            break;
         }
      }
   }
  
    
}
