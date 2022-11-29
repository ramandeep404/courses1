/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertimage;
import java.io.IOException;
/**
 *
 * @author raman
 */
public class Convertimage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         String inputImage = "c:\\temp\\barchart.jpg";
        String oututImage = "c:\\temp\\barchart.png";
        String formatName = "PNG";
        try {
            boolean result = ImageConverter.convertFormat(inputImage,
                    oututImage, formatName);
            if (result) {
                System.out.println("Image converted successfully.");
            } else {
                System.out.println("Could not convert image.");
            }
        } catch (IOException ex) {
            System.out.println("Error during converting image.");
            ex.printStackTrace();
        }
    }
    
}
