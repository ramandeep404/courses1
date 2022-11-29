/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipfileserver;

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
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author raman
 */
public class zipserver extends Thread{
 private ServerSocket serverSocket;
 public zipserver() throws IOException
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
            byte[] buffer = new byte[1024];
 
    	
 
    		FileOutputStream fos = new FileOutputStream("C:\\temps\\abcdzip.zip");
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry("abc.txt");
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream("C:\\temps\\abcd.txt");
 
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}
 
    		in.close();
    		zos.closeEntry();
 
    		//remember close it
    		zos.close();
            
         } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
         } catch (IOException e) {
            e.printStackTrace();
            break;
         }
      }
   }
  
    
}
