/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttopdfserver;

import java.io.IOException;

/**
 *
 * @author raman
 */
public class startserver {
    public static void main(String args[])
    {
         try {
         Thread t = new pdfserver();
         t.start();
         System.out.println("Server Started");
      } catch (IOException e) {
         e.printStackTrace();
      }
    }
}
