/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageconv;

import java.io.IOException;
 
public class TestImageConverter {
 
    public static void main(String[] args) {
        String inputImage = "c:\\temp\\abcd.jpg";
        String oututImage = "c:\\temp\\abcd.png";
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
