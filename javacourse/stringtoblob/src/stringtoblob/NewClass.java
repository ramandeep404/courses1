/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtoblob;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;
/**
 *
 * @author raman
 */
public class NewClass {
    public static void main(String args[])
    {
        int l=0;
        int i=0;
        String le="";
        BigInteger ib;
        String strdata="";
        String filename="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Times ");
        le=sc.nextLine();
        ib=new BigInteger(le);
        System.out.println("Enter filename ");
        filename=sc.nextLine();

        BigInteger j;
        for(j = BigInteger.valueOf(0);j.compareTo(new BigInteger(le))<=0;j=j.add(BigInteger.ONE))
        {
            strdata="abcdef" + " " + strdata;
        }
        try {
      FileWriter myWriter = new FileWriter(filename);
      myWriter.write(strdata);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
                
    }
}
