/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltoxml;

/**
 *
 * @author raman
 */
public class TestWrite {
  
    public static void main(String[] args) {
        NewClass configFile = new NewClass();
        configFile.setFile("c:\\temp\\abcde.xml");
        try {
            configFile.saveConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

