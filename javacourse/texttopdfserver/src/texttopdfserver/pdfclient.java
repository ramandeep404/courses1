/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttopdfserver;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.*;
/**
 *
 * @author raman
 */
public class pdfclient {
    public static void main(String args[])
    {
        String a;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter PDF File to Upload");
        a=sc.next();
        try
        {
    int i;
    FileInputStream fis = new FileInputStream (a);

    Socket sock = new Socket("127.0.0.1", 7807);
    DataOutputStream os = new DataOutputStream(sock.getOutputStream());
    while ((i = fis.read()) > -1)
        os.write(i);

    fis.close();
    os.close();
    sock.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
}
}
