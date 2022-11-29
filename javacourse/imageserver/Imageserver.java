/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author raman
 */
public class Imageserver extends Thread{
 private ServerSocket serverSocket;
 public Imageserver() throws IOException
 {
     serverSocket = new ServerSocket(7801);
 }
      public void run() {
      while(true) {
         try {
          Socket clientSocket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            FileOutputStream fout = new FileOutputStream("c:\\temps\\image.jpg");
            int i;
            while ( (i = dis.read()) > -1) {
                fout.write(i);
            }
            
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
