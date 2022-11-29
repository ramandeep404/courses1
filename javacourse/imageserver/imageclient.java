/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageserver;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 *
 * @author raman
 */
public class imageclient {
    public static void main(String args[])
    {
        try
        {
    int i;
    FileInputStream fis = new FileInputStream ("c:\\temp\\abcd.jpg");

    Socket sock = new Socket("127.0.0.1", 7801);
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
